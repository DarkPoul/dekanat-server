package com.esvarog.dekanat.service;

import com.esvarog.dekanat.dto.PassportDTO;
import com.esvarog.dekanat.entity.Passport;
import com.esvarog.dekanat.repository.PassportRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PassportService {
    private final PassportRepo passportRepo;

    public Passport create(PassportDTO dto) {
        return  passportRepo.save(Passport.builder()
                        .additionalNumber(dto.getAdditionalNumber())
                        .identificationCode(dto.getIdentificationCode())
                        .issuingAuthority(dto.getIssuingAuthority())
                        .nationality(dto.getNationality())
                        .passportExpiryDate(dto.getPassportExpiryDate())
                        .passportNumber(dto.getPassportNumber())
                        .sex(dto.getSex())
                .build());
    }

    public List<Passport> reed(){return passportRepo.findAll();}

    public Passport reed(Long id){
        return passportRepo.findById(id).orElseThrow(()-> new RuntimeException("Passport not found -> "+ id));
    }

    public Passport update(Passport passport){return passportRepo.save(passport);}

    public void delete(Long id){passportRepo.deleteById(id);}

}
