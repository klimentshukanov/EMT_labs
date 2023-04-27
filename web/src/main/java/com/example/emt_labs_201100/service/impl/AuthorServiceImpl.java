package com.example.emt_labs_201100.service.impl;

import com.example.emt_labs_201100.model.Author;
import com.example.emt_labs_201100.model.dto.AuthorDto;
import com.example.emt_labs_201100.repository.AuthorRepository;
import com.example.emt_labs_201100.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Author author=new Author(authorDto.getName(), authorDto.getSurname(), authorDto.getCountry());
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }
}
