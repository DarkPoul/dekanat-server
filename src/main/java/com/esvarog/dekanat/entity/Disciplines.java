package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "disciplines", schema = "dekanat")
public class Disciplines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discipline_id")
    private Integer disciplineId;

    @Column(name = "discipline_name")
    private String disciplineName;

    @Column(name = "discipline_short_name")
    private String disciplineShortName;

    @Column(name = "discipline_translation")
    private String disciplineTranslation;

    @OneToMany(mappedBy = "discipline")
    private List<Grades> grades;

}
