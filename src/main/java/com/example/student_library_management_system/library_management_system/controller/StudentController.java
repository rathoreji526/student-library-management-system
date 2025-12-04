package com.example.student_library_management_system.library_management_system.controller;

import com.example.student_library_management_system.library_management_system.requestDTO.StudentRequestDTO;
import com.example.student_library_management_system.library_management_system.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServices studentServices;

    @PostMapping("/saveStudent")
    public String  saveStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        String response = studentServices.saveStudent(studentRequestDTO);
        return response;
    }
}
