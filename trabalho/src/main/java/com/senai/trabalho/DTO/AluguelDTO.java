
package com.senai.trabalho.DTO;

import java.time.LocalDate;


public class AluguelDTO {

    private Long id;
    private ClienteDTO cliente;
    private VeiculoDTO veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double valorTotal;

    // Construtor vazio
    public AluguelDTO() {
    }

    // Construtor completo
    public AluguelDTO(Long id, ClienteDTO cliente, VeiculoDTO veiculo, LocalDate dataInicio, LocalDate dataFim, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public VeiculoDTO getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoDTO veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // toString
    @Override
    public String toString() {
        return "AluguelDTO{"
                + "id=" + id
                + ", cliente=" + cliente
                + ", veiculo=" + veiculo
                + ", dataInicio=" + dataInicio
                + ", dataFim=" + dataFim
                + ", valorTotal=" + valorTotal
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

        AluguelDTO that = (AluguelDTO) o;

        if (Double.compare(that.valorTotal, valorTotal) != 0) {
            return false;
        }
        if (!id.equals(that.id)) {
            return false;
        }
        if (!cliente.equals(that.cliente)) {
            return false;
        }
        if (!veiculo.equals(that.veiculo)) {
            return false;
        }
        if (!dataInicio.equals(that.dataInicio)) {
            return false;
        }
        return dataFim.equals(that.dataFim);
    }

    // hashCode
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + cliente.hashCode();
        result = 31 * result + veiculo.hashCode();
        result = 31 * result + dataInicio.hashCode();
        result = 31 * result + dataFim.hashCode();
        temp = Double.doubleToLongBits(valorTotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
