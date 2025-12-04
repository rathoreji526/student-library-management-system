package com.example.student_library_management_system.library_management_system.model;

import com.example.student_library_management_system.library_management_system.enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "card_status" , nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @Column(name = "expiry_date" , nullable = false)
    private String expiryDate;

    @Column(name = "created_date")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "update_date")
    @CreationTimestamp
    private Date updatedDate;

    //card and student connection
    @OneToOne
    @JoinColumn
    @JsonBackReference
    private Student student;

    //card and transaction connection

    @OneToMany(mappedBy = "card")
    private List<Transaction> transactionList;

    //card and book connection
    @OneToMany(mappedBy = "card")
    private List<Book> bookList;



}
