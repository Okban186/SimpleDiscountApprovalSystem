package com.spring.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
