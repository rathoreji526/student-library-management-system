package com.example.student_library_management_system.library_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    private int id;

    @Column (name = "title" , nullable = false)
    private String title;

    @Column(name = "publisher_name" , nullable = false)
    private String publisherName;

    @Column(name = "availability" , nullable = false)
    private boolean availability;

    @Column(name = "pages" , nullable = false)
    public int pages;

    //book and card connection
    @ManyToOne
    @JoinColumn
    private Card card;

    //book and transaction connection
    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;
}
