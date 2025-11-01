package com.spring.app.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String customerID;

  String name;

  String phone;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
  Set<OrderItem> orderItems;

}
