package com.senai.ThymeLeaf.services; 

import com.senai.ThymeLeaf.models.ContatoModel; 
import com.senai.ThymeLeaf.repositories.ContatoRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

@Service 
public class ContatoService {

    @Autowired //--Injetando a dependência do ContatoRepository automaticamente
    private ContatoRepository contatoRepository; //--Declara uma variável para o repositório de contatos

    public boolean cadastrarContato(ContatoModel contato) { //--Método que tenta cadastrar um contato
        try {
            contatoRepository.save(contato); //--Tenta salvar o contato no banco de dados
            return true; //--Retorna true se o salvamento foi bem-sucedido
        } catch (Exception e) {//--Captura qualquer exceção que possa ocorrer durante o salvamento
            return false; //--Retorna false se ocorrer uma exceção
        }
    }
}
