package com.esvarog.dekanat.controller;



import com.esvarog.dekanat.entity.*;
import com.esvarog.dekanat.service.*;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;

@AllArgsConstructor
public class ExcelFileProcessor {

    private final DisciplinesService disciplinesService;
    private final DepartmentsService departmentsService;
    private final RegionService regionService;
    private final FacultiesService facultiesService;
    private final EducationDocumentTypesService educationDocumentTypesService;

    public String getFile(String fileName, FileInputStream fileInputStream) throws IOException {
        System.out.println(fileName);

        return switch (fileName) {
            case "disciplines.xlsx" -> readDisciplines(fileInputStream);
            case "students.xlsx" -> readStudents(fileInputStream);
            case "teachers.xlsx" -> readTeachers(fileInputStream);
            case "departments.xlsx" -> readDepartments(fileInputStream);
            default -> "Назва файлу не відповідає шаблону";
        };
    }

    private String readDisciplines(FileInputStream fileInputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(0);

        if (row.getCell(0).getStringCellValue().equals("discipline_name") &&
                row.getCell(1).getStringCellValue().equals("discipline_short_name") &&
                row.getCell(2).getStringCellValue().equals("discipline_translation"))
        {

            for (Row rowSheet : sheet) {
                if (rowSheet.getRowNum() == 0) {
                    continue;
                }
                Disciplines discipline = new Disciplines();
                discipline.setDisciplineName(rowSheet.getCell(0).getStringCellValue());
                discipline.setDisciplineShortName(rowSheet.getCell(1).getStringCellValue());
                discipline.setDisciplineTranslation(rowSheet.getCell(2).getStringCellValue());

                disciplinesService.saveDiscipline(discipline);
            }



            fileInputStream.close();
            return "Назви стовпців відповідають шаблону";
        } else {
            fileInputStream.close();
            return "Назви стовпців не відповідають шаблону (| discipline_name | discipline_short_name | discipline_translation |)";
        }
    }

    private String readStudents(FileInputStream fileInputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(0);

        String[] expectedColumnNames = {
                "first_name_ukr", "last_name_ukr", "patronymic", "first_name_eng",
                "last_name_eng", "date_of_birth", "gender", "email", "region_id",
                "faculty_id", "passport_number", "passport_issued_by", "passport_issue_date",
                "passport_expiry_date", "passport_registration_number", "citizenship",
                "identification_number", "contract_number", "student_card_number",
                "education_document_type_id", "education_document_series", "education_document_number",
                "education_document_issue_date", "education_document_issue_place_ukr",
                "education_document_issue_place_eng"
        };

        boolean columnsMatchTemplate = true;

        for (int i = 0; i < expectedColumnNames.length; i++) {
            if (!row.getCell(i).getStringCellValue().equals(expectedColumnNames[i])) {
                columnsMatchTemplate = false;
                break;
            }
        }

        if (columnsMatchTemplate) {
            for (Row rowSheet : sheet) {
                if (rowSheet.getRowNum() == 0) {
                    continue;
                }
                Students student = new Students();
                Regions region = regionService.getRegionByName(rowSheet.getCell(9).getStringCellValue());
                Faculties faculty = facultiesService.getFacultyByName(rowSheet.getCell(11).getStringCellValue());
                EducationDocumentTypes educationDocumentTypes = educationDocumentTypesService.getEducationDocumentTypeByName(rowSheet.getCell(22).getStringCellValue());


                student.setFirstNameUkr(rowSheet.getCell(0).getStringCellValue());
                student.setLastNameUkr(rowSheet.getCell(1).getStringCellValue());
                student.setPatronymic(rowSheet.getCell(2).getStringCellValue());
                student.setFirstNameEng(rowSheet.getCell(3).getStringCellValue());
                student.setLastNameEng(rowSheet.getCell(4).getStringCellValue());
                student.setDateOfBirth(DateConversion(rowSheet.getCell(5).getDateCellValue()));
                student.setGender(rowSheet.getCell(6).getStringCellValue());
                student.setEmail(rowSheet.getCell(7).getStringCellValue());
                student.setPhoneNumber(rowSheet.getCell(8).getStringCellValue());
                student.setRegion(region);
                student.setAddress(rowSheet.getCell(10).getStringCellValue());
                student.setFaculty(faculty);
                student.setPassportNumber(rowSheet.getCell(12).getStringCellValue());
                student.setPassportIssuedBy(rowSheet.getCell(13).getStringCellValue());
                student.setPassportIssueDate(DateConversion(rowSheet.getCell(14).getDateCellValue()));
                student.setPassportExpiryDate(DateConversion(rowSheet.getCell(15).getDateCellValue()));
                student.setPassportRegistrationNumber(rowSheet.getCell(16).getStringCellValue());
                student.setCitizenship(rowSheet.getCell(17).getStringCellValue());
                student.setIdentificationNumber(rowSheet.getCell(18).getStringCellValue());
                student.setContractNumber(rowSheet.getCell(19).getStringCellValue());
                student.setStudentCardNumber(rowSheet.getCell(20).getStringCellValue());
                student.setRecordBookNumber(rowSheet.getCell(21).getStringCellValue());
                student.setEducationDocumentType(educationDocumentTypes);
                student.setEducationDocumentSeries(rowSheet.getCell(23).getStringCellValue());
                student.setEducationDocumentNumber(rowSheet.getCell(24).getStringCellValue());
                student.setEducationDocumentIssueDate(DateConversion(rowSheet.getCell(25).getDateCellValue()));
                student.setEducationDocumentIssuePlaceUkr(rowSheet.getCell(26).getStringCellValue());
                student.setEducationDocumentIssuePlaceEng(rowSheet.getCell(27).getStringCellValue());

            }
            fileInputStream.close();
            return "Назви стовпців відповідають шаблону";
        } else {
            fileInputStream.close();
            return "Назви стовпців не відповідають шаблону (| first_name_ukr | last_name_ukr | patronymic " +
                    "| first_name_eng | last_name_eng | date_of_birth | gender | email | phone_number | region_id | address | faculty_id " +
                    "| passport_number | passport_issued_by | passport_issue_date | passport_expiry_date " +
                    "| passport_registration_number | citizenship | identification_number | contract_number " +
                    "| student_card_number | record_book_number | education_document_type_id | education_document_series " +
                    "| education_document_number | education_document_issue_date | education_document_issue_place_ukr " +
                    "| education_document_issue_place_eng |)";
        }
    }

    private String readDepartments(FileInputStream fileInputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(0);

        if (row.getCell(0).getStringCellValue().equals("department_name") &&
                row.getCell(1).getStringCellValue().equals("department_abbreviation") &&
                row.getCell(2).getStringCellValue().equals("department_translation"))
        {

        for (Row rowSheet : sheet) {
                if (rowSheet.getRowNum() == 0) {
                    continue;
                }
                Departments department = new Departments();
                department.setDepartmentName(rowSheet.getCell(0).getStringCellValue());
                department.setDepartmentAbbreviation(rowSheet.getCell(1).getStringCellValue());
                department.setDepartmentTranslation(rowSheet.getCell(2).getStringCellValue());

                departmentsService.saveDepartment(department);
            }
            fileInputStream.close();
            return "Назви стовпців відповідають шаблону";
        } else {
            fileInputStream.close();
            return "Назви стовпців не відповідають шаблону (| department_name | department_abbreviation | department_translation |)";
        }
    }

    private String readTeachers(FileInputStream fileInputStream) throws IOException {
        return "teachers";
    }

    private Date DateConversion(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime());
    }

}
