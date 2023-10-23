package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Transactional
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String yearGroup;
    private String numberOfGroup;
    private String yearOfStart;
    private Boolean formOfStudy;

    @ManyToOne
    @JoinColumn(name = "faculty")
    private Faculty faculty;

    private Boolean gradeType;
    private Boolean technical;

    public Group() {
    }
}
