package com.example.emt_labs_201100.service.impl;


import com.example.emt_labs_201100.repository.CountryRepository;
import com.example.emt_labs_201100.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
}
