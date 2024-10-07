package com.senai.clientes.services;

import com.senai.clientes.Dtos.ClienteDTO;
import com.senai.clientes.models.ClienteModel;
import com.senai.clientes.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional// utilizada para definir o escopo de uma transação em métodos ou classes
    public ClienteModel cadastrarCliente(ClienteDTO clienteDTO) {

        ClienteModel cliente = new ClienteModel();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setDataCadastro(LocalDate.now());
        cliente.setEndereço(clienteDTO.getEndereco());
        cliente.setNumeroEndereco(clienteDTO.getNumeroEndereco());
        return clienteRepository.save(cliente);
    }

    @Transactional //utilizada para definir o escopo de uma transação em métodos ou classes
    public ClienteModel atualizarCliente(Long id, ClienteDTO clienteDTO) {

        Optional<ClienteModel> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {

            ClienteModel cliente = optionalCliente.get();
            cliente.setNome(clienteDTO.getNome());
            cliente.setEmail(clienteDTO.getEmail());
            cliente.setTelefone(clienteDTO.getTelefone());
            cliente.setEndereço(clienteDTO.getEndereco());
            cliente.setNumeroEndereco(clienteDTO.getNumeroEndereco());
            return clienteRepository.save(cliente);
        }
        return null; // ou vai dar um erro de exceção no painel
    }

    @Transactional// utilizada para definir o escopo de uma transação em métodos ou classes
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteModel obterclientePorEmail(String email) {

        return clienteRepository.findByEmail(email).orElse(null);
    }

    public List<ClienteModel> listarTodosClientes() {
        return clienteRepository.findAll();
    }
}
