package com.senai.login.controllers;

import com.senai.login.dtos.LoginDto;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String viewLogin(Model model) {

        LoginDto LoginDto = new LoginDto();
        
        LoginDto.setLogin("user");
        LoginDto.setSenha("password");
        
        
        model.addAttribute("loginDto", LoginDto);

        return "login";
    }

    @PostMapping("/autenticar")
    public String autenticar(Model model, @ModelAttribute LoginDto loginDto) {
       
        System.out.println("login=" + loginDto.getLogin() + " senha=" + loginDto.getSenha());
        
        return "login";
        
    }

}
    