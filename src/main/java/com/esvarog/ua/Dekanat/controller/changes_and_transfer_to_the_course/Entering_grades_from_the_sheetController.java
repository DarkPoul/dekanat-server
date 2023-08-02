package com.esvarog.ua.Dekanat.controller.changes_and_transfer_to_the_course;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Entering_grades_from_the_sheetController {
    @GetMapping("/Entering_grades_from_the_sheet")
    public String Entering_grades_from_the_sheet(){
        return "/changes_and_transfer_to_the_course/Entering_grades_from_the_sheet";
    }
}
