CREATE TABLE Users (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       enabled BIT NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(255) NOT NULL,
                       username VARCHAR(255) NOT NULL,
                       PRIMARY KEY (id)
);