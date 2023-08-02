package com.esvarog.ua.Dekanat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewAndEditCardController {

    @GetMapping("/view_and_edit_cards")
    public String making_changes(Model model) {
        model.addAttribute("title", "Перегляд та правка карток");

        return "view_and_edit_cards";
    }

}
