package com.example.student_library_management_system.library_management_system.requestDTO;

import com.example.student_library_management_system.library_management_system.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class StudentRequestDTO {

    private String name;
    private String email;
    private String mobile;
    private String dept;
    private String sem;
    private String gender;
    private String address;
    private String dob;

}
