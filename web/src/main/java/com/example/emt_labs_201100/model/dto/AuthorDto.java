package com.example.emt_labs_201100.model.dto;

import com.example.emt_labs_201100.model.Country;
import lombok.Data;

@Data
public class AuthorDto {


    private String name;
    private String surname;
    private Country country;

    public AuthorDto() {
    }

    public AuthorDto(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
