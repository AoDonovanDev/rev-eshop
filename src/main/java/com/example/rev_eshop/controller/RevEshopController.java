package com.example.rev_eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rev_eshop.model.ShopUser;
import com.example.rev_eshop.service.ShopUserService;

@RestController
public class RevEshopController {

    @Autowired
    ShopUserService sus;

    @GetMapping("/")
    public @ResponseBody ResponseEntity<String> home(){
        return ResponseEntity.status(200).body("Hello!");
    }

    @PostMapping("/user")
    public @ResponseBody ResponseEntity<ShopUser> createUser(@RequestBody ShopUser shopUser){
        try {
            ShopUser newUser = sus.createUser(shopUser);
            System.out.println("helooooooooo: " + shopUser);
            return ResponseEntity.status(200).body(newUser);
        } catch(Exception ex){
            return ResponseEntity.status(200).body(null);
        }
        
    }
}