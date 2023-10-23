package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Data
@Getter
@Setter
@Transactional
@AllArgsConstructor
@Table(name = "pass_data")
public class PassData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number_of_document")
    private String numberOfDocument;
    @Column(name = "issuing_authority")
    private String issuingAuthority;
    @Column(name = "record_number")
    private String recordNumber;
    @Column(name = "identification_code")
    private String identificationCode;
    private Boolean sex;
    private Boolean nationality;
    @Column(name = "issue_date")
    private Date issueDate;
    private Date birthdate;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
    private String address;

    public PassData() {
    }



}
