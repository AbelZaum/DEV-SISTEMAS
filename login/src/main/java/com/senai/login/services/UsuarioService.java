package com.senai.login.services;

import com.senai.login.models.UsuarioModel;
import com.senai.login.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel cadastrar(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean autenticar(String login, String senha) {
        UsuarioModel usuario = usuarioRepository.findByLogin(login);
        return usuario != null && usuario.getSenha().equals(senha);
    }
}
