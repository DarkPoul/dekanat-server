package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "order_type", schema = "dekanat")
public class OrderType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_type_id")
    private Integer orderTypeId;
    @Basic
    @Column(name = "order_title")
    private String orderTitle;
}
