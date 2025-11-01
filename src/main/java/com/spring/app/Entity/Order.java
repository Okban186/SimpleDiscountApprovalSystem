package com.spring.app.Entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.DialectOverride.FilterDefOverrides;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String orderID;

  @CreatedDate
  LocalDateTime createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  UserAccount staff;

  @ManyToOne(fetch = FetchType.LAZY)
  Customer customer;

  @OneToMany(mappedBy = "order")
  Set<OrderItem> orderItems;

  @ManyToMany(mappedBy = "appliedOrders")
  Set<Promotion> promotions;

}
