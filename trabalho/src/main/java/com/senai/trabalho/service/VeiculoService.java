package com.senai.trabalho.service;

import com.senai.trabalho.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    private final List<Veiculo> veiculos = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    //  Lista todos os veículos cadastrados no sistema
    public List<Veiculo> listarTodos() {
        return veiculos;
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return veiculos.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    // Adiciona ou atualiza um veículo no sistema
    public Veiculo salvar(Veiculo veiculo) {
        if (veiculo.getId() == null) {
            // Se o ID for nulo, é um novo veículo e um novo ID é gerado
            veiculo.setId(contadorId.getAndIncrement());
        } else {
            // Se o ID existir, o veículo antigo é removido e o novo é adicionado
            deletar(veiculo.getId());
        }
        veiculo.setDisponivel(true); // Por padrão, o veículo é marcado como disponível :)
        veiculos.add(veiculo);
        return veiculo;
    }

    // Deleta um veículo com base no ID
    public void deletar(Long id) {
        veiculos.removeIf(v -> v.getId().equals(id));
    }

    // Lista todos os veículos que estão disponíveis para aluguel
    public List<Veiculo> buscarDisponiveis() {
        return veiculos.stream().filter(Veiculo::isDisponivel).toList();
    }
}
