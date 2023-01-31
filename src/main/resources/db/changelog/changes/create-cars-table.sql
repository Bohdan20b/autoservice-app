--liquibase formatted sql
--changeset <postgres>:<create-cars-table>

CREATE TABLE IF NOT EXISTS cars
(
    id       bigserial PRIMARY KEY,
    brand    varchar(255),
    model    varchar(255),
    series   varchar(255),
    year     integer not null,
    owner_id bigint CONSTRAINT cars_fk REFERENCES owners
);

--rollback DROP TABLE cars;
