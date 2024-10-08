package com.senai.login.models;

import jakarta.persistence.*;

@Entity
@Table (name= "USUARIOS")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    private String senha;

    public UsuarioModel() {

    }

    public UsuarioModel(Long id, String nome, String login, String senha) {
    
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
