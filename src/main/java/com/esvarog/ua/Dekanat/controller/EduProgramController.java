package com.esvarog.ua.Dekanat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class EduProgramController {

    @GetMapping("/edu_curation")
    public String directory_faculty(Model model) {
        model.addAttribute("title", "Навчальні плани");

        return "edu_curation";
    }
}
