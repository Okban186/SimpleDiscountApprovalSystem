package com.spring.app.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
class Promotion {

  @Id
  @GeneratedValue
  String promotionID;

  @Column(columnDefinition = "NVARCHAR(300)")
  @Size(max = 300, message = "String exceeds allowable length")
  String name;

  @Column(columnDefinition = "NVARCHAR(MAX)")
  String promotionPolicy;

  BigDecimal discountPercentage;

  LocalDateTime startDate;

  LocalDateTime endDate;

  private BigDecimal minOrderValue; // Điều kiện đơn hàng tối thiểu

  private boolean requiresCoupon;
  private String couponCode;

  private int maxUsage; // Giới hạn số lần áp dụng
  private int usedCount; // Số lần đã dùng

  private int priority; // Ưu tiên nếu có nhiều khuyến mãi

  private boolean combinable; // Có thể cộng dồn với khuyến mãi khác không

  @ManyToMany
  @JoinTable(name = "promotion_product", joinColumns = @JoinColumn(name = "promotion_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> applicableProducts;

  @ManyToMany
  @JoinTable(name = "applied_orders", joinColumns = @JoinColumn(name = "promotion_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
  private List<Order> appliedOrders;

}
