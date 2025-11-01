package com.spring.app.Entity;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
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

class Product {

  @Id

  @GeneratedValue(strategy = GenerationType.UUID)
  String productId;

  @Column(columnDefinition = "VARCHAR(100) unique")
  @Size(min = 10)
  String code;

  String name;

  @Column(precision = 10, scale = 3)
  BigDecimal weight;

  @Column(precision = 19, scale = 4)
  BigDecimal laborCost;

  @Column(name = "stone_cost", precision = 19, scale = 4)
  BigDecimal stoneCost;

  @Column(name = "price_rate", nullable = false, precision = 5, scale = 4)
  BigDecimal priceRate;

  @Column(name = "is_precious_stone", nullable = false)
  boolean isPreciousStone;

  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
  Set<OrderItem> orderItems;

}
