package com.example.emt_labs_201100.service;

import com.example.emt_labs_201100.model.Book;
import com.example.emt_labs_201100.model.dto.BookDto;
import com.example.emt_labs_201100.model.exceptions.BookNotFoundException;
import com.example.emt_labs_201100.model.exceptions.CannotRentBookException;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listAll();
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id, BookDto bookDto);
    Optional<Book> findById(Long id);
    void deleteById(Long id);
    Optional<Book> rentBook(Long id);
}
