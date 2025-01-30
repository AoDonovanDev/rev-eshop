package com.example.rev_eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.rev_eshop.dto.AuthenticationRequest;
import com.example.rev_eshop.dto.AuthenticationResponse;
import com.example.rev_eshop.dto.RegisterRequest;
import com.example.rev_eshop.model.ShopRole;
import com.example.rev_eshop.model.ShopUser;
import com.example.rev_eshop.repository.ShopUserRepository;

@Service
public class AuthenticationService {
    
    @Autowired
    ShopUserRepository sur;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        ShopUser newUser = new ShopUser();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setShopRole(ShopRole.BUYER);
        sur.save(newUser);
        String jwtToken = jwtService.generateToken(newUser);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        ShopUser user = sur.findByUsername(request.getUsername()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }
}
