package com.example.student_library_management_system.library_management_system.services;


import com.example.student_library_management_system.library_management_system.enums.CardStatus;
import com.example.student_library_management_system.library_management_system.enums.Gender;
import com.example.student_library_management_system.library_management_system.model.Card;
import com.example.student_library_management_system.library_management_system.model.Student;
import com.example.student_library_management_system.library_management_system.repository.StudentRepository;
import com.example.student_library_management_system.library_management_system.requestDTO.StudentRequestDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {
    @Autowired
    StudentRepository studentRepository;

    public String saveStudent(StudentRequestDTO studentRequestDTO){
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setMobile(studentRequestDTO.getMobile());
        student.setDept(studentRequestDTO.getDept());
        student.setSem(studentRequestDTO.getSem());
        student.setGender(studentRequestDTO.getGender());
        student.setAddress(studentRequestDTO.getAddress());
        student.setDob(studentRequestDTO.getDob());

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setExpiryDate(LocalDate.now().plusYears(3).toString());
        card.setStudent(student);
        student.setCard(card);
        studentRepository.save(student);
        return "Student saved successfully!";
    }

    public Student findStudentById(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent())return studentOptional.get();
        else throw new RuntimeException("Student with "+id+" not present!");
    }

    public List<Student> getStudentList(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public String deleteStudentById(int id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            studentRepository.deleteById(id);
            return "Student deleted successfully!";
        }else
            return "Student with id "+id+" not found";
    }

    public String updateStudentUsingPut(int id , StudentRequestDTO studentRequestDTO){
        Student student = findStudentById(id);
        if(student!=null){
            student.setName(studentRequestDTO.getName());
            student.setEmail(studentRequestDTO.getEmail());
            student.setMobile(studentRequestDTO.getMobile());
            student.setDept(studentRequestDTO.getDept());
            student.setSem(studentRequestDTO.getSem());
            student.setGender(studentRequestDTO.getGender());
            student.setAddress(studentRequestDTO.getAddress());
            student.setDob(studentRequestDTO.getDob());
            return "Student updated successfully!";
        }
        return "Student with id "+ id+" not found!";
    }

    public List<Student> findAllPage(int pageNo , int pageSize , String sortType){
        List<Student> students = studentRepository.findAll(PageRequest.of(pageNo , pageSize , Sort.by(sortType))).getContent();
        System.out.println(sortType);
        return students;
    }


}

