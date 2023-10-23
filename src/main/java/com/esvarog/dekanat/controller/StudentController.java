package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.converter.StudentDtoToStudentConverter;
import com.esvarog.dekanat.converter.StudentToStudentDtoConverter;
import com.esvarog.dekanat.dto.StudentDTO;
import com.esvarog.dekanat.entity.*;
import com.esvarog.dekanat.service.OrderService;
import com.esvarog.dekanat.service.PassDataService;
import com.esvarog.dekanat.service.PriorEducationService;
import com.esvarog.dekanat.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class StudentController {

    private final StudentService studentService;
    private final PassDataService passDataService;
    private final StudentDtoToStudentConverter studentDtoToStudentConverter;
    private final StudentToStudentDtoConverter studentToStudentDtoConverter;
    private final PriorEducationService priorEducationService;
    private final OrderService orderService;

    public StudentController(StudentService studentService, PassDataService passDataService, StudentDtoToStudentConverter studentDtoToStudentConverter, StudentToStudentDtoConverter studentToStudentDtoConverter, PriorEducationService priorEducationService, OrderService orderService) {
        this.studentService = studentService;
        this.passDataService = passDataService;
        this.studentDtoToStudentConverter = studentDtoToStudentConverter;
        this.studentToStudentDtoConverter = studentToStudentDtoConverter;
        this.priorEducationService = priorEducationService;
        this.orderService = orderService;
    }

    @GetMapping(path = "/student/{id}")
    public Result findStudentById(@PathVariable String id) {
        Student student = this.studentService.findById(id);
        return new Result(true, 200, "success get user info", student);
    }

    @GetMapping(path = "/student")
    public Result findAllStudents() {
        List<Student> students = this.studentService.findAll();
        List<StudentDTO> studentsDto = new ArrayList<>();
        for (Student student : students) {
             studentsDto.add(studentToStudentDtoConverter.convert(student));
        }
        return new Result(true, 200, "success get users info", studentsDto);
    }

    @PostMapping(path = "/student")
    public Result addStudent(@RequestBody StudentDTO studentDTO) {
        Student newStudent = this.studentDtoToStudentConverter.convert(studentDTO);
        Student savedStudent = this.studentService.save(newStudent);
        StudentDTO student = this.studentToStudentDtoConverter.convert(savedStudent);
        return new Result(true, 200, "success add user", student);
    }

    @PutMapping(path = "/student/{id}")
    public Result updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO) {
        Student update = this.studentDtoToStudentConverter.convert(studentDTO);
        Student updateStudent = this.studentService.update(id, update);
        StudentDTO updatedStudentDto = this.studentToStudentDtoConverter.convert(updateStudent);
        return new Result(true, 200, "success update user", updatedStudentDto);
    }

    @DeleteMapping(path = "/student/{id}")
    public Result deleteStudent(@PathVariable String id) {
        this.studentService.delete(id);
        return new Result(true, 200, "success delete user");
    }

    @GetMapping(path = "/student/add_test/{count}")
    public Result addTestStudent(@PathVariable Integer count) {
        List<StudentDTO> studentDto = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Student student = getStudent();
            this.studentService.save(student);
            studentDto.add(this.studentToStudentDtoConverter.convert(student));
        }

        return new Result(true, 200, "success add user", List.of(studentDto));
    }
    private Student getStudent() {
        Student student = new Student();
        Random random = new Random();

        student.setId(this.studentService.count() + 1);

        student.setFirstName(getName());
        student.setLastName(getLastname(student.getFirstName()));
        student.setSurname(getSurname(student.getFirstName()));

        student.setFirstNameEng(transliterate(student.getFirstName()));
        student.setLastNameEng(transliterate(student.getLastName()));

        student.setApplicantCardNumber(String.valueOf((random.nextLong() % 900000000 + 100000000)));
        student.setNumberOfTheRecordBook(String.valueOf((random.nextLong() % 900000000 + 100000000)));
        student.setContractNumber(String.valueOf((random.nextLong() % 900000000 + 100000000)));
        student.setCardNumberOfTheIndividual(String.valueOf((random.nextLong() % 900000000 + 100000000)));

        student.setPassData(getPassData());

        student.setPriorEducation(getPriorEducation());
        student.setOrderStudent(getOrder());

        student.setEmail(transliterate(student.getFirstNameEng())+student.getSurname() + (random.nextInt(99)+1) + "@test.com");
        student.setPhoneNumber(getPhoneNumber());
        return student;
    }
    private PassData getPassData() {
        Random random = new Random();
        PassData passData = new PassData();
        passData.setId(this.passDataService.count() + 1);
        passData.setNumberOfDocument(String.valueOf((random.nextLong() % 900000000 + 100000000)));
        passData.setIssuingAuthority("test");
        passData.setRecordNumber(String.valueOf((random.nextLong() % 900000000 + 100000000)));
        passData.setIssueDate(getDate());
        passData.setIdentificationCode(String.valueOf((random.nextLong() % 900000000 + 100000000)));
        passData.setSex(true);
        passData.setNationality(true);
        passData.setBirthdate(getDate());
        passData.setDistrict(getDistrict());
        passData.setAddress("м. Тест, вул. Тестова, 1");

        this.passDataService.save(passData);

        return passData;
    }
    public static District getDistrict() {
        Random random = new Random();
        District district = new District();
        district.setId(random.nextInt(25)+1);
        return district;
    }
    public static Date getDate() {
        Random random = new Random();
        return new Date(random.nextInt(100)+2000, random.nextInt(12)+1, random.nextInt(30)+1);
    }
    //Генерація чоловічого та жіночого ім'я на
    public static String getName() {
        Random random = new Random();
        String[] names =
                {
                        "Іван", "Петро", "Олександр", "Андрій", "Василь", "Віктор", "Володимир", "Дмитро",
                        "Євген", "Ігор", "Костянтин", "Максим", "Михайло", "Олег", "Роман", "Сергій", "Тарас", "Ярослав",
                        "Анна", "Вікторія", "Валентина", "Галина", "Дарина", "Жанна", "Ірина", "Катерина", "Людмила",
                        "Марія", "Наталія", "Олена", "Поліна", "Раїса", "Світлана", "Тетяна", "Уляна", "Юлія", "Яна"
                };
        return names[random.nextInt(names.length)];
    }
    //Генерація чоловічого та жіночого прізвища на основі випадкового імені (getName())
    public static String getSurname(String name) {
        Random random = new Random();
        String[] surnames =
                {
                        "Андрійчук", "Бабенко", "Бойко", "Бондаренко", "Борисенко", "Василенко", "Васильчук", "Волошин",
                        "Гаврилюк", "Герасименко", "Гончаренко", "Горбаченко", "Гордієнко", "Григоренко", "Гриценко",
                        "Даниленко", "Дем'яненко", "Денисенко", "Дмитренко", "Довгаленко", "Довганенко", "Дорошенко",
                        "Євдокименко", "Єрмоленко", "Жуковенко", "Захаренко", "Зінченко", "Іваненко", "Іванченко",
                        "Ігнатенко", "Ільченко", "Карпенко", "Кириленко", "Коваленко", "Ковальчук", "Колесніченко",
                        "Колісник", "Кондратенко", "Кононенко", "Корнієнко", "Коров'як", "Корольчук", "Костенко",
                        "Кравченко", "Крамаренко", "Краснобаєнко", "Краснощок", "Кривенко", "Кривонос", "Крищенко",
                        "Кузьменко", "Кузьмін", "Кузьмінський", "Куліш", "Купченко", "Лавренко", "Лазаренко",
                        "Лебідь", "Лисенко", "Литвиненко", "Литвинчук", "Лукашенко", "Луценко", "Ляшенко", "Мазур",
                        "Макаренко", "Максименко", "Маленко", "Мамченко", "Марченко", "Маслов", "Мельник", "Мельниченко",
                        "Мироненко", "Мірошниченко", "Михайленко", "Міщенко", "Мовчан", "Москаленко", "Муравйов",
                        "Мурашко", "Назаренко", "Назарчук", "Нестеренко", "Нечипоренко", "Нечипуренко", "Нікітенко",
                        "Ніколаєнко", "Олійник", "Оліференко", "Онищенко", "Орленко", "Остапенко", "Осташ", "Охріменко"
                };
        String[] surnamesFemale =
                {
                        "Андрійчук", "Бабенко", "Бойко", "Бондаренко", "Борисенко", "Василенко", "Васильчук", "Волошина",
                        "Гаврилюк", "Герасименко", "Гончаренко", "Горбаченко", "Гордієнко", "Григоренко", "Гриценко",
                        "Даниленко", "Дем'яненко", "Денисенко", "Дмитренко", "Довгаленко", "Довганенко", "Дорошенко",
                        "Євдокименко", "Єрмоленко", "Жуковенко", "Захаренко", "Зінченко", "Іваненко", "Іванченко",
                        "Ігнатенко", "Ільченко", "Карпенко", "Кириленко", "Коваленко", "Ковальчук", "Колесніченко",
                        "Колісник", "Кондратенко", "Кононенко", "Корнієнко", "Коров'як", "Корольчук", "Костенко",
                        "Кравченко", "Крамаренко", "Краснобаєнко", "Краснощок", "Кривенко", "Кривонос", "Крищенко",
                        "Кузьменко", "Кузьміна", "Кузьмінська", "Куліш", "Купченко", "Лавренко", "Лазаренко",
                        "Лебідь", "Лисенко", "Литвиненко", "Літвинчук", "Лукашенко", "Луценко", "Ляшенко", "Мазур"
                };
        if (name.endsWith("а") || name.endsWith("я")) {
            return surnamesFemale[random.nextInt(surnamesFemale.length)];
        } else {
            return surnames[random.nextInt(surnames.length)];
        }
    }
    //Генерація чоловічого та жіночого по батькові на основі випадкового імені (getName()) та прізвища (getSurname())
    public static String getLastname(String name){
        Random random = new Random();
        String[] lastnames =
                {
                        "Іванович", "Петрович", "Олександрович", "Андрійович", "Васильович", "Вікторович", "Володимирович",
                        "Дмитрович", "Євгенович", "Ігорович", "Костянтинович", "Максимович", "Михайлович", "Олегович",
                        "Романович", "Сергійович", "Тарасович", "Ярославович"
                };
        String[] lastnamesFemale =
                {
                        "Іванівна", "Петрівна", "Олександрівна", "Андріївна", "Василівна", "Вікторівна", "Володимирівна",
                        "Дмитрівна", "Євгенівна", "Ігорівна", "Костянтинівна", "Максимівна", "Михайлівна", "Олегівна",
                        "Романівна", "Сергіївна", "Тарасівна", "Ярославівна"
                };
        if (name.endsWith("а") || name.endsWith("я")) {
            return lastnamesFemale[random.nextInt(lastnamesFemale.length)];
        } else {
            return lastnames[random.nextInt(lastnames.length)];
        }
    }
    public static String transliterate(String ukrainianText) {
        ukrainianText = ukrainianText
                .replace("А", "A")
                .replace("а", "a")
                .replace("Б", "B")
                .replace("б", "b")
                .replace("в", "v")
                .replace("В", "V")
                .replace("Г", "H")
                .replace("г", "h")
                .replace("ґ", "g")
                .replace("ґ", "g")
                .replace("д", "d")
                .replace("Д", "D")
                .replace("е", "e")
                .replace("Е", "E")
                .replace("є", "ie")
                .replace("Є", "Ie")
                .replace("ж", "zh")
                .replace("Ж", "Zh")
                .replace("з", "z")
                .replace("З", "Z")
                .replace("и", "y")
                .replace("И", "Y")
                .replace("і", "i")
                .replace("і", "I")
                .replace("ї", "i")
                .replace("Ї", "I")
                .replace("Й", "I")
                .replace("й", "i")
                .replace("К", "K")
                .replace("к", "k")
                .replace("Л", "L")
                .replace("л", "l")
                .replace("М", "M")
                .replace("м", "m")
                .replace("Н", "N")
                .replace("н", "n")
                .replace("О", "O")
                .replace("о", "o")
                .replace("П", "P")
                .replace("п", "p")
                .replace("Р", "R")
                .replace("р", "r")
                .replace("с", "S")
                .replace("с", "s")
                .replace("Т", "T")
                .replace("т", "t")
                .replace("У", "U")
                .replace("у", "u")
                .replace("Ф", "F")
                .replace("ф", "f")
                .replace("Х", "Kh")
                .replace("х", "kh")
                .replace("Ц", "Ts")
                .replace("ц", "ts")
                .replace("Ч", "Ch")
                .replace("ч", "ch")
                .replace("Ш", "Sh")
                .replace("ш", "sh")
                .replace("Щ", "Shch")
                .replace("щ", "shch")
                .replace("ь", "")
                .replace("Ю", "Iu")
                .replace("ю", "iu")
                .replace("Я", "Ia")
                .replace("я", "ia")
                .replace(" ", "-"); // Пробіл транслітеруємо в дефіс

        return ukrainianText;
    }
    public PriorEducation getPriorEducation() {
        Random random = new Random();
        PriorEducation priorEducation = new PriorEducation();
        priorEducation.setId(this.priorEducationService.count() + 1);
        priorEducation.setTypeOfDocument(random.nextInt(3)+1);
        priorEducation.setSeria(String.valueOf(random.nextInt(99)+1));
        priorEducation.setNumber(String.valueOf((random.nextLong() % 900000000 + 100000000)));
        priorEducation.setIssueDate(getDate());
        priorEducation.setTitleOfInstitution("Тестовий навчальний заклад");
        this.priorEducationService.save(priorEducation);
        return priorEducation;
    }
    public OrderStudent getOrder(){
        Random random = new Random();
        OrderStudent orderStudent = new OrderStudent();
        orderStudent.setId(1);
        orderStudent.setNumber(String.valueOf(random.nextInt(99)+1));
        orderStudent.setText("Зарахування студента на 1 курс");
        this.orderService.save(orderStudent);
        return orderStudent;
    }
    public static String getPhoneNumber() {
        Random random = new Random();
        String[] company_numbers = {
                "099", "067", "068", "096", "097", "098", "050", "066", "095", "063", "093", "073", "063", "093"
        };
        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append("+38").append(company_numbers[random.nextInt(company_numbers.length)]).append(random.nextInt(900)+ 100).append(random.nextInt(9000)+1000);
        return phoneNumber.toString();
    }

}
