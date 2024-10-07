package com.senai.clientes.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class ClienteDTO {

    private Long codigo;
    
    @NotNull (message = "Nome é obrigatório")
    private String nome;
    
    @NotNull(message = "Email é obrigatório")
    @Email (message = "Email deve ser valido")
    private String email;
    
    @NotNull (message = "Telefone é obrigatório")
    private String telefone;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;
    private String endereco;
    private Integer numeroEndereco;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(Integer numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

}
