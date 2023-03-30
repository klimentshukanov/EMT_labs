package com.example.emt_labs_201100.config;

import com.example.emt_labs_201100.service.AuthorService;
import com.example.emt_labs_201100.service.BookService;
import com.example.emt_labs_201100.service.CountryService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInit {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;


    public DataInit(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @PostConstruct
    private void init()
    {

    }
}
