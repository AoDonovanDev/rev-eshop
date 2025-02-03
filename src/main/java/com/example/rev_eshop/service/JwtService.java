package com.example.rev_eshop.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;



@Service
public class JwtService {
    
    private static final String SECRET_KEY = "e0b01725d2e0d5ee23dd1bb188ea7091a3ab7da27b7bd9829a09273018113446c3042a3fc0033c7de7433e4dd2905b040606c9938ae120d049e00821f2f043959467fe5eb1af3c8b76872891c39e1680a9cc8739f058c0ea09986d832f15fe7d66e63225dd46e7284b59b64798bbaa4e35c09998227be93333db1bdd70a2b56c6593acf8eedd2d1beff1f5a457d4bdc50328c05ffadec7b16fb8c5d54eabe5747658e1b4ab46f3a9f61c74376337ca333638862b970df8f704366bc11eb1dc46a1874c95207208c515058274c6b9249c8555f837d5b6d6947cf389488c9484470ec02f9df6e6184473183d609ad713ab0a9ab0f8bff06b9ac2613bc803d9cb79";

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .setSigningKey(getSigningKey())
                                .build()
                                .parseClaimsJws(token)
                                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
        Map<String, Object> extraClaims,
        UserDetails userDetails
    ) {
        return Jwts
        .builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
    }
            
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = userDetails.getUsername();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

}
