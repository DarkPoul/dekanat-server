package com.esvarog.ua.Dekanat.model.table;

import org.hibernate.annotations.Index;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "study_plan")
public class StudyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long planId;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @Column(name = "semester_number")
    private int semesterNumber;

    @Column(name = "hours")
    private int hours;

    @ManyToOne
    @JoinColumn(name = "first_method_control", referencedColumnName = "method_id")
    private ControlMethod firstMethodControl;

    @ManyToOne
    @JoinColumn(name = "second_method_control", referencedColumnName = "method_id")
    private ControlMethod secondMethodControl;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student_id;




    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
