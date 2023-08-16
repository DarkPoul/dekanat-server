package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.dto.PreEduDTO;
import com.esvarog.dekanat.entity.PreviousEducation;
import com.esvarog.dekanat.service.PreEduService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PreEduController {
    private final PreEduService preEduService;

    @PostMapping("/edu/create")
    public ResponseEntity<PreviousEducation> create(@RequestBody PreEduDTO dto){
        return new ResponseEntity<>(preEduService.create(dto), HttpStatus.OK);
    }

    @GetMapping("/edu/reedAll")
    public ResponseEntity<List<PreviousEducation>> reedAll(){
        return new ResponseEntity<>(preEduService.reedAll(), HttpStatus.OK);
    }
    @GetMapping("/edu/reedById/{id}")
    public ResponseEntity<PreviousEducation> reedById(@PathVariable Long id){
        return new ResponseEntity<>(preEduService.reedById(id), HttpStatus.OK);
    }
}
