package com.spring.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
