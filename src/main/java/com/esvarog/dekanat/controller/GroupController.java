package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.dto.GroupDTO;
import com.esvarog.dekanat.entity.StudentGroup;
import com.esvarog.dekanat.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/group/create")
    public ResponseEntity<StudentGroup> create(@RequestBody GroupDTO dto){
        return new ResponseEntity<>(groupService.create(dto), HttpStatus.OK);
    }

    @GetMapping("/group/reedAll")
    public ResponseEntity<List<StudentGroup>> reed(){
        return new ResponseEntity<>(groupService.reedAll(), HttpStatus.OK);
    }

    @GetMapping("/group/readByID/{id}")
    public ResponseEntity<StudentGroup> reedById(@PathVariable Long id){
        return new ResponseEntity<>(groupService.reedById(id), HttpStatus.OK);
    }

    @PutMapping("/group/update")
    public ResponseEntity<StudentGroup> update(@RequestBody StudentGroup studentGroup){
        return new ResponseEntity<>(groupService.update(studentGroup), HttpStatus.OK);
    }

    @DeleteMapping("/group/delete/{id}")
    public HttpStatus delete(@PathVariable Long id){
        groupService.delete(id);
        return HttpStatus.OK;
    }
}
