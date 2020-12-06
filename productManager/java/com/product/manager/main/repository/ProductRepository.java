package com.product.manager.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.manager.main.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
