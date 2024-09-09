package com.senai.trabalho.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.Objects;

public class Veiculo {

    private Long id;
    @NotBlank(message = "A marca do veículo é obrigatória.")
    private String marca;
    @NotBlank(message = "O modelo do veículo é obrigatório.")
    private String modelo;
    @NotNull(message = "O ano do veículo é obrigatório.")
    private int ano;
    @NotNull(message = "A quilometragem do veículo é obrigatória.")
    private int quilometragem;
    
    private boolean disponivel;
   
    @NotBlank(message = "A categoria do veículo é obrigatória.")
    @Pattern(regexp = "Econômico|SUV|Luxo", message = "A categoria deve ser 'Econômico', 'SUV' ou 'Luxo'.")
    private String categoria;

    public Veiculo() {
    }

    public Veiculo(Long id, String marca, String modelo, int ano, int quilometragem, boolean disponivel, String categoria) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.disponivel = disponivel;
        this.categoria = categoria;
    }

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

    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", quilometragem=" + quilometragem + ", disponivel=" + disponivel + ", categoria=" + categoria + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.marca);
        hash = 17 * hash + Objects.hashCode(this.modelo);
        hash = 17 * hash + this.ano;
        hash = 17 * hash + this.quilometragem;
        hash = 17 * hash + (this.disponivel ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.categoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (this.quilometragem != other.quilometragem) {
            return false;
        }
        if (this.disponivel != other.disponivel) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}
