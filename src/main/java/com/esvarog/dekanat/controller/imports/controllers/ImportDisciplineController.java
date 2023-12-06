package com.esvarog.dekanat.controller.imports.controllers;


import com.esvarog.dekanat.entity.Disciplines;
import com.esvarog.dekanat.entity.Result;

import com.esvarog.dekanat.service.DisciplinesService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;


@RestController

public class ImportDisciplineController {

    private final DisciplinesService disciplinesService;

    @Autowired
    public ImportDisciplineController(DisciplinesService disciplinesService) {
        this.disciplinesService = disciplinesService;
    }

    @PostMapping(path = "/import/disciplines")
    public Result importDisciplines(@RequestPart("file") MultipartFile file) {
        System.out.println("importDisciplines");
        try {
            File tempFile = File.createTempFile("temp", null);
            file.transferTo(tempFile);
            readFile(new FileInputStream(tempFile));
        } catch (Exception e) {
            return new Result(false, 500, "Internal Server Error");
        }
        return new Result(true, 200, "OK");
    }

    @PostMapping(path = "/import/students")
    public Result importStudents(@RequestPart("file") MultipartFile file) {
        System.out.println("importStudents");
        try {
            File tempFile = File.createTempFile("temp", null);
            file.transferTo(tempFile);
//            readFile(new FileInputStream(tempFile));
            System.out.println("importStudents");
        } catch (Exception e) {
            return new Result(false, 500, "Internal Server Error");
        }
        return new Result(true, 200, "OK");
    }

    @PostMapping(path = "/import/teachers")
    public Result importTeachers(@RequestPart("file") MultipartFile file) {
        System.out.println("importTeachers");
        try {
            File tempFile = File.createTempFile("temp", null);
            file.transferTo(tempFile);
//            readFile(new FileInputStream(tempFile));
            System.out.println("importTeachers");
        } catch (Exception e) {
            return new Result(false, 500, "Internal Server Error");
        }
        return new Result(true, 200, "OK");
    }

    @PostMapping(path = "/import/departments")
    public Result importDepartments(@RequestPart("file") MultipartFile file) {
        System.out.println("importDepartments");
        try {
            File tempFile = File.createTempFile("temp", null);
            file.transferTo(tempFile);
//            readFile(new FileInputStream(tempFile));
            System.out.println("importDepartments");
        } catch (Exception e) {
            return new Result(false, 500, "Internal Server Error");
        }
        return new Result(true, 200, "OK");
    }


    public void readFile(FileInputStream fileInputStream) {

        try {

            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.rowIterator();


            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    continue;
                }
                Disciplines discipline = new Disciplines();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            discipline.setDisciplineId((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            discipline.setDisciplineName(cell.getStringCellValue());
                            break;
                        case 2:
                            discipline.setDisciplineShortName(cell.getStringCellValue());
                            break;
                        case 3:
                            discipline.setDisciplineTranslation(cell.getStringCellValue());
                            break;
                    }
                }
                System.out.println(discipline);
                disciplinesService.saveDiscipline(discipline);
            }


            fileInputStream.close();


        }catch (Exception e) {
            e.fillInStackTrace();
            System.out.println(e.getMessage());

        }

    }


}
