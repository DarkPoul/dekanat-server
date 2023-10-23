package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    private String surname;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name_eng")
    private String firstNameEng;
    @Column(name = "last_name_eng")
    private String lastNameEng;
    @Column(name = "applicant_card_number")
    private String applicantCardNumber;
    @Column(name = "number_of_the_record_book")
    private String numberOfTheRecordBook;
    @Column(name = "contract_number")
    private String contractNumber;
    @Column(name = "card_number_of_the_individual")
    private String cardNumberOfTheIndividual;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;

    @ManyToOne
    @JoinColumn(name = "pass_data_id")
    private PassData passData;

    @ManyToOne
    @JoinColumn(name = "prior_education_id")
    private PriorEducation priorEducation;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderStudent orderStudent;

    @ManyToMany
    @JoinTable(
            name = "student_group",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Group> groups;
}
