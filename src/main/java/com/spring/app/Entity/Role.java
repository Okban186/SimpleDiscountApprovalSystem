package com.spring.app.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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

class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String roleID;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "RolePermission", joinColumns = @JoinColumn(name = "roleID"), inverseJoinColumns = @JoinColumn(name = "permissionID"))
  Set<Permission> permissions;

  @ManyToMany(mappedBy = "roles")
  Set<UserAccount> userAccounts;
}
