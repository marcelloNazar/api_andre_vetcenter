package vet.center.api.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vet.center.api.domain.user.UserJPA;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceApi {

    @Value("${api.security.token.secret}")
    private String secret;


    public String gerarToken(UserJPA userJPA) {
        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API vetcenter")
                    .withSubject(userJPA.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o token", exception);
        }
    }

    public String getSubject(String token) {
        try {
            var algorimo = Algorithm.HMAC256(secret);
            return JWT.require(algorimo)
                    .withIssuer("API vetcenter")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Token expirado ou invalido");
        }

    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusDays(7).toInstant(ZoneOffset.of("-03:00"));
    }

}
