package com.example.springbootMvcJdbc.controller;

import com.example.springbootMvcJdbc.entity.RNumber;
import com.example.springbootMvcJdbc.service.NumberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/mvc")
public class DemoController {
    private final NumberService numberService;
    private final RestTemplate restTemplate;

    public DemoController(NumberService numberService, RestTemplate restTemplate) {
        this.numberService = numberService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "")
    public List<RNumber> getNumbers() {
        return numberService.getNumbers();
    }

    @GetMapping("/{id}")
    public Optional<RNumber> getNumbers(@PathVariable("id") Long id) {
        return numberService.getNumber(id);
    }

    @GetMapping("/clientall")
    public List<RNumber> getClientAll() {
        return restTemplate.getForObject("http://localhost:8082/webfluxjdbc", List.class);
    }

    @GetMapping("/client")
    public RNumber getClient() {
        return restTemplate.getForObject("http://localhost:8082/webfluxjdbc/1", RNumber.class);
    }

}