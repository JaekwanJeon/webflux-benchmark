package com.example.springbootMvcJdbc.repository;

import com.example.springbootMvcJdbc.entity.RNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends JpaRepository<RNumber, Long> {

}
