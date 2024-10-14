package com.senai.login.controllers;

import com.senai.login.dtos.LoginDto;
import com.senai.login.services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String viewLogin(Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        return "login";
    }

    @PostMapping("/autenticar")
    public String autenticar(@ModelAttribute LoginDto loginDto, HttpSession session, RedirectAttributes redirectAttributes) {
        boolean authenticated = usuarioService.autenticarUsuario(loginDto);

        if (authenticated) {
            session.setAttribute("usuarioLogado", loginDto.getLogin());
            return "redirect:/home";
        } else {
            redirectAttributes.addAttribute("erro", true);
            return "redirect:/?erro";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("usuarioLogado");
        return "redirect:/?logout";
    }
}
