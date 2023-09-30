package com.example.springbootMvcJdbc.service;

import com.example.springbootMvcJdbc.entity.RNumber;
import com.example.springbootMvcJdbc.repository.NumberRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NumberService {

    NumberRepository numberRepository;

    public NumberService(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    public List<RNumber> getNumbers() {
        return numberRepository.findAll();
    }

    public Optional<RNumber> getNumber(Long id) {
        return numberRepository.findById(id);
    }
}
