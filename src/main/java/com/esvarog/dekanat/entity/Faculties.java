package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "faculties", schema = "dekanat")
public class Faculties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Integer facultyId;

    @Column(name = "faculty_name")
    private String facultyName;

    @Column(name = "dean_name")
    private String deanName;

    @Column(name = "dean_surname")
    private String deanSurname;

    @Column(name = "abbreviation")
    private String abbreviation;

    @OneToMany(mappedBy = "faculty")
    private List<Students> students;

}
