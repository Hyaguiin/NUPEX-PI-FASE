package com.br.nupex.controleusuario.controle_usuario_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/cors")
    public ResponseEntity<String> testCors() {
        return ResponseEntity.ok("CORS configurado corretamente!");
    }
}
