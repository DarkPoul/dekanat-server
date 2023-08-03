package com.esvarog.ua.Dekanat.controller.support_of_the_educational_process;

import com.esvarog.ua.Dekanat.model.table.Discipline;
import com.esvarog.ua.Dekanat.model.table.StudentGroup;
import com.esvarog.ua.Dekanat.repository.ListOfDisc;
import com.esvarog.ua.Dekanat.repository.ListOfGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PostMapping("/get_plan")
    public ResponseEntity<Void> get_plan(@RequestBody Map<String, String> data) {
        try {
            System.out.println(data);
            // Можливо, ви хочете тут обробити дані, що отримали від клієнта
            // і повернути відповідний код стану або дані
            return ResponseEntity.ok().build(); // Повертаємо код стану 200 (OK) без тіла відповіді
        } catch (Exception e) {
            System.out.println("hhh");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Повертаємо код стану 500 (Internal Server Error) без тіла відповіді
        }
    }

}
