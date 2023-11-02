package com.esvarog.dekanat.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "assessment_part_grades", schema = "dekanat")
public class AssessmentPartGrades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_part_grade_id")
    private Integer assessmentPartGradeId;

    @ManyToOne
    @JoinColumn(name = "grade_id", referencedColumnName = "grade_id")
    private Grades grade;

    @Column(name = "part_number")
    private Integer partNumber;

    @Column(name = "part_grade")
    private Double partGrade;

}
