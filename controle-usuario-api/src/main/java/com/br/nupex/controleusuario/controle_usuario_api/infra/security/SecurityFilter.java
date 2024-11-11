package com.br.nupex.controleusuario.controle_usuario_api.infra.security;

import com.br.nupex.controleusuario.controle_usuario_api.domain.user.User;
import com.br.nupex.controleusuario.controle_usuario_api.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = extractToken(request);
                //validação
        if (token != null && tokenService.validateToken(token)) {

            String login = tokenService.getUsername(token);

            if (login != null) {
                User user = userRepository.findByEmail(login)
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

                // define role
                var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

                // create auth
                var authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);

                
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("Usuário autenticado: " + user.getEmail());
            } else {
                System.out.println("Token inválido");
            }
        }

        
        filterChain.doFilter(request, response);
    }

    
    private String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7); 
        }
        return null;
    }
}
