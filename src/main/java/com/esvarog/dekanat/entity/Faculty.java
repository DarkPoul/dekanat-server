package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@Transactional
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String deanName;
    private String deanLastName;
    private String facultyName;
    private String facultyAbr;

    @OneToMany(mappedBy = "faculty")
    private List<Group> groups;

    public Faculty() {
    }

    public Faculty(String deanName, String deanLastName, String facultyName, String facultyAbr, List<Group> groups) {
        this.deanName = deanName;
        this.deanLastName = deanLastName;
        this.facultyName = facultyName;
        this.facultyAbr = facultyAbr;
        this.groups = groups;
    }
}
