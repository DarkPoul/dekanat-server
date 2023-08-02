package com.esvarog.ua.Dekanat.model.table;

import javax.persistence.*;

@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facultyId;

    @Column(name = "faculty_name")
    private String facultyName;

    @Column(name = "faculty_abbreviation")
    private String facultyAbbreviation;

    @Column(name = "dean_name")
    private String deanName;

    public Long getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getFacultyAbbreviation() {
        return facultyAbbreviation;
    }

    public String getDeanName() {
        return deanName;
    }
}
