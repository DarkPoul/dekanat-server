package com.esvarog.dekanat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "group_information", schema = "dekanat")
public class GroupInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_abbreviation")
    private String groupAbbreviation;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculties faculty;

    @OneToMany(mappedBy = "groupInformation")
    @JsonIgnore
    private List<StudentGroup> studentGroups;

    public int getId() {
        return groupId;
    }
}
