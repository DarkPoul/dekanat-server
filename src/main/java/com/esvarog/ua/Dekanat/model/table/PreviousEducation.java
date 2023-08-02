package com.esvarog.ua.Dekanat.model.table;

import javax.persistence.*;

@Entity
@Table(name = "previous_education")
public class PreviousEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long previousEducationId;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "type_of_document")
    private String type_of_document;

    @Column(name = "serial_of_document")
    private String serial_of_document;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "date_of_graduation")
    private int date_of_graduation;

    public Long getPreviousEducationId() {
        return previousEducationId;
    }

    public void setPreviousEducationId(Long previousEducationId) {
        this.previousEducationId = previousEducationId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getType_of_document() {
        return type_of_document;
    }

    public void setType_of_document(String type_of_document) {
        this.type_of_document = type_of_document;
    }

    public String getSerial_of_document() {
        return serial_of_document;
    }

    public void setSerial_of_document(String serial_of_document) {
        this.serial_of_document = serial_of_document;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getDate_of_graduation() {
        return date_of_graduation;
    }

    public void setDate_of_graduation(int date_of_graduation) {
        this.date_of_graduation = date_of_graduation;
    }
}

