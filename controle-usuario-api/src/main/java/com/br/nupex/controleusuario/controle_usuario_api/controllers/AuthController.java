package com.br.nupex.controleusuario.controle_usuario_api.controllers;

import com.br.nupex.controleusuario.controle_usuario_api.domain.user.User;
import com.br.nupex.controleusuario.controle_usuario_api.dto.LoginRequestDTO;
import com.br.nupex.controleusuario.controle_usuario_api.dto.RegisterRequestDTO;
import com.br.nupex.controleusuario.controle_usuario_api.dto.ResponseDTO;
import com.br.nupex.controleusuario.controle_usuario_api.infra.security.TokenService;
import com.br.nupex.controleusuario.controle_usuario_api.repositories.UserRepository;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO body) {
        User user = repository.findByEmail(body.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token, user.getRoles()));
        }
        return ResponseEntity.status(401).body("Senha incorreta");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO body) {
        Optional<User> existingUser = repository.findByEmail(body.email());

        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("E-mail já registrado");
        }

        User newUser = new User();
        newUser.setEmail(body.email());
        newUser.setPassword(passwordEncoder.encode(body.password()));
        newUser.setName(body.name());

        if (body.email().equals("admin@domain.com")) {
            newUser.setRoles(Set.of("ROLE_USER", "ROLE_ADMIN"));
        } else {
            newUser.setRoles(Set.of("ROLE_USER"));
        }

        repository.save(newUser);
        String token = tokenService.generateToken(newUser);
        return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token, newUser.getRoles()));
    }
}
