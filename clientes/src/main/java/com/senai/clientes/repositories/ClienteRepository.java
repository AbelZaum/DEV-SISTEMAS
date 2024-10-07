package com.senai.clientes.repositories;

import com.senai.clientes.models.ClienteModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    Optional<ClienteModel> findByEmail(String email);

}
