package com.example.student_library_management_system.library_management_system.requestDTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BookRequestDTO {

    private String title;
    private String publisherName;
    private boolean availability;
    private int pages;
    private int cardId;

}
