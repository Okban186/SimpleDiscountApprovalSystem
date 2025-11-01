package com.spring.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.Entity.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, String> {

}
