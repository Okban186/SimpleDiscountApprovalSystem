package com.spring.app.Security.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomeJwtDecoder implements JwtDecoder {

  @NonNull
  NimbusJwtDecoder nimbusJwtDecoder;

  @NonNull
  @Value("${jwt-secret-key}")
  protected String secretKey;

  @Override
  public Jwt decode(String token) throws JwtException {
    return null;
  }

}
