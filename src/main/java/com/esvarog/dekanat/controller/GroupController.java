package com.esvarog.dekanat.controller;


import com.esvarog.dekanat.entity.Result;
import com.esvarog.dekanat.service.GroupInformationService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
@AllArgsConstructor
public class GroupController {

    private final GroupInformationService groupInformationService;


    @GetMapping("/group")
    public Result getAllGroups() {
        Map<String, Object> claims = ((JwtAuthenticationToken)SecurityContextHolder.getContext().getAuthentication()).getToken().getClaims();
        Integer facultyId = Integer.valueOf(claims.get("facultyId").toString()) ;

        return new Result(true, 200, "Information about groups is received", groupInformationService.getByFacultyId(facultyId));
    }

}
