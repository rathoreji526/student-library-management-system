package com.example.student_library_management_system.library_management_system.model;


import com.example.student_library_management_system.library_management_system.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "email" , nullable = false , unique = true)
    private String email;

    @Column(name = "mobile" ,nullable = false , unique = true)
    private String mobile;

    @Column(name = "dept" , nullable = false)
    private String dept;

    @Column(name = "sem" , nullable = false)
    private String sem;

    @Column(name = "gender",nullable = false)
    private String gender;

    @Column(name = "address" , nullable = false)
    private String address;

    @Column(name = "dob" , nullable = false)
    private String dob;

    //connection of student and card
    @JsonManagedReference
    @OneToOne(mappedBy = "student" , cascade = CascadeType.ALL)
    private Card card;

}
