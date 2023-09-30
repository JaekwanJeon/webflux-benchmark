package com.example.springwebfluxr2dbc.controller;

import com.example.springwebfluxr2dbc.entity.RNumber;
import com.example.springwebfluxr2dbc.service.NumberService;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
@RequestMapping(value = "/webflux")
public class DemoController {
    private final NumberService numberService;
    private final R2dbcEntityTemplate template;
    private final WebClient webClient;

    public DemoController(R2dbcEntityTemplate template, NumberService numberService, WebClient webClient) {
        this.template = template;
        this.numberService = numberService;
        this.webClient = webClient;
    }

//    @GetMapping(value = "", produces = TEXT_EVENT_STREAM_VALUE)
    @GetMapping(value = "")
    public Flux<RNumber> getNumbers() {
        return numberService.getNumbers();
    }

    @GetMapping("/{id}")
    public Mono<RNumber> getNumbers(@PathVariable("id") Long id) {

        return numberService.getNumber(id);
//        return template.selectOne(query(where("id").is(id)),
//                RNumber.class);
    }

    @GetMapping("/client")
    public Mono<RNumber> getClient() {
        return webClient.get().uri("http://localhost:8082/webfluxjdbc/1")
                .retrieve().bodyToMono(RNumber.class);
    }

    @GetMapping("/clientall")
    public Flux<RNumber> getClientAll() {
        return webClient.get().uri("http://localhost:8082/webfluxjdbc")
                .retrieve().bodyToFlux(RNumber.class);
    }
}