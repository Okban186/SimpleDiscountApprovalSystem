package com.spring.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
