--liquibase formatted sql
--changeset <postgres>:<create-orders_services-table>

CREATE TABLE IF NOT EXISTS orders_services
(
    order_id   bigint not null CONSTRAINT orders_s_o_fk REFERENCES orders,
    service_id bigint not null CONSTRAINT services_uq UNIQUE
                               CONSTRAINT orders_s_s_fk REFERENCES services
);

--rollback DROP TABLE orders_services;
