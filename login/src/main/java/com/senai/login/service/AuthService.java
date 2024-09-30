package com.senai.login.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean autenticar(String login, String senha) {
        return "admin".equalsIgnoreCase(login) && "admin".equalsIgnoreCase(senha);
    }
}
