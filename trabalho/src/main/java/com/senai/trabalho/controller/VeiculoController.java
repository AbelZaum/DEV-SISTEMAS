package com.senai.trabalho.controller;

import com.senai.trabalho.service.*;
import com.senai.trabalho.model.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    // Injetando o serviço de Veículo, que contém a lógica da parada
    @Autowired
    private VeiculoService veiculoService;
    
    // Lista todos os veículos cadastrados no sistema.
    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarTodos();
    }
    // Lista todos os veículos disponíveis para aluguel
    @GetMapping("/disponiveis")
    public List<Veiculo> listarVeiculosDisponiveis() {
        return veiculoService.buscarDisponiveis();
    }

    //* Adiciona um novo veículo ao sistema
    //* Utiliza Bean Validation para validar os dados de entrada
    @PostMapping
    public ResponseEntity<Veiculo> adicionarVeiculo(@Valid @RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(veiculoService.salvar(veiculo));
    }

    // Atualiza as informações de um veículo existente
    // O ID do veículo é passado na URL e os novos dados são enviados no corpo da requisição
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @Valid @RequestBody Veiculo veiculo) {
        veiculo.setId(id);  // Define o ID do veículo a ser atualizado
        return ResponseEntity.ok(veiculoService.salvar(veiculo));
    }
    // Deleta um veículo do sistema com base no seu ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build();  // Retorna uma resposta sem conteúdo (204)
    }
}
