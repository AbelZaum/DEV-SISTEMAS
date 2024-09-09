package com.senai.trabalho.controller;

import com.senai.trabalho.model.Cliente;
import com.senai.trabalho.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    // Injetando o serviço de Cliente, que contém a lógica da parada
    @Autowired
    private ClienteService clienteService;

    // Lista todos os clientes cadastrados no sistema
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarTodos();
    }

    // Adiciona um novo cliente ao sistema
    // Utiliza Bean Validation para validar os dados de entrada
    @PostMapping
    public ResponseEntity<Cliente> adicionarCliente(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    //  Atualiza as informações de um cliente existente
    // O ID do cliente é passado na URL e os novos dados são enviados no corpo da requisição
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        cliente.setId(id);  // Define o ID do cliente a ser atualizado
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    // Deleta um cliente do sistema com base no seu ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build(); //// Retorna uma resposta sem conteúdo (204)
    }
}
