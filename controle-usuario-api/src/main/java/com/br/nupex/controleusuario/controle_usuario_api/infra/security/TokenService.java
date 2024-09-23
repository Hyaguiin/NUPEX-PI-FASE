package com.br.nupex.controleusuario.controle_usuario_api.infra.security;

import java.sql.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.br.nupex.controleusuario.controle_usuario_api.domain.user.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(User user) {
        return Jwts.builder()
            .setSubject(user.getEmail())
            .claim("roles", user.getRoles())  // Adiciona roles ao token JWT
            .setIssuer("controle-usuario-api")
            .setExpiration(new Date(System.currentTimeMillis() + 600000)) // Isso aq vai deixar ele validad o por 10 minutos, q ja e o suficiente, acredito eu 
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }

    public String validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
            return claims.getSubject();
        } catch (JwtException e) {
            System.out.println("Token inválido: " + e.getMessage());
            return null;
        }
    }
}
