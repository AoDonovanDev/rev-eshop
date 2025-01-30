package com.example.rev_eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rev_eshop.model.Product;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    public Optional<Product> findByProductId(Integer productId);
}
