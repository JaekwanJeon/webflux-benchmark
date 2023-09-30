package com.example.springwebfluxr2dbc.repository;

import com.example.springwebfluxr2dbc.entity.RNumber;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface NumberRepository extends ReactiveCrudRepository<RNumber, Long> {

    @Query("select * from random_number")
    Flux<RNumber> getNumbers();

}
