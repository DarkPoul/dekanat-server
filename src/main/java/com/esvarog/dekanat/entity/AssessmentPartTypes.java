package com.esvarog.dekanat.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "assessment_part_types", schema = "dekanat")
public class AssessmentPartTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_part_type_id")
    private Integer assessmentPartTypeId;

    @Column(name = "assessment_name")
    private String assessmentName;

    @Column(name = "assessment_parts")
    private Integer assessmentParts;

}
