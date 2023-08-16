package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.dto.PassportDTO;
import com.esvarog.dekanat.entity.Passport;
import com.esvarog.dekanat.service.PassportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PassportController {
    private final PassportService passportService;

    @PostMapping("/pass/create")
    public ResponseEntity<Passport> create(@RequestBody PassportDTO dto){
        return new ResponseEntity<>(passportService.create(dto), HttpStatus.OK);
    }

    @GetMapping("/pass/reed")
    public ResponseEntity<List<Passport>> reed(){
        return new ResponseEntity<>(passportService.reed(), HttpStatus.OK);
    }

    @GetMapping("/pass/reed/{id}")
    public ResponseEntity<Passport> reed(@PathVariable Long id){
        return new ResponseEntity<>(passportService.reed(id), HttpStatus.OK);
    }

    @PutMapping("/pass/update")
    public ResponseEntity<Passport> update(@RequestBody Passport passport) {
        return new ResponseEntity<>(passportService.update(passport), HttpStatus.OK);
    }

    @DeleteMapping("/pass/delete/{id}")
    public HttpStatus delete(@PathVariable Long id){
        passportService.delete(id);
        return HttpStatus.OK;
    }


}
