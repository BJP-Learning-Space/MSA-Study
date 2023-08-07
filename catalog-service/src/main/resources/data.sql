DROP TABLE IF EXISTS catalog;
CREATE TABLE catalog
(
    id           bigserial   NOT NULL,
    product_id   varchar(20) NOT NULL,
    product_name varchar(50) NOT NULL,
    stock        int         NOT NULL,
    unit_price   int         NOT NULL,
    created_at   timestamp   NOT NULL,
    PRIMARY KEY (id)
);

insert into catalog (product_id, product_name, stock, unit_price, created_at)
values ('CATALOG-001', 'Berlin', 100, 1500, now());
insert into catalog (product_id, product_name, stock, unit_price, created_at)
values ('CATALOG-002', 'London', 30, 2000, now());
insert into catalog (product_id, product_name, stock, unit_price, created_at)
values ('CATALOG-003', 'Paris', 160, 2500, now());
