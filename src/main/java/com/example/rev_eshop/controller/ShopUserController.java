package com.example.rev_eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rev_eshop.dto.ShopUserResponse;
import com.example.rev_eshop.service.JwtService;


@RestController
@RequestMapping("/api/v1/shopuser")
public class ShopUserController {
    
    @Autowired
    JwtService jwts;

    @GetMapping("/currentuser")
    @ResponseBody ResponseEntity<ShopUserResponse> getShopUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        ShopUserResponse currentUser = new ShopUserResponse();
        currentUser.setUsername(currentPrincipalName);
        return ResponseEntity.status(200).body(currentUser);
    }
}
