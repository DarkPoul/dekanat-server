package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.entity.Districts;
import com.esvarog.dekanat.service.DistrictService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping("/district/reedAll")
    public ResponseEntity<List<Districts>> reedAll(){
        return new ResponseEntity<>(districtService.reedAll(), HttpStatus.OK);
    }
}
