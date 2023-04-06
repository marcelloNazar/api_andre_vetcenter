package vet.center.api.infra.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {


    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);
        var subject = tokenService.getSubject(tokenJWT);



        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {

        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) {
            throw new RuntimeException("Token não enviado");
        }
        return authHeader.replace("Bearer", "");
    }
}
