package com.example.emt_labs_201100.config;

import com.example.emt_labs_201100.model.Author;
import com.example.emt_labs_201100.model.Book;
import com.example.emt_labs_201100.model.Country;
import com.example.emt_labs_201100.model.dto.AuthorDto;
import com.example.emt_labs_201100.model.dto.BookDto;
import com.example.emt_labs_201100.model.dto.CountryDto;
import com.example.emt_labs_201100.model.enums.Category;
import com.example.emt_labs_201100.service.AuthorService;
import com.example.emt_labs_201100.service.BookService;
import com.example.emt_labs_201100.service.CountryService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
        for (int i=1; i<=5; i++)
        {
            countryService.save(new CountryDto("Country"+i, "Europe"));
            authorService.save(new AuthorDto("Name"+i, "LastName"+i, countryService.findById((long) i).orElse(null)));
            bookService.save(new BookDto("Book"+i, Arrays.stream(Category.values()).toList().get((int) ((Math.random() * 6) )),
                    (long) i, 5));
        }
    }
}
