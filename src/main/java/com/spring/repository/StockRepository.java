package com.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.model.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer>{
}
