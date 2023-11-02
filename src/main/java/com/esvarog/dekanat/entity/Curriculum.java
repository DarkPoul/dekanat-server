package com.esvarog.dekanat.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "curriculum", schema = "dekanat")
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curriculum_id")
    private Integer curriculumId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students student;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Disciplines discipline;

    @Column(name = "hours_allocated")
    private Integer hoursAllocated;

    @ManyToOne
    @JoinColumn(name = "required_assessment_type_id", referencedColumnName = "assessment_type_id")
    private AssessmentTypes requiredAssessmentType;

    @ManyToOne
    @JoinColumn(name = "optional_assessment_type_id", referencedColumnName = "assessment_type_id")
    private AssessmentTypes optionalAssessmentType;

    @ManyToOne
    @JoinColumn(name = "department_id") // Вказуємо поле для зв'язку
    private Departments department;

    @OneToMany(mappedBy = "curriculum")
    private List<Grades> grades;

}
