
package com.senai.trabalho.controller;

import com.senai.trabalho.model.Aluguel;
import com.senai.trabalho.model.Cliente;
import com.senai.trabalho.model.Veiculo;
import com.senai.trabalho.service.AluguelService;
import com.senai.trabalho.service.ClienteService;
import com.senai.trabalho.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    @Autowired
    private AluguelService aluguelService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeiculoService veiculoService;

    //* Lista todos os aluguéis registrados no sistema
    @GetMapping
    public List<Aluguel> listarAlugueis() {
        return aluguelService.listarTodos();
    }

    //  Registra um novo aluguel de veículo
    @PostMapping("/registrar")
    public ResponseEntity<Aluguel> registrarAluguel(@RequestParam Long clienteId, @RequestParam Long veiculoId,@Valid @RequestBody Aluguel aluguel) {
        // Busca o cliente e veículo pelo ID, se não encontrar lança uma exceção
        Cliente cliente = clienteService.buscarPorId(clienteId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        Veiculo veiculo = veiculoService.buscarPorId(veiculoId).orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado."));
        return ResponseEntity.ok(aluguelService.registrarAluguel(cliente, veiculo, aluguel));
    }

    // Finaliza um aluguel, tornando o veículo disponível novamente
    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Void> finalizarAluguel(@PathVariable Long id) {
        aluguelService.finalizarAluguel(id);
        return ResponseEntity.noContent().build();  // Retorna uma resposta sem conteúdo (204)
    }
}
