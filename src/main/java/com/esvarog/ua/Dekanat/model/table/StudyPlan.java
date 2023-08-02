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
    @JoinColumn(name = "control_method_id")
    private ControlMethod controlMethod;

    @OneToMany(mappedBy = "studyPlan")
    private List<Grade> grades;

    @ManyToMany
    @JoinTable(name = "study_plan_control_methods",
            joinColumns = @JoinColumn(name = "plan_id", referencedColumnName = "plan_id"),
            inverseJoinColumns = @JoinColumn(name = "method_id", referencedColumnName = "method_id"))
    private List<ControlMethod> controlMethods;

    @Column(name = "plan_id", insertable = false, updatable = false)
    @Index(name = "idx_plan_id")
    private Long planIdIndex;

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

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
