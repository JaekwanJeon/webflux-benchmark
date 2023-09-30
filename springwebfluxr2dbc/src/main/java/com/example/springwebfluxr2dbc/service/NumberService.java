package com.example.springwebfluxr2dbc.service;

import com.example.springwebfluxr2dbc.entity.RNumber;
import com.example.springwebfluxr2dbc.repository.NumberRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class NumberService {

    NumberRepository numberRepository;

    public NumberService(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    public Flux<RNumber> getNumbers() {

//        return Flux.defer(()-> Flux.from(numberRepository.findAll()
//                .subscribeOn(Schedulers.boundedElastic())));
        return numberRepository.findAll();
    }

    public Mono<RNumber> getNumber(Long id) {
        return numberRepository.findById(id);
//        return Mono.defer(()-> Mono.from(numberRepository.findById(id)
//                .subscribeOn(Schedulers.boundedElastic())));
    }
}
