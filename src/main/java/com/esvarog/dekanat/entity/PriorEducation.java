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
@Table(name = "prior_education")
public class PriorEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type_of_document")
    private Integer typeOfDocument;
    private String seria;
    private String number;
    @Column(name = "issue_date")
    private Date issueDate;
    @Column(name = "title_of_institution")
    private String titleOfInstitution;

    public PriorEducation() {
    }
}
