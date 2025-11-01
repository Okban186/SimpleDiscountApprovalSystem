package com.spring.app.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
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
public class UserAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String userId;

  String userName;
  String name;
  String passWord;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  Set<Role> roles;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_permission", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
  Set<Permission> extraPermission;

  @ManyToOne
  Counter counter;

  @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
  Set<Order> orders;

  @OneToMany(mappedBy = "requestedBy", fetch = FetchType.LAZY)
  Set<DiscountRequest> discountRequests;
}
