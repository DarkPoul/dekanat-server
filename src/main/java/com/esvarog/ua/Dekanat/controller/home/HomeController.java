package com.esvarog.ua.Dekanat.controller.home;

import com.esvarog.ua.Dekanat.model.table.Blog;
import com.esvarog.ua.Dekanat.model.table.LogEntry;
import com.esvarog.ua.Dekanat.repository.Blog_repo;
import com.esvarog.ua.Dekanat.repository.LogEntryRepository;
import com.esvarog.ua.Dekanat.repository.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private Blog_repo blogRepo;

    @Autowired
    private User_repo user_repo;

    @Autowired
    private LogEntryRepository logEntryRepository;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Головна сторінка");

        if (isUserAdmin()) {
            model.addAttribute("isAdmin", true);
        }

        List<Blog> result;
        result = (List<Blog>) blogRepo.findAll();

        model.addAttribute("result", result);
        return "home/home";
    }

    private boolean isUserAdmin() {
        // Логіка перевірки, чи користувач є адміністратором
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ADMIN"))){
            LogEntry logEntry = new LogEntry();
            logEntry.setTimestamp(LocalDateTime.now());
            logEntry.setMessage("Вхід адміністратора");
            logEntryRepository.save(logEntry);
        } else {
            LogEntry logEntry = new LogEntry();
            logEntry.setTimestamp(LocalDateTime.now());
            logEntry.setMessage("Вхід користувача");
            logEntryRepository.save(logEntry);
        }

        return authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ADMIN"));

    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////        Внесення змін та переведення на курс        ///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/entering_grades_from_information")
    public String entering_grades_from_information(Model model) {
        model.addAttribute("title", "Введення оцінок з відомості");
        return "entering_grades_from_information";
    }

    @GetMapping("/review_of_debtors")
    public String review_of_debtors(Model model) {
        model.addAttribute("title", "Перегляд боржників");
        return "review_of_debtors";
    }

    @GetMapping("/transfer_to_the_course")
    public String transfer_to_the_course(Model model) {
        model.addAttribute("title", "Переведення на курс");
        return "transfer_to_the_course";
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////                                                    ///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/view_and_print")
    public String view_and_print(Model model) {
        model.addAttribute("title", "Перегляд та друк інформації");
        return "view_and_print";
    }

    @GetMapping("/modular_control")
    public String modular_control(Model model) {
        model.addAttribute("title", "Модульний контроль");
        return "modular_control";
    }

    @GetMapping("/directory")
    public String directory(Model model) {
        model.addAttribute("title", "Довідник");
        return "directory";
    }

    @RequestMapping(value = "/create_user", method = RequestMethod.POST)
    public void create_user(@RequestBody Map<String, String> data) {
        System.out.println("Received data from client: " + data);
    }


    @RequestMapping(value = "/get_form_info", method = RequestMethod.POST)
    public List<String> get_form_info(){

        System.out.println("this work");
        return null;
    }

}

