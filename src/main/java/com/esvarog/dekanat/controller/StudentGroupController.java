package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.entity.GroupInformation;
import com.esvarog.dekanat.entity.Result;
import com.esvarog.dekanat.entity.StudentGroup;
import com.esvarog.dekanat.entity.Students;
import com.esvarog.dekanat.service.GroupInformationService;
import com.esvarog.dekanat.service.StudentGroupService;
import com.esvarog.dekanat.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class StudentGroupController {

    private final StudentGroupService studentGroupService;
    private final StudentsService studentsService;
    private final GroupInformationService groupInformationService;

    //метод додавання нової групи
    @PostMapping("/group")
    public Result addGroup(@RequestBody StudentGroup group) {
        System.out.println(group.toString());
        System.out.println(group.getStudents().getStudentId());
        System.out.println(group.getGroupInformation().getGroupId());
        Students student = studentsService.findStudentById(group.getStudents().getStudentId());
        GroupInformation groupInformation = groupInformationService.getGroupInformation(group.getGroupInformation().getGroupId());
        group.setStudents(student);
        group.setGroupInformation(groupInformation);
        studentGroupService.addGroup(group);
        return new Result(true, 200, "Групу додано");
    }

    //метод оновлення інформації про групу по id
    @PutMapping("/group/{id}")
    public Result updateGroup(@RequestBody StudentGroup group, @PathVariable Integer id) {
        group.setStudentGroupId(id);
        return new Result(true, 200, "Інформацію про групу оновлено", studentGroupService.updateGroup(group));
    }

    //метод отримання інформації про групу по id
    @GetMapping("/group/{id}")
    public Result getGroup(@PathVariable Integer id) {
        return new Result(true, 200, "Інформацію про групу отримано", studentGroupService.getGroup(id));
    }

    //метод отримання усіх груп
    @GetMapping("/group")
    public Result getAllGroups() {
        return new Result(true, 200, "Інформацію про групи отримано", studentGroupService.getAllGroups());
    }

    /**
     * Deletes a group by its ID.
     *
     * @param id The ID of the group to be deleted.
     * @return A Result object indicating the status of the deletion.
     */
    //метод видалення групи по id
    @DeleteMapping("/group/{id}")
    public Result deleteGroup(@PathVariable Integer id) {
        studentGroupService.deleteGroup(id);
        return new Result(true, 200, "Групу видалено");
    }



}
