package com.esvarog.dekanat.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "grades", schema = "dekanat")
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Integer gradeId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Students student;

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    @ManyToOne
    @JoinColumn(name = "discipline_id", referencedColumnName = "discipline_id")
    private Disciplines discipline;

    @Column(name = "semester_number")
    private Integer semesterNumber;

    @ManyToOne
    @JoinColumn(name = "assessment_type_id")
    private AssessmentTypes assessmentType;

    @ManyToOne
    @JoinColumn(name = "assessment_part_type_id", referencedColumnName = "assessment_part_type_id")
    private AssessmentPartTypes assessmentPartType;

    @Column(name = "grade")
    private Integer grade;

    @OneToMany(mappedBy = "grade")
    private List<AssessmentPartGrades> assessmentPartGrades;

}
