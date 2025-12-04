package com.example.student_library_management_system.library_management_system.services;

import com.example.student_library_management_system.library_management_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServices {

    @Autowired
    BookRepository bookRepository;

}
