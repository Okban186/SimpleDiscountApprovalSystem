package com.spring.app.Entity;

import java.math.BigDecimal;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class OrderItem {

  @Id
  @GeneratedValue()
  String odiID;

  int quantity;

  @Column(precision = 19, scale = 4)
  BigDecimal price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  Product product;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  Order order;
}
