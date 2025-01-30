package com.example.rev_eshop.service;

import com.example.rev_eshop.repository.ShopUserRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.rev_eshop.model.ShopUser;

@Service
@Transactional
public class ShopUserService {
    ShopUserRepository sur;

    ShopUserService(ShopUserRepository sur){
        this.sur = sur;
    }

    public ShopUser createUser(ShopUser shopUser){
        ShopUser newUser = sur.save(shopUser);
        System.out.println(newUser);
        return newUser;
    }
}
