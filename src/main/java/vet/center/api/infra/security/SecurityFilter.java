package vet.center.api.infra.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import vet.center.api.domain.user.UserRepository;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenServiceApi tokenService;

    @Autowired
    private UserRepository repository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("chamando");
        var token = recuperarToken(request);

        if (token != null) {
            System.out.println("LOGANDO11");
            var subject = tokenService.getSubject(token);

            var user = repository.findByLogin(subject);
            System.out.println("LOGANDO33");

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("LOGANDO");
        }
            filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {

        var authHeader = request.getHeader("Authorization");

        if(authHeader != null) {
            System.out.println(authHeader);
            return  authHeader.replace("Bearer", "");
        }

        return null;
    }
}
