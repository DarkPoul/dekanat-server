package com.esvarog.ua.Dekanat.model.table;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "control_method")
public class ControlMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "method_id")
    private Long methodId;

    @Column(name = "method_name")
    private String methodName;



    // Геттери та сеттери

    public Long getMethodId() {
        return methodId;
    }

    public void setMethodId(Long methodId) {
        this.methodId = methodId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

}
