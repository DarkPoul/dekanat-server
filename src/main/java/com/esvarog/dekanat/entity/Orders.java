package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders", schema = "dekanat")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Students student;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "description")
    private String description;

}
