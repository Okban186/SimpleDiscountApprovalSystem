package com.spring.app.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.spring.app.Enum.DiscountStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String drId;

  @Column(precision = 19, scale = 4)
  BigDecimal requestedDiscount;

  @Enumerated(EnumType.STRING)
  DiscountStatus status;

  @ManyToOne
  UserAccount requestedBy;

  @ManyToOne
  UserAccount approvedBy;

  @CreatedDate
  LocalDateTime requestedAt;

  LocalDateTime approvedAt;

}
