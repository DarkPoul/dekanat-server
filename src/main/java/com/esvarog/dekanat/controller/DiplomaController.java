package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.dto.DiplomaDTO;
import com.esvarog.dekanat.dto.PassportDTO;
import com.esvarog.dekanat.entity.Diploma;
import com.esvarog.dekanat.entity.Passport;
import com.esvarog.dekanat.service.DiplomaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DiplomaController {
    private final DiplomaService diplomaService;

    @PostMapping("/diploma/create")
    public ResponseEntity<Diploma> create(@RequestBody DiplomaDTO dto){
        return new ResponseEntity<>(diplomaService.create(dto), HttpStatus.OK);
    }

    @GetMapping("/diploma/reed")
    public ResponseEntity<List<Diploma>> reed(){
        return new ResponseEntity<>(diplomaService.reed(), HttpStatus.OK);
    }

    @GetMapping("/diploma/reed/{id}")
    public ResponseEntity<Diploma> reed(@PathVariable Long id){
        return new ResponseEntity<>(diplomaService.reed(id), HttpStatus.OK);
    }

    @PutMapping("/diploma/update")
    public ResponseEntity<Diploma> update(@RequestBody Diploma diploma) {
        return new ResponseEntity<>(diplomaService.update(diploma), HttpStatus.OK);
    }

    @DeleteMapping("/diploma/delete/{id}")
    public HttpStatus delete(@PathVariable Long id){
        diplomaService.delete(id);
        return HttpStatus.OK;
    }
}
