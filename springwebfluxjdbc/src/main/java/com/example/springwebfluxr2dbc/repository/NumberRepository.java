package com.example.springwebfluxr2dbc.repository;

import com.example.springwebfluxr2dbc.entity.RNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends JpaRepository<RNumber, Long> {

}