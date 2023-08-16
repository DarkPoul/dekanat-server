package com.esvarog.dekanat.dto;

import lombok.Data;

@Data
public class PassportDTO {
    private int additionalNumber;
    private int identificationCode;
    private String issuingAuthority;
    private String nationality;
    private String passportExpiryDate;
    private int passportNumber;
    private int sex;
}
