package com.example.student_library_management_system.library_management_system.requestDTO;

import com.example.student_library_management_system.library_management_system.enums.CardStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
public class CardRequestDTO {

    private CardStatus cardStatus;
    private int studentId;
}
