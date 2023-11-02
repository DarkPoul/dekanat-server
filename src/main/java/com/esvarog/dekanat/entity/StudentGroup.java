package com.esvarog.dekanat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_group", schema = "dekanat")
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_group_id")
    private Integer studentGroupId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students students;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupInformation groupInformation;

    @Column(name = "course_number")
    private Integer courseNumber;

    @Column(name = "group_number")
    private Integer groupNumber;

    @Column(name = "creation_year")
    private Integer creationYear;

    @Column(name = "came_from_technicum")
    private Byte cameFromTechnicum;

    @Column(name = "study_form")
    private String studyForm;

    @Column(name = "educational_degree")
    private String educationalDegree;

}
