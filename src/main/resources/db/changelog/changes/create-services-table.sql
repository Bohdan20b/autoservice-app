--liquibase formatted sql
--changeset <postgres>:<create-services-table>

CREATE TABLE IF NOT EXISTS services
(
    id        bigserial PRIMARY KEY,
    price     numeric(19, 2),
    status    varchar(255),
    master_id bigint CONSTRAINT services_m_fk REFERENCES masters,
    order_id  bigint CONSTRAINT services_o_fk REFERENCES orders
);

--rollback DROP TABLE services;
