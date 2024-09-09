package com.senai.trabalho.DTO;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    // Construtor vazio
    public ClienteDTO() {
    }

    // Construtor completo
    public ClienteDTO(Long id, String nome, String cpf, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getters e Setters
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // toString
    @Override
    public String toString() {
        return "ClienteDTO{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", cpf='" + cpf + '\''
                + ", endereco='" + endereco + '\''
                + ", telefone='" + telefone + '\''
                + '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClienteDTO that = (ClienteDTO) o;

        if (!id.equals(that.id)) {
            return false;
        }
        if (!nome.equals(that.nome)) {
            return false;
        }
        if (!cpf.equals(that.cpf)) {
            return false;
        }
        if (!endereco.equals(that.endereco)) {
            return false;
        }
        return telefone.equals(that.telefone);
    }

    // hashCode
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + endereco.hashCode();
        result = 31 * result + telefone.hashCode();
        return result;
    }
}
