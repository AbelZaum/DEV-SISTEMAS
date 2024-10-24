package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.CadastroDto;
import com.senai.ThymeLeaf.dtos.UsuarioDto;
import com.senai.ThymeLeaf.models.UsuarioModel;
import com.senai.ThymeLeaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping()
    public String cadastrarUsuario(@ModelAttribute("usuario") CadastroDto cadastro) {

        boolean sucesso = usuarioService.cadastrarUsuario(cadastro);

        if (sucesso) {
            return "redirect:listausuarios";
        }

        return "redirect:cadastrarusuario?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirUsuario(@PathVariable Long id) {

        boolean sucesso = usuarioService.excluirUsuario(id);

        if (sucesso) {
            return ResponseEntity.ok("Usuário excluído com sucesso.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir usuário.");

    }

    // Método para mostrar o formulário de atualização
    @GetMapping("/atualizar")
    public String mostrarFormularioAtualizacao(Model model) {
        model.addAttribute("usuario", new UsuarioDto()); // Passa um novo UsuarioDto para o formulário
        return "atualizarusuario"; // Retorna o nome do template
    }

    @PostMapping("/atualizar")
    public String atualizarUsuario(@ModelAttribute("usuario") UsuarioModel usuarioAtualizado) {
        Long id = usuarioAtualizado.getId(); // Obtém o ID do formulário
        boolean sucesso = usuarioService.atualizarUsuario(id, usuarioAtualizado);
        if (sucesso) {
            return "redirect:/listausuarios"; // Redireciona para a lista de usuários sem o prefixo
        }
        return "redirect:/usuario/atualizar?erro"; // Redireciona de volta para o formulário com erro
    }
}
