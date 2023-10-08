CREATE TABLE Student (
    id BIGINT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    surName VARCHAR(255),
    dateOfBirth DATE,
    firstNameEng VARCHAR(255),
    lastNameEng VARCHAR(255),
    address VARCHAR(255),
    email VARCHAR(255),
    phoneNumber VARCHAR(255),
    PRIMARY KEY (id));