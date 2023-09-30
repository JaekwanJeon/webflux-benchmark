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

### (1) webFlux webClient vs webMVC RestTemplate
1000명의 유저로 동시 10개씩 전송시
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/42873f26-232d-4e4b-9256-ad49081a8426)


#### RestTemplate 
Thread가 32개에서 322개로 상승하는 것을 확인할 수 있다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/c1ebcc1a-e263-481f-a400-f03f4ba99dac)
1개 처리 평균 607msec가 걸렸다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/cd45268d-809a-42c5-99fa-961978c267de)

#### webClient 
Thread가 16개에서 28개로 상승하는 것을 확인할 수 있다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/6a8e8c72-3e0c-48ac-a2cc-04f3f075a555)
1개 처리 평균 142msec가 걸렸다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/4596586c-f289-4efb-a9fd-bec395c84bef)

