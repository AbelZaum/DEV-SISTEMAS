package com.senai.trabalho.service;

import com.senai.trabalho.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    // Lista todos os clientes cadastrados no sistema
    public List<Cliente> listarTodos() {
        return clientes;
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clientes.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    // Adiciona ou atualiza um cliente no sistema
    public Cliente salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            // Se o ID for nulo, é um novo cliente e um novo ID é gerado
            cliente.setId(contadorId.getAndIncrement());
        } else {
            // Se o ID existir, o cliente antigo é removido e o novo é adicionado
            deletar(cliente.getId());
        }
        clientes.add(cliente);
        return cliente;
    }

    // Deleta um cliente com base no ID
    public void deletar(Long id) {
        clientes.removeIf(c -> c.getId().equals(id));
    }
}
