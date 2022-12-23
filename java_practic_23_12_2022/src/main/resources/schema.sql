DROP TABLE IF EXISTS product;
CREATE TABLE product
(
    id varchar(36) not null primary key,
    name varchar(255) not null,
    price float,
    old_price float,
    is_new boolean,
    is_hot boolean,
    picture varchar(255) not null,
    description text
);