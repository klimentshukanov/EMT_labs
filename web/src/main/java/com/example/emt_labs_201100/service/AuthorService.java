package com.example.emt_labs_201100.service;

import com.example.emt_labs_201100.model.Author;
import com.example.emt_labs_201100.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> save(AuthorDto authorDto);
    Optional<Author> findById(Long id);
    List<Author> listAll();

}
