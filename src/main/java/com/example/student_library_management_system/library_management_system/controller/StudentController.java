package com.example.student_library_management_system.library_management_system.controller;

import com.example.student_library_management_system.library_management_system.model.Student;
import com.example.student_library_management_system.library_management_system.requestDTO.StudentRequestDTO;
import com.example.student_library_management_system.library_management_system.services.StudentServices;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServices studentServices;

    @PostMapping("/save")
    public String  saveStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        String response = studentServices.saveStudent(studentRequestDTO);
        return response;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable int id){
        try{
            Student student = studentServices.findStudentById(id);
            return ResponseEntity.ok(student);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Student with id : "+id+" not found"+e.getMessage());
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteStudentById(@PathVariable int id){
        return studentServices.deleteStudentById(id);
    }

    @PutMapping("/update/{id}")
    public String updateById(@PathVariable int id ,@RequestBody StudentRequestDTO studentRequestDTO){
        String response =  studentServices.updateStudentUsingPut(id , studentRequestDTO);
        return response;
    }

    @GetMapping("/findAllByPage")
    public List<Student> findAllByPage(@RequestParam int pageNo ,@RequestParam int pageSize , @RequestParam String sortType){
        List<Student> students =  studentServices.findAllPage(pageNo , pageSize , sortType);
        return students;
    }
}
