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
public class StudentPlanStudentMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_plan_id")
    private StudentPlan studentPlan;

    @ManyToOne
    @JoinColumn(name = "first_type_of_control_id")
    private TypeOfControl firstTypeOfControl;
    private String firstTypeOfControlMark;

    @ManyToOne
    @JoinColumn(name = "second_type_of_control_id")
    private TypeOfControl secondTypeOfControl;

    @ManyToOne
    @JoinColumn(name = "composite_score_id")
    private CompositeScore compositeScore;

    public StudentPlanStudentMark() {
    }
}
