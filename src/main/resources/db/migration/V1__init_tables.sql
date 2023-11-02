CREATE TABLE users
(
    id        BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    enabled   BIT          NOT NULL,
    password  VARCHAR(255) NOT NULL,
    role      VARCHAR(255) NOT NULL,
    username  VARCHAR(255) NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE faculties
(
    faculty_id   INT AUTO_INCREMENT PRIMARY KEY,
    faculty_name VARCHAR(100) NOT NULL,
    dean_name    VARCHAR(100) NOT NULL,
    dean_surname VARCHAR(100) NOT NULL,
    abbreviation VARCHAR(10)  NOT NULL
);

CREATE TABLE regions
(
    region_id   INT AUTO_INCREMENT PRIMARY KEY,
    region_name VARCHAR(100) NOT NULL
);

CREATE TABLE education_document_types
(
    document_type_id INT AUTO_INCREMENT PRIMARY KEY,
    type_name_ukr    VARCHAR(225) NOT NULL, -- Назва типу документу (українська)
    type_name_eng    VARCHAR(225) NOT NULL  -- Назва типу документу (англійська)
);

CREATE TABLE students
(
    student_id                         INT AUTO_INCREMENT PRIMARY KEY,
    first_name_ukr                     VARCHAR(50)                   NOT NULL, -- Ім'я (українська)
    last_name_ukr                      VARCHAR(50)                   NOT NULL, -- Прізвище (українська)
    patronymic                         VARCHAR(50),                            -- По батькові
    first_name_eng                     VARCHAR(50)                   NOT NULL, -- Ім'я (англійська)
    last_name_eng                      VARCHAR(50)                   NOT NULL, -- Прізвище (англійська)
    date_of_birth                      DATE,
    gender                             ENUM ('Male', 'Female')       NOT NULL, -- Стать
    email                              VARCHAR(100),
    phone_number                       VARCHAR(20),
    region_id                          INT,                                    -- Посилання на область
    address                            VARCHAR(255)                  NOT NULL, -- Адреса
    faculty_id                         INT,
    passport_number                    VARCHAR(20)                   NOT NULL,
    passport_issued_by                 VARCHAR(100)                  NOT NULL,
    passport_issue_date                DATE                          NOT NULL,
    passport_expiry_date               DATE                          NOT NULL,
    passport_registration_number       VARCHAR(20)                   NOT NULL,
    citizenship                        ENUM ('Ukrainian', 'Foreign') NOT NULL, -- Громадянство
    identification_number              VARCHAR(20)                   NOT NULL,
    contract_number                    VARCHAR(20)                   NOT NULL, -- Номер контракту
    student_card_number                VARCHAR(20)                   NOT NULL, -- Номер студентського квитка
    record_book_number                 VARCHAR(20)                   NOT NULL, -- Номер залікової книги
    education_document_type_id         INT,                                    -- Посилання на тип документу про освіту
    education_document_series          VARCHAR(20)                   NOT NULL, -- Серія документу про освіту
    education_document_number          VARCHAR(20)                   NOT NULL, -- Номер документу про освіту
    education_document_issue_date      DATE                          NOT NULL, -- Дата видачі документу про освіту
    education_document_issue_place_ukr VARCHAR(100)                  NOT NULL, -- Місце видачі (українська)
    education_document_issue_place_eng VARCHAR(100)                  NOT NULL, -- Місце видачі (англійська)
    FOREIGN KEY (region_id) REFERENCES regions (region_id),
    FOREIGN KEY (education_document_type_id) REFERENCES education_document_types (document_type_id),
    FOREIGN KEY (faculty_id) REFERENCES faculties (faculty_id)
);

CREATE TABLE order_type
(
    order_type_id INT AUTO_INCREMENT PRIMARY KEY,
    order_title   VARCHAR(100) NOT NULL
);

CREATE TABLE orders
(
    order_id      INT AUTO_INCREMENT PRIMARY KEY,
    student_id    INT,                  -- Посилання на студента, до якого стосується наказ
    order_number  VARCHAR(20) NOT NULL, -- Номер наказу
    order_date    DATE        NOT NULL, -- Дата наказу
    order_type_id INT,                  -- Посилання на тип наказу
    description   TEXT,                 -- Опис наказу (необов'язково)
    FOREIGN KEY (student_id) REFERENCES students (student_id),
    FOREIGN KEY (order_type_id) REFERENCES order_type (order_type_id)
);



CREATE TABLE group_information
(
    group_id           INT AUTO_INCREMENT PRIMARY KEY,
    group_name         VARCHAR(110) NOT NULL, -- Назва групи
    group_abbreviation VARCHAR(10)  NOT NULL, -- Абревіатура групи
    faculty_id         INT,                   -- Посилання на факультет
    FOREIGN KEY (faculty_id) REFERENCES faculties (faculty_id)
);

CREATE TABLE student_group
(
    student_group_id    INT AUTO_INCREMENT PRIMARY KEY,
    student_id          INT,          -- Посилання на студента
    group_id            INT,          -- Посилання на групу
    course_number       INT NOT NULL, -- Номер курсу
    group_number        INT NOT NULL, -- Номер групи (у разі паралельних груп)
    creation_year       INT NOT NULL, -- Рік створення групи
    came_from_technicum BOOLEAN,      -- Чи група прийшла після технікума (TRUE або FALSE)
    study_form          VARCHAR(50),  -- Форма навчання
    educational_degree  VARCHAR(50),  -- Освітній ступінь

    FOREIGN KEY (student_id) REFERENCES students (student_id),
    FOREIGN KEY (group_id) REFERENCES group_information (group_id)
);

CREATE TABLE disciplines
(
    discipline_id          INT AUTO_INCREMENT PRIMARY KEY,
    discipline_name        VARCHAR(100) NOT NULL, -- Назва дисципліни
    discipline_short_name  VARCHAR(20)  NOT NULL, -- Коротка назва дисципліни
    discipline_translation VARCHAR(100) NOT NULL  -- Переклад дисципліни
);

CREATE TABLE assessment_types
(
    assessment_type_id INT AUTO_INCREMENT PRIMARY KEY,
    assessment_name    VARCHAR(100)                       NOT NULL, -- Назва типу контролю
    assessment_form    ENUM ('First Form', 'Second Form') NOT NULL  -- Форма контролю (перша або друга)
);

CREATE TABLE assessment_part_types
(
    assessment_part_type_id INT AUTO_INCREMENT PRIMARY KEY,
    assessment_name         VARCHAR(100) NOT NULL, -- Назва типу контролю
    assessment_parts        INT          NOT NULL  -- Кількість частин
);

CREATE TABLE departments
(
    department_id           INT AUTO_INCREMENT PRIMARY KEY,
    department_name         VARCHAR(100) NOT NULL, -- Назва кафедри
    department_abbreviation VARCHAR(10)  NOT NULL, -- Абревіатура кафедри
    department_translation  VARCHAR(100) NOT NULL  -- Переклад назви кафедри
);

CREATE TABLE curriculum
(
    curriculum_id               INT AUTO_INCREMENT PRIMARY KEY,
    student_id                  INT,          -- Посилання на студента
    discipline_id               INT,          -- Посилання на дисципліну
    hours_allocated             INT NOT NULL, -- Кількість виділених годин на вивчення
    required_assessment_type_id INT,          -- Посилання на обов'язковий тип контролю
    optional_assessment_type_id INT,          -- Посилання на тип контролю за необхідністю
    department_id               INT,          -- Посилання на кафедру
    FOREIGN KEY (student_id) REFERENCES students (student_id),
    FOREIGN KEY (discipline_id) REFERENCES disciplines (discipline_id),
    FOREIGN KEY (required_assessment_type_id) REFERENCES assessment_types (assessment_type_id),
    FOREIGN KEY (optional_assessment_type_id) REFERENCES assessment_types (assessment_type_id),
    FOREIGN KEY (department_id) REFERENCES departments (department_id)
);

CREATE TABLE grades
(
    grade_id                INT AUTO_INCREMENT PRIMARY KEY,
    student_id              INT,          -- Посилання на студента
    curriculum_id           INT,          -- Посилання на навчальний план
    discipline_id           INT,          -- Посилання на дисципліну
    semester_number         INT NOT NULL, -- Номер семестру, за який виставлена оцінка
    assessment_type_id      INT,          -- Посилання на тип контролю
    assessment_part_type_id INT,          -- Посилання на частини оцінки (якщо контроль ділиться на частини)
    grade                   INT NOT NULL, -- Оцінка
    FOREIGN KEY (student_id) REFERENCES students (student_id),
    FOREIGN KEY (curriculum_id) REFERENCES curriculum (curriculum_id),
    FOREIGN KEY (discipline_id) REFERENCES disciplines (discipline_id),
    FOREIGN KEY (assessment_type_id) REFERENCES assessment_types (assessment_type_id),
    FOREIGN KEY (assessment_part_type_id) REFERENCES assessment_part_types (assessment_part_type_id)
);

CREATE TABLE assessment_part_grades
(
    assessment_part_grade_id INT AUTO_INCREMENT PRIMARY KEY,
    grade_id                 INT,          -- Посилання на оцінку в загальній таблиці Grades
    part_number              INT NOT NULL, -- Номер частини
    part_grade               INT NOT NULL, -- Оцінка за частину
    FOREIGN KEY (grade_id) REFERENCES grades (grade_id)
);