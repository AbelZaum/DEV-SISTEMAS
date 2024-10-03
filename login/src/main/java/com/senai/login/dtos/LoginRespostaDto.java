package com.senai.login.dtos;

public class LoginRespostaDto {

    private String mensagem;

    public LoginRespostaDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
