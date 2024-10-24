package com.senai.ThymeLeaf.controllers; 

import com.senai.ThymeLeaf.models.ContatoModel; 
import com.senai.ThymeLeaf.services.ContatoService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/contato") 
public class ContatoController {

    @Autowired 
    private ContatoService contatoService; //--Declara uma variável para o serviço de contatos

    @GetMapping("/cadastrar") 
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("contato", new ContatoModel());//-- Adiciona um novo objeto ContatoModel ao modelo, que será utilizado no formulário
        return "cadastrarcontato"; // Retorna o nome do template HTML para o formulário de cadastro
    }

    @PostMapping("/cadastrar") //--Mapeia requisições POST para /contato/cadastrar
    public String cadastrarContato(@ModelAttribute("contato") ContatoModel contato) {
        boolean sucesso = contatoService.cadastrarContato(contato); //--Chama o método do serviço para salvar o contato e armazena o resultado
        if (sucesso) { //--Verifica se o cadastro foi bem-sucedido
            return "redirect:/listausuarios"; //--Redireciona para a lista de usuários em caso de sucesso
        }
        return "redirect:/contato/cadastrar?erro"; //--Redireciona para o formulário de cadastro com um parâmetro de erro em caso de falha
    }
}
