package com.example.emt_labs_201100.service.impl;

import com.example.emt_labs_201100.model.Book;
import com.example.emt_labs_201100.repository.BookRepository;
import com.example.emt_labs_201100.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }
}
