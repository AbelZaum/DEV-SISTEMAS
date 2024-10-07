package com.senai.clientes.controllers;

import com.senai.clientes.Dtos.ClienteDTO;
import com.senai.clientes.models.ClienteModel;
import com.senai.clientes.services.ClienteService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteModel> cadastrarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {

        ClienteModel novoCliente = clienteService.cadastrarCliente(clienteDTO);
        return ResponseEntity.ok(novoCliente);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO) {

        ClienteModel clienteAtualizado = clienteService.atualizarCliente(id, clienteDTO);

        if (clienteAtualizado != null) {

            return ResponseEntity.ok(clienteAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {

        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<ClienteModel> obterClientePorEmail(@PathVariable String email) {

        ClienteModel cliente = clienteService.obterclientePorEmail(email);
        if (cliente != null) {

            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/cliente")
    public List<ClienteModel> listarTodosClientes() {
        return clienteService.listarTodosClientes();
    }

    //POST
    /*"nome": "João Silva",
        "email": "joao.silva@teste.com",
        "telefone": "123456789",
        "endereco": "Rua das Flores",
        "numeroEndereco": 123
    
    PUT
   PUT /clientes/1
{
    "nome": "João Silva Atualizado",
    "email": "joao.silva@teste.com",
    "telefone": "987654321",
    "endereco": "Avenida das Palmeiras",
    "numeroEndereco": 456
}
    
    DELETE
    DELETE /clientes/1

    GET /clientes
    GET /cliente/{email}
}*/
}


