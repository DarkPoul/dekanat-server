package com.esvarog.ua.Dekanat.model.table;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "diploma_info")
public class DiplomaInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diplomaId;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "diploma_title")
    private String diplomaTitle;

    @Column(name = "diploma_grade")
    private String diplomaGrade;

    @Column(name = "diploma_date")
    private Date diplomaDate;

    public Long getDiplomaId() {
        return diplomaId;
    }

    public void setDiplomaId(Long diplomaId) {
        this.diplomaId = diplomaId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getDiplomaTitle() {
        return diplomaTitle;
    }

    public void setDiplomaTitle(String diplomaTitle) {
        this.diplomaTitle = diplomaTitle;
    }

    public String getDiplomaGrade() {
        return diplomaGrade;
    }

    public void setDiplomaGrade(String diplomaGrade) {
        this.diplomaGrade = diplomaGrade;
    }

    public Date getDiplomaDate() {
        return diplomaDate;
    }

    public void setDiplomaDate(Date diplomaDate) {
        this.diplomaDate = diplomaDate;
    }
}

