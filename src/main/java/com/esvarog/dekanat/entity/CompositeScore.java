package com.esvarog.dekanat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class CompositeScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mark1;
    private String mark2;
    private String mark3;
    private String mark4;
    private String mark5;
    private String mark6;
    private String mark7;
    private String mark8;

    public CompositeScore() {
        this.mark1 = "NULL";
        this.mark2 = "NULL";
        this.mark3 = "NULL";
        this.mark4 = "NULL";
        this.mark5 = "NULL";
        this.mark6 = "NULL";
        this.mark7 = "NULL";
        this.mark8 = "NULL";
    }

    public CompositeScore
            (
                    String mark1, String mark2, String mark3, String mark4,
                    String mark5, String mark6, String mark7, String mark8
            )
    {
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
        this.mark5 = mark5;
        this.mark6 = mark6;
        this.mark7 = mark7;
        this.mark8 = mark8;
    }
}
