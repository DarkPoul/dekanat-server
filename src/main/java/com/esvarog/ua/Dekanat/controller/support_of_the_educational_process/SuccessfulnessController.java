package com.esvarog.ua.Dekanat.controller.support_of_the_educational_process;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessfulnessController {

    @GetMapping("/Successfulness")
    public String Successfulness(){

        return "/support_of_the_educational_process/Successfulness.html";
    }

}
