CREATE TABLE Users
(
    id        BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    enabled   BIT          NOT NULL,
    password  VARCHAR(255) NOT NULL,
    role      VARCHAR(255) NOT NULL,
    username  VARCHAR(255) NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Student
(
    id                            INT AUTO_INCREMENT PRIMARY KEY,

    first_name                    VARCHAR(255),
    surname                       VARCHAR(255),
    last_name                     VARCHAR(255),

    first_name_eng                VARCHAR(255),
    last_name_eng                 VARCHAR(255),

    applicant_card_number         VARCHAR(255),
    number_of_the_record_book     VARCHAR(255),
    contract_number               VARCHAR(255),
    card_number_of_the_individual VARCHAR(255),

    phone_number                  VARCHAR(255),
    email                         VARCHAR(255),

    pass_data_id                  INT,
    prior_education_id            INT,
    order_id                      INT,

    createdAt                     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt                     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE faculty
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    dean_name      VARCHAR(255),
    dean_last_name VARCHAR(255),
    faculty_name   VARCHAR(255),
    faculty_abr    VARCHAR(255)
);

CREATE TABLE `group`
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    title           VARCHAR(255),
    year_group      VARCHAR(255),
    number_of_group VARCHAR(255),
    year_of_start   VARCHAR(255),
    form_of_study   BOOLEAN,
    faculty         INT,
    grade_type      BOOLEAN,
    technical       BOOLEAN,
    FOREIGN KEY (faculty) REFERENCES faculty (id)
);

CREATE TABLE student_group
(
    student_id INT,
    group_id   INT,
    FOREIGN KEY (student_id) REFERENCES student (id),
    FOREIGN KEY (group_id) REFERENCES `group` (id)
);

CREATE TABLE district
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255)
);

CREATE TABLE order_student (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         number VARCHAR(255),
                         text TEXT
);

CREATE TABLE pass_data
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    number_of_document  VARCHAR(255),
    issuing_authority   VARCHAR(255),
    record_number       VARCHAR(255),
    identification_code VARCHAR(255),
    sex                 BOOLEAN,
    nationality         BOOLEAN,
    issue_date          DATE,
    birthdate           DATE,
    district_id         INT,
    address             VARCHAR(255),
    FOREIGN KEY (district_id) REFERENCES district (id)
);

CREATE TABLE prior_education (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 type_of_document INT,
                                 seria VARCHAR(255),
                                 number VARCHAR(255),
                                 issue_date DATE,
                                 title_of_institution VARCHAR(255)
);

