package com.esvarog.dekanat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class CurriculaController {
    @GetMapping("/api/curricula/ok")
    public String home(Model model) {
        model.addAttribute("title", "Головна сторінка");
        return "home";
    }
}
