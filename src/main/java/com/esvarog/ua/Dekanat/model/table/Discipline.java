package com.esvarog.ua.Dekanat.model.table;

import javax.persistence.*;

@Entity
@Table(name = "discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disciplineId;

    @Column(name = "discipline_name")
    private String disciplineName;

    @Column(name = "translation")
    private String translation;

    @Column(name = "verified")
    private Integer Verified;

    public Long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Integer getVerified() {
        return Verified;
    }

    public void setVerified(Integer verified) {
        Verified = verified;
    }
}
