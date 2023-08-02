package com.esvarog.ua.Dekanat.model.table;

import javax.persistence.*;

@Entity
@Table(name = "student_group")
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @Column(name = "specialty_abbreviation")
    private String specialtyAbbreviation;

    @Column(name = "course_number")
    private int courseNumber;

    @Column(name = "group_number")
    private String groupNumber;

    @Column(name = "admission_year")
    private int admissionYear;

    @Column(name = "form_of_study")
    private int form_of_study;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getSpecialtyAbbreviation() {
        return specialtyAbbreviation;
    }

    public void setSpecialtyAbbreviation(String specialtyAbbreviation) {
        this.specialtyAbbreviation = specialtyAbbreviation;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public int getForm_of_study() {
        return form_of_study;
    }

    public void setForm_of_study(int form_of_study) {
        this.form_of_study = form_of_study;
    }
}

