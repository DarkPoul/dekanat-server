package com.esvarog.ua.Dekanat.model.table;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "order_type_id")
    private OrderType orderType;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "order_date")
    private Date orderDate;
}
