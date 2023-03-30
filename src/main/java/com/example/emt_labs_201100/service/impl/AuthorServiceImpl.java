package com.example.emt_labs_201100.service.impl;

import com.example.emt_labs_201100.repository.AuthorRepository;
import com.example.emt_labs_201100.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
