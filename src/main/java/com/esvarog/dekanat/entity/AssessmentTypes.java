package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assessment_types", schema = "dekanat")
public class AssessmentTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_type_id")
    private Integer assessmentTypeId;

    @Column(name = "assessment_name")
    private String assessmentName;

    @Column(name = "assessment_form")
    private Object assessmentForm;

    @OneToMany(mappedBy = "requiredAssessmentType")
    private List<Curriculum> curriculaWithRequiredAssessment;

    @OneToMany(mappedBy = "optionalAssessmentType")
    private List<Curriculum> curriculaWithOptionalAssessment;

}
