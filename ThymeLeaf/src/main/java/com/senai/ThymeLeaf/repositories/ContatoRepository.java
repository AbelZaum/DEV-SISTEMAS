package com.senai.ThymeLeaf.repositories;

import com.senai.ThymeLeaf.models.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {
}
