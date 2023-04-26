package com.example.emt_labs_201100.service.impl;


import com.example.emt_labs_201100.model.Country;
import com.example.emt_labs_201100.model.dto.CountryDto;
import com.example.emt_labs_201100.repository.CountryRepository;
import com.example.emt_labs_201100.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        Country country=new Country(countryDto.getName(), countryDto.getContinent());
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }
}
