# webflux-benchmark

## 1. database
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/postgres
    username: postgres
    password: admin

### create
create table random_number
(
    r_number double precision,
    id serial not null
        constraint random_number_pk
            primary key
);

### insert
insert into random_number(r_number)
SELECT random() from generate_series(1, 5);
