package com.example.rev_eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rev_eshop.model.ShopUser;

import java.util.Optional;

public interface ShopUserRepository extends JpaRepository<ShopUser, Integer> {
    Optional<ShopUser> findByUsername(String username);
    
} 
