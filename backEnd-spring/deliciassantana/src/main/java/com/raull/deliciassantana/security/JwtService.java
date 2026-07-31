package com.raull.deliciassantana.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.raull.deliciassantana.entitys.FuncionarioEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JwtService {

    // Em produção isso viria de application.properties / variável de ambiente, nunca hardcoded
    private static final String SECRET = "minha-chave-secreta-troque-isso-depois";
    private final Algorithm algoritmo = Algorithm.HMAC256(SECRET);

    public String gerarToken(FuncionarioEntity funcionario) {
        return JWT.create()
                .withSubject(funcionario.getLogin())
                .withClaim("role", funcionario.getRole().name())
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plus(8, ChronoUnit.HOURS))
                .sign(algoritmo);
    }

    public String extrairLogin(String token) {
        DecodedJWT decoded = JWT.require(algoritmo)
                .build()
                .verify(token);
        return decoded.getSubject();
    }

    public boolean tokenValido(String token) {
        try {
            JWT.require(algoritmo)
                    .build()
                    .verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
