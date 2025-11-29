package com.example.student_library_management_system.library_management_system.model;

import com.example.student_library_management_system.library_management_system.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.repository.cdi.Eager;

import java.util.Date;

@Entity
@Data
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "transaction_date" , nullable = false)
    @CreationTimestamp
    private Date transactionDate;

    @Column(name = "dueDate" , nullable = false)
    private String dueDate;

    @Column(name = "transaction_type" , nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    //card and transaction connection
    @ManyToOne
    @JoinColumn
    private Card card;

    //book and transaction connection
    @ManyToOne
    @JoinColumn
    private Book book;
}
