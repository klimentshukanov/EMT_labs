package com.example.emt_labs_201100.service.impl;

import com.example.emt_labs_201100.model.Book;
import com.example.emt_labs_201100.model.dto.BookDto;
import com.example.emt_labs_201100.model.exceptions.BookNotFoundException;
import com.example.emt_labs_201100.model.exceptions.CannotRentBookException;
import com.example.emt_labs_201100.repository.BookRepository;
import com.example.emt_labs_201100.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Book book=new Book(bookDto.getName(), bookDto.getCategory(), bookDto.getAuthor(), bookDto.getAvailableCopies());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book=bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        book.setAuthor(bookDto.getAuthor());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(bookDto.getCategory());
        bookDto.setName(bookDto.getName());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> rentBook(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        if(book.getAvailableCopies()==0)
        {
            throw new CannotRentBookException();
        }
        else
        {
            book.setAvailableCopies(book.getAvailableCopies()-1);
        }
        return Optional.of(bookRepository.save(book));
    }
}
