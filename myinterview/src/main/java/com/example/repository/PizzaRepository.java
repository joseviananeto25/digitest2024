package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long>{
    
}
