package com.spring.app.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

class Permission {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String permissionId;

  String name;

  @ManyToMany(mappedBy = "permissions")
  Set<Role> role;

  @ManyToMany(mappedBy = "extraPermission")
  Set<UserAccount> userAccounts;
}
