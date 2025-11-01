package com.spring.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.Entity.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, String> {

}
