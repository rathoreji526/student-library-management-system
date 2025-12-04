package com.example.student_library_management_system.library_management_system.services;


import com.example.student_library_management_system.library_management_system.enums.CardStatus;
import com.example.student_library_management_system.library_management_system.enums.Gender;
import com.example.student_library_management_system.library_management_system.model.Card;
import com.example.student_library_management_system.library_management_system.model.Student;
import com.example.student_library_management_system.library_management_system.repository.StudentRepository;
import com.example.student_library_management_system.library_management_system.requestDTO.StudentRequestDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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


}

