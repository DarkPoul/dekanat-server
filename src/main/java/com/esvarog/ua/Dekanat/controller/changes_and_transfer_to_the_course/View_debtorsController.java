package com.esvarog.ua.Dekanat.controller.changes_and_transfer_to_the_course;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class View_debtorsController {
    @GetMapping("/View_debtors")
    public String View_debtors(){
        return "/changes_and_transfer_to_the_course/View_debtors";
    }
}
