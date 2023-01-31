--liquibase formatted sql
--changeset <postgres>:<insert-default-service-price.sql>

insert into services (price) values (500);

--rollback DELETE FROM services WHERE id = 1;
