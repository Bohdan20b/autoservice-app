--liquibase formatted sql
--changeset <postgres>:<create-owners_orders-table>

CREATE TABLE IF NOT EXISTS owners_orders
(
    owner_id bigint not null CONSTRAINT owners_orders_ow_fk
                             REFERENCES owners,
    order_id bigint not null CONSTRAINT order_uq UNIQUE
                             CONSTRAINT owners_orders_or_fk
                             REFERENCES orders
);
--rollback DROP TABLE owners_orders;
