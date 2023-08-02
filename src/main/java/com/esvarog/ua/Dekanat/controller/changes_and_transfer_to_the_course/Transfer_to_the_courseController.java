package com.esvarog.ua.Dekanat.controller.changes_and_transfer_to_the_course;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Transfer_to_the_courseController {
    @GetMapping("/Transfer_to_the_course")
    public String Transfer_to_the_course(){
        return "/changes_and_transfer_to_the_course/Transfer_to_the_course";
    }
}
