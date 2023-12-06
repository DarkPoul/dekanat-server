package com.esvarog.dekanat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students", schema = "dekanat")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "first_name_ukr")
    private String firstNameUkr;

    @Column(name = "last_name_ukr")
    private String lastNameUkr;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "first_name_eng")
    private String firstNameEng;

    @Column(name = "last_name_eng")
    private String lastNameEng;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private Object gender;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "region_id")
    private Regions region;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "faculty_id")
    private Faculties faculty;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "passport_issued_by")
    private String passportIssuedBy;

    @Column(name = "passport_issue_date")
    private Date passportIssueDate;

    @Column(name = "passport_expiry_date")
    private Date passportExpiryDate;

    @Column(name = "passport_registration_number")
    private String passportRegistrationNumber;

    @Column(name = "citizenship")
    private Object citizenship;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "student_card_number")
    private String studentCardNumber;

    @Column(name = "record_book_number")
    private String recordBookNumber;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "education_document_type_id")
    private EducationDocumentTypes educationDocumentType;

    @Column(name = "education_document_series")
    private String educationDocumentSeries;

    @Column(name = "education_document_number")
    private String educationDocumentNumber;

    @Column(name = "education_document_issue_date")
    private Date educationDocumentIssueDate;

    @Column(name = "education_document_issue_place_ukr")
    private String educationDocumentIssuePlaceUkr;

    @Column(name = "education_document_issue_place_eng")
    private String educationDocumentIssuePlaceEng;

    //TODO обдумати чи потрібні тут наступні три поля

    @OneToMany(mappedBy = "students")
    @JsonIgnore
    private List<StudentGroup> studentGroups;

    @OneToMany(mappedBy = "student")
    private List<Curriculum> curriculums;

    @OneToMany(mappedBy = "student")
    private List<Grades> grades;

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", firstNameUkr='" + firstNameUkr + '\'' +
                ", lastNameUkr='" + lastNameUkr + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", firstNameEng='" + firstNameEng + '\'' +
                ", lastNameEng='" + lastNameEng + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", region=" + region +
                ", address='" + address + '\'' +
                ", faculty=" + faculty +
                ", passportNumber='" + passportNumber + '\'' +
                ", passportIssuedBy='" + passportIssuedBy + '\'' +
                ", passportIssueDate=" + passportIssueDate +
                ", passportExpiryDate=" + passportExpiryDate +
                ", passportRegistrationNumber='" + passportRegistrationNumber + '\'' +
//                ", citizenship=" + citizenship +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", studentCardNumber='" + studentCardNumber + '\'' +
                ", recordBookNumber='" + recordBookNumber + '\'' +
                ", educationDocumentType=" + educationDocumentType +
                ", educationDocumentSeries='" + educationDocumentSeries + '\'' +
                ", educationDocumentNumber='" + educationDocumentNumber + '\'' +
                ", educationDocumentIssueDate=" + educationDocumentIssueDate +
                ", educationDocumentIssuePlaceUkr='" + educationDocumentIssuePlaceUkr + '\'' +
                ", educationDocumentIssuePlaceEng='" + educationDocumentIssuePlaceEng + '\'' +

                '}';
    }
}
