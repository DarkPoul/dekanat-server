package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "education_document_types", schema = "dekanat")
public class EducationDocumentTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_type_id")
    private Integer documentTypeId;
    @Column(name = "type_name_ukr")
    private String typeNameUkr;
    @Column(name = "type_name_eng")
    private String typeNameEng;

}
