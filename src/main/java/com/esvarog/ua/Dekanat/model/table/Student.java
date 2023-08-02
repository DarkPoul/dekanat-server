package com.esvarog.ua.Dekanat.model.table;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "first_name_eng")
    private String firstName_eng;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_name_eng")
    private String lastName_eng;

    @Column(name = "sur_name_eng")
    private String surName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "applicant_card_number")
    private String applicant_card_number;

    @Column(name = "number_of_the_record_book")
    private String number_of_the_record_book;

    @Column(name = "contract_number")
    private String contract_number;

    @Column(name = "card_number_of_an_individual")
    private String card_number_of_an_individual;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private StudentGroup group;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private StudyPlan studyPlan;

    @ManyToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToOne(mappedBy = "student")
    private PreviousEducation previousEducation;

    @OneToOne(mappedBy = "student")
    private DiplomaInfo diplomaInfo;

    @OneToMany(mappedBy = "student")
    private List<Orders> orders;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName_eng() {
        return firstName_eng;
    }

    public void setFirstName_eng(String firstName_eng) {
        this.firstName_eng = firstName_eng;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName_eng() {
        return lastName_eng;
    }

    public void setLastName_eng(String lastName_eng) {
        this.lastName_eng = lastName_eng;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getApplicant_card_number() {
        return applicant_card_number;
    }

    public void setApplicant_card_number(String applicant_card_number) {
        this.applicant_card_number = applicant_card_number;
    }

    public String getNumber_of_the_record_book() {
        return number_of_the_record_book;
    }

    public void setNumber_of_the_record_book(String number_of_the_record_book) {
        this.number_of_the_record_book = number_of_the_record_book;
    }

    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public String getCard_number_of_an_individual() {
        return card_number_of_an_individual;
    }

    public void setCard_number_of_an_individual(String card_number_of_an_individual) {
        this.card_number_of_an_individual = card_number_of_an_individual;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    public StudyPlan getStudyPlan() {
        return studyPlan;
    }

    public void setStudyPlan(StudyPlan studyPlan) {
        this.studyPlan = studyPlan;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public PreviousEducation getPreviousEducation() {
        return previousEducation;
    }

    public void setPreviousEducation(PreviousEducation previousEducation) {
        this.previousEducation = previousEducation;
    }

    public DiplomaInfo getDiplomaInfo() {
        return diplomaInfo;
    }

    public void setDiplomaInfo(DiplomaInfo diplomaInfo) {
        this.diplomaInfo = diplomaInfo;
    }
}

