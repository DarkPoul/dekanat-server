package com.esvarog.ua.Dekanat.model.table;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passportId;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "passport_expiry_date")
    private Date passportExpiryDate;

    @Column(name = "issuing_authority")
    private String issuing_authority;

    @Column(name = "additional_number")
    private String additional_number;

    @Column(name = "identification_code")
    private String identification_code;

    @Column(name = "nationality")
    private Integer nationality;

    @Column(name = "sex")
    private Integer sex;
}
