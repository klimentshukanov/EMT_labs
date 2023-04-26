package com.example.emt_labs_201100.service.impl;

import com.example.emt_labs_201100.model.Book;
import com.example.emt_labs_201100.model.dto.BookDto;
import com.example.emt_labs_201100.model.exceptions.AuthorNotFoundException;
import com.example.emt_labs_201100.model.exceptions.BookNotFoundException;
import com.example.emt_labs_201100.model.exceptions.CannotRentBookException;
import com.example.emt_labs_201100.repository.AuthorRepository;
import com.example.emt_labs_201100.repository.BookRepository;
import com.example.emt_labs_201100.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Book book=new Book(bookDto.getName(), bookDto.getCategory(), authorRepository.findById(bookDto.getAuthor()).orElseThrow(AuthorNotFoundException::new), bookDto.getAvailableCopies());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book=bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        book.setAuthor(authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFoundException()));
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(bookDto.getCategory());
        book.setName(bookDto.getName());
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
        Book book=bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

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
