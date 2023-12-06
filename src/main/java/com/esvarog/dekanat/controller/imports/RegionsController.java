package com.esvarog.dekanat.controller.imports;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
public class RegionsController {
//    Контролер для завантажаення на сервер файлів з регіонами
    @PostMapping("/import/regions")
    public void importRegions(@RequestParam("file")MultipartFile file) {

    }

}
