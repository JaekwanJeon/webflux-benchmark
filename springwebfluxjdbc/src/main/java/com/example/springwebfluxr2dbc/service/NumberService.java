package com.example.springwebfluxr2dbc.service;

import com.example.springwebfluxr2dbc.entity.RNumber;
import com.example.springwebfluxr2dbc.repository.NumberRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

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
