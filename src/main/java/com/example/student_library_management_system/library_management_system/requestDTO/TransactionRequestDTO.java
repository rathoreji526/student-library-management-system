package com.example.student_library_management_system.library_management_system.requestDTO;

import com.example.student_library_management_system.library_management_system.enums.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class  TransactionRequestDTO {

    private String dueDate;
    private TransactionType transactionType;
    private int bookId;
    private int cardId;

}
