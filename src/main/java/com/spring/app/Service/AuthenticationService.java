package com.spring.app.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.spring.app.Dto.Response.ApiResponse;
import com.spring.app.Entity.UserAccount;

import ch.qos.logback.core.joran.util.ParentTag_Tag_Class_Tuple;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationService {

  @Value("${jwt-secret-key}")
  String secretKey;

  public ApiResponse introspect(String token) {
    boolean isvalid = true;
    try {
      verifyToken(token);

    } catch (RuntimeException | JOSEException | ParseException e) {
      isvalid = false;
    }
    return ApiResponse.builder().resut(isvalid).build();
  }

  public SignedJWT verifyToken(String token) throws JOSEException, ParseException {
    JWSVerifier jwsVerifier = new MACVerifier(secretKey.getBytes());

    SignedJWT signedJWT = SignedJWT.parse(token);

    Date expi = signedJWT.getJWTClaimsSet().getExpirationTime();

    boolean isvalid = signedJWT.verify(jwsVerifier);

    if (!(isvalid && expi.after(new Date())))
      throw new RuntimeException();

    return signedJWT;
  }

  public String generateToken(UserAccount user) {
    JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);

    JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
        .subject(user.getName())
        .issuer("Okban.com")
        .issueTime(new Date())
        .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
        .jwtID(UUID.randomUUID().toString())
        .claim("scope", buildScope(user))
        .build();

    Payload payload = new Payload(jwtClaimsSet.toJSONObject());

    JWSObject jwsObject = new JWSObject(jwsHeader, payload);

    try {
      jwsObject.sign(new MACSigner(secretKey.getBytes()));
      return jwsObject.serialize();
    } catch (Exception e) {
      throw new RuntimeException("Can't not create this token", e);
    }
  }

  public String buildScope(UserAccount user) {
    StringJoiner stringJoiner = new StringJoiner(" ");
    if (!CollectionUtils.isEmpty(user.getRoles())) {
      user.getRoles().forEach(role -> {
        stringJoiner.add(role.getName());
      });
    }
    return stringJoiner.toString();
  }

}
