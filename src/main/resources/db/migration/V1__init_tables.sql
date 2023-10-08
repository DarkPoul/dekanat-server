CREATE TABLE Users
(
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    enabled  BIT          NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
CREATE TABLE Student
(
    id           BIGINT NOT NULL AUTO_INCREMENT,
    firstName    VARCHAR(255),
    lastName     VARCHAR(255),
    surName      VARCHAR(255),
    dateOfBirth  DATE,
    firstNameEng VARCHAR(255),
    lastNameEng  VARCHAR(255),
    address      VARCHAR(255),
    email        VARCHAR(255),
    phoneNumber  VARCHAR(255),
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);