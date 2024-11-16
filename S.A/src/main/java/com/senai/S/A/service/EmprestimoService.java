package com.senai.S.A.service;

import com.senai.S.A.model.Emprestimo;
import com.senai.S.A.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo buscarPorId(Long id) {
        return emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
    }

    @Transactional
    public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
        emprestimo.setData(LocalDate.now());
        emprestimo.setDevolucao(null); // Garantir que a devolução esteja vazia no início
        return emprestimoRepository.save(emprestimo);
    }

    @Transactional
    public void registrarDevolucao(Long id) {
        Emprestimo emprestimo = buscarPorId(id);
        emprestimo.setDevolucao(LocalDate.now());
        emprestimoRepository.save(emprestimo);
    }

    @Transactional
    public void excluirEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }
}
