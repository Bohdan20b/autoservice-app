--liquibase formatted sql
--changeset <postgres>:<create-owners_cars-table>

CREATE TABLE IF NOT EXISTS owners_cars
(
    owner_id bigint not null CONSTRAINT owners_cars_o_fk REFERENCES owners,
    car_id   bigint not null CONSTRAINT car_uq UNIQUE
                             CONSTRAINT owners_cars_c_fk REFERENCES cars
);

--rollback DROP TABLE owners_cars;
