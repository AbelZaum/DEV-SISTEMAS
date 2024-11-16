package com.senai.S.A.controller;

import com.senai.S.A.model.Emprestimo;
import com.senai.S.A.service.ColaboradorService;
import com.senai.S.A.service.EmprestimoService;
import com.senai.S.A.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping
    public String listarEmprestimos(Model model) {
        List<Emprestimo> emprestimos = emprestimoService.listarEmprestimos();
        model.addAttribute("emprestimos", emprestimos);
        return "listaemprestimos";
    }

    @GetMapping("/novo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("emprestimo", new Emprestimo());
        model.addAttribute("colaboradores", colaboradorService.listarColaboradores());
        model.addAttribute("equipamentos", equipamentoService.listarEquipamentos());
        return "cadastroemprestimo";
    }

    @PostMapping
    public String registrarEmprestimo(@ModelAttribute Emprestimo emprestimo) {
        emprestimoService.salvarEmprestimo(emprestimo);
        return "redirect:/emprestimos";
    }

    @GetMapping("/devolucao/{id}")
    public String mostrarFormularioDevolucao(@PathVariable Long id, Model model) {
        Emprestimo emprestimo = emprestimoService.buscarPorId(id);
        model.addAttribute("emprestimo", emprestimo);
        return "devolucaoemprestimo";
    }

    @PostMapping("/devolucao/{id}")
    public String registrarDevolucao(@PathVariable Long id) {
        emprestimoService.registrarDevolucao(id);
        return "redirect:/emprestimos";
    }

    @GetMapping("/excluir/{id}")
    public String excluirEmprestimo(@PathVariable Long id) {
        emprestimoService.excluirEmprestimo(id);
        return "redirect:/emprestimos";
    }
}
