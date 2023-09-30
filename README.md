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

## 4. 검증

### (1) webFlux webClient vs webMVC RestTemplate
1000명의 유저로 동시 10개씩 전송시
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/42873f26-232d-4e4b-9256-ad49081a8426)


#### RestTemplate 
Thread가 32개에서 223개로 상승하는 것을 확인할 수 있다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/c1ebcc1a-e263-481f-a400-f03f4ba99dac)
1개 처리 평균 607msec가 걸렸다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/cd45268d-809a-42c5-99fa-961978c267de)

#### webClient 
Thread가 16개에서 28개로 상승하는 것을 확인할 수 있다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/6a8e8c72-3e0c-48ac-a2cc-04f3f075a555)
1개 처리 평균 142msec가 걸렸다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/4596586c-f289-4efb-a9fd-bec395c84bef)

### (2) webFlux + R2DBC vs webMVC + JDBC

#### webMVC JDBC
Thread가 32개에서 322개로 상승하는 것을 확인할 수 있다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/42ffe455-cdc6-45a3-9842-d16c54ef005e)
1개 처리 평균 268msec가 걸렸다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/a0344ea8-afa5-4d61-add4-6463a9b85df4)

#### webFlux + R2DBC
Thread가 39개에서 52개로 상승하는 것을 확인할 수 있다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/b5de14b3-5f68-4d6f-a4fd-d5da8d1eb862)
1개 처리 평균 450msec가 걸렸다.
![image](https://github.com/JaekwanJeon/webflux-benchmark/assets/3446997/b03f7787-48a5-4394-bf0e-45165e6fcacb)

## 5. 결론

### (1) webFlux webClient vs webMVC RestTemplate 결과
예상대로 WebClient가 적은 수의 쓰레드로 높은 성능을 보였다.
염두에 둘 점은 WebMVC가 233개의 쓰레드 풀이 줄어들기 전에 실행하면 WebClient와 비교해서 거의 비슷하거나
오히려 높은 성능을 보이기도 했다.

### (2) webFlux + R2DBC vs webMVC + JDBC
webFlux + R2DBC에서 의외의 결과가 나왔다.
event loop 사이즈나 R2DBC Thread pool로 튜닝이 가능하다고 해서 조정해 보았으나 좋은 결과를 확인하지 못했다.
레퍼런스도 부족하고 경험도 부족해서 R2DBC를 실무에 도입하기는 조금 시기상조로 판단된다.
