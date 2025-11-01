package com.spring.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.Entity.Counter;

@Repository
public interface CounterRepository extends JpaRepository<Counter, String> {

}
