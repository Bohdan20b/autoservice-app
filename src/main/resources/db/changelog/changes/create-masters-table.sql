--liquibase formatted sql
--changeset <postgres>:<create-masters-table>

CREATE TABLE IF NOT EXISTS masters
(
    id   BIGSERIAL PRIMARY KEY,
    name varchar(255)
);

--rollback DROP TABLE masters;
