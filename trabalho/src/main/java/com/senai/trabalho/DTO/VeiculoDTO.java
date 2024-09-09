package com.senai.trabalho.DTO;

public class VeiculoDTO {

    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private int quilometragem;
    private boolean disponivel;
    private String categoria;

    // Construtor padrão
    public VeiculoDTO() {
    }

    // Construtor com parâmetros
    public VeiculoDTO(Long id, String marca, String modelo, int ano, int quilometragem, boolean disponivel, String categoria) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.disponivel = disponivel;
        this.categoria = categoria;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // toString
    @Override
    public String toString() {
        return "VeiculoDTO{"
                + "id=" + id
                + ", marca='" + marca + '\''
                + ", modelo='" + modelo + '\''
                + ", ano=" + ano
                + ", quilometragem=" + quilometragem
                + ", disponivel=" + disponivel
                + ", categoria='" + categoria + '\''
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

        VeiculoDTO that = (VeiculoDTO) o;

        if (ano != that.ano) {
            return false;
        }
        if (quilometragem != that.quilometragem) {
            return false;
        }
        if (disponivel != that.disponivel) {
            return false;
        }
        if (!id.equals(that.id)) {
            return false;
        }
        if (!marca.equals(that.marca)) {
            return false;
        }
        if (!modelo.equals(that.modelo)) {
            return false;
        }
        return categoria.equals(that.categoria);
    }

    // hashCode
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + marca.hashCode();
        result = 31 * result + modelo.hashCode();
        result = 31 * result + ano;
        result = 31 * result + quilometragem;
        result = 31 * result + (disponivel ? 1 : 0);
        result = 31 * result + categoria.hashCode();
        return result;
    }
}
