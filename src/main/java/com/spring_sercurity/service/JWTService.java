package com.spring_sercurity.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JWTService {
    private String secretKey="";

    public JWTService(){
        try {
            KeyGenerator keyGen=KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secretKey =Base64.getEncoder().encodeToString(sk.getEncoded());



        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String username) {

        Map <String,Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new  Date(System.currentTimeMillis()))
                .expiration(new  Date(System.currentTimeMillis() + 10*  60 * 1000))
                .and()
                .signWith(getAuthKey())
                .compact();
    }
    private SecretKey getAuthKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        System.out.println("Secret key ::"+secretKey);
        System.out.println("key Bytes ::"+keyBytes);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extractClaims(token,  Claims::getSubject);
    }

    private <T> T  extractClaims(String token, Function<Claims,T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);

    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getAuthKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username  = extractUsername(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token ,Claims::getExpiration);
    }
}
