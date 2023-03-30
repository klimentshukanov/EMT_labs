package com.example.emt_labs_201100.service;

import com.example.emt_labs_201100.model.Country;
import com.example.emt_labs_201100.model.dto.CountryDto;

import java.util.Optional;

public interface CountryService {

    Optional<Country> save(CountryDto countryDto);
    Optional<Country> findById(Long id);

}
