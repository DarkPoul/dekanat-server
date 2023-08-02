package com.esvarog.ua.Dekanat.controller.changes_and_transfer_to_the_course;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class View_and_edit_cardsController {
    @GetMapping("/View_and_edit_cards")
    public String View_and_edit_cards(){
        return "/changes_and_transfer_to_the_course/View_and_edit_cards";
    }
}
