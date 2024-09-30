package com.senai.login.controller;

import com.senai.login.model.UsuarioModel;
import com.senai.login.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioModel usuario) {
        boolean autenticado = authService.autenticar(usuario.getLogin(), usuario.getSenha());
        if (autenticado) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.ok("Credenciais invalidas");
        }

    }
}
