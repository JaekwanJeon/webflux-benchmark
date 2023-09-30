package com.example.springwebfluxr2dbc.controller;

import com.example.springwebfluxr2dbc.entity.RNumber;
import com.example.springwebfluxr2dbc.service.NumberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
@RequestMapping(value = "/webfluxjdbc")
public class DemoController {
    private final NumberService numberService;

    public DemoController(NumberService numberService) {
        this.numberService = numberService;
    }

//    @GetMapping(value = "", produces = TEXT_EVENT_STREAM_VALUE)
    @GetMapping(value = "")
    public List<RNumber> getNumbers() {
        return numberService.getNumbers();
    }

    @GetMapping("/{id}")
    public Mono<RNumber> getNumbers(@PathVariable("id") Long id) {
        return Mono.justOrEmpty(numberService.getNumber(id));
    }
}