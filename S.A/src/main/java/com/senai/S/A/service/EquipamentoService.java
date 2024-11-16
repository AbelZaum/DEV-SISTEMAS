package com.senai.S.A.service;

import com.senai.S.A.model.Equipamento;
import com.senai.S.A.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public List<Equipamento> listarEquipamentos() {
        List<Equipamento> equipamentos = equipamentoRepository.findAll();
        if (equipamentos.isEmpty()) {
            System.out.println("Nenhum equipamento cadastrado!");
        }
        return equipamentos;
    }

    public Equipamento buscarPorId(Long id) {
        return equipamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
    }

    @Transactional
    public Equipamento salvarEquipamento(Equipamento equipamento) {
        if (equipamento.getDescricao() == null || equipamento.getDescricao().isEmpty()) {
            throw new RuntimeException("Descrição do equipamento é obrigatória.");
        }
        if (equipamento.getTipo() == null) {
            throw new RuntimeException("Tipo do equipamento é obrigatório.");
        }
        return equipamentoRepository.save(equipamento);
    }

    @Transactional
    public Equipamento atualizarEquipamento(Long id, Equipamento equipamentoAtualizado) {
        Equipamento equipamento = buscarPorId(id);
        equipamento.setDescricao(equipamentoAtualizado.getDescricao());
        equipamento.setTipo(equipamentoAtualizado.getTipo());
        return equipamentoRepository.save(equipamento);
    }

    @Transactional
    public void excluirEquipamento(Long id) {
        equipamentoRepository.deleteById(id);
    }
}
