package com.codiblau.autoprogramacio.manager;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class TokenManager {

    @Autowired
    private Environment environment;


    public String createToken(String email) {
        return Jwts.builder()
                .claim("email", email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600000 * 24 * 7)) //1 setmana
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(environment.getProperty("jwt.secret")))
                .compact();
    }

    public TokenResponse validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(environment.getProperty("jwt.secret").getBytes())
                    .parseClaimsJws(token)
                    .getBody();
            return TokenResponse.OK;
        } catch (ExpiredJwtException e) {
            return TokenResponse.EXPIRED;
        } catch (Exception e) {
            return TokenResponse.ERROR;
        }
    }

    public Claims getClaims(HttpServletRequest request){
        String auth = request.getHeader("Authorization");
        String token = auth.replace("Bearer ", "");
        return getClaims(token);
    }

    public Claims getClaims(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(environment.getProperty("jwt.secret").getBytes())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

}