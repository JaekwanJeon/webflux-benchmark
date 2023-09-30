# webflux-benchmark

## 1. database
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/postgres
    username: postgres
    password: admin

### create
```
create table random_number
(
     r_number double precision,
     id serial not null<
     constraint random_number_pk
        primary key
);
```
### insert
```
insert into random_number(r_number)
    SELECT random() from generate_series(1, 5);
```

## 2. servers
springbootMvcJdbc : WebMVC + JDBC
springwebfluxjdbc : WebFlux + JDBC
springwebfluxr2dbc : WebFlux + R2DBC

## 3. API

### (1) webFlux webClient Test
http://localhost:8080/webflux/client

### (2) webMVC RestTemplate Test
http://localhost:8081/mvc/client

### (3) webFlux + R2DBC Test
http://localhost:8080/webflux

### (4) webMVC + JDBC Test
http://localhost:8081/mvc

(1), (2) 테스트를 위해서는 springwebfluxjdbc을 실행시켜야 함

## 4. 결과




