package com.example.rev_eshop.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ShopUser")
public class ShopUser implements UserDetails {
    
    @Column(name="shopUserId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shopUserId;

    @Column(name="shopRole")
    @Enumerated(EnumType.STRING)
    private ShopRole shopRole;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public ShopUser() {
    }

    public Integer getShopUserId() {
        return shopUserId;
    }

    public void setShopUserId(Integer shopUserId) {
        this.shopUserId = shopUserId;
    }

    public ShopRole getShopRole() {
        return shopRole;
    }

    public void setShopRole(ShopRole shopRole) {
        this.shopRole = shopRole;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(shopRole.name()));
    }

    @Override
    public String toString() {
        return "user info : \n username: " + this.username + "\n ShopRole: " + this.shopRole.name() + "\n shopUserId: " + this.shopUserId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

}
