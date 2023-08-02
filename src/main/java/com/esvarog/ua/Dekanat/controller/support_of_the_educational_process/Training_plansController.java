package com.esvarog.ua.Dekanat.controller.support_of_the_educational_process;

import com.esvarog.ua.Dekanat.model.table.Discipline;
import com.esvarog.ua.Dekanat.model.table.StudentGroup;
import com.esvarog.ua.Dekanat.repository.ListOfDisc;
import com.esvarog.ua.Dekanat.repository.ListOfGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Training_plansController {
    @Autowired
    private ListOfGroup listOfGroup;
    @Autowired
    private ListOfDisc listOfDisc;

    @GetMapping("/Training_plans")
    public String Training_plans(Model model){

        Iterable<StudentGroup> group = listOfGroup.findAll();
        Iterable<Discipline> disc = listOfDisc.findAll();
        System.out.println(disc);
        model.addAttribute("groups", group);
        model.addAttribute("disc", disc);


        return "test";
    }

}
