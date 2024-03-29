package com.esvarog.dekanat.controller.imports;

import com.esvarog.dekanat.controller.ExcelFileProcessor;
import com.esvarog.dekanat.entity.Result;
import com.esvarog.dekanat.service.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.OPTIONS}, allowedHeaders = {"Content-Type", "Authorization"})
public class ImportStudents {

    private final DisciplinesService disciplinesService;
    private final DepartmentsService departmentsService;
    private final RegionService regionService;
    private final FacultiesService facultiesService;
    private final EducationDocumentTypesService educationDocumentTypesService;

    @PostMapping(path = "/import/students")
    public Result importStudents(@RequestPart("file") MultipartFile file){
        try {
            File tempFile = File.createTempFile("temp", null);
            file.transferTo(tempFile);
            FileInputStream fileInputStream = new FileInputStream(tempFile);
            ExcelFileProcessor excelFileProcessor = new ExcelFileProcessor(disciplinesService, departmentsService, regionService, facultiesService, educationDocumentTypesService);
            return new Result(true, 200, excelFileProcessor.getFile(file.getOriginalFilename(), fileInputStream));
        } catch (IOException e) {
            e.fillInStackTrace();
            return new Result(false, 500, "Error importing file");
        }
    }
}
