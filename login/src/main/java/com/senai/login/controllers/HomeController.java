package com.senai.login.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        //--Verifica se o usuário está autenticado
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/?erro";
        }

        return "home";
    }
}
