insert into category (id, name) values ('4f773be3-b70a-43c2-8f3a-96856623e229', 'NEW PRODUCTS');
insert into category (id, name) values ('7289637b-d7ee-4a14-9d0c-f919001dc427', 'TOP PRODUCTS');
insert into category (id, name) values ('9ab3715a-243e-47b2-aa4b-d5dbf038e2e9', 'SALE PRODUCTS');

insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e44b', 'product1', 123.1, 456.7, true, false, 's1.jpg', 'description1', '4f773be3-b70a-43c2-8f3a-96856623e229');
insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e441', 'product2', 123.1, 456.7, true, true, 's2.jpg', 'description2', '4f773be3-b70a-43c2-8f3a-96856623e229');
insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e442', 'product3', 123.1, 456.7, false, false, 's3.jpg', 'description3', '4f773be3-b70a-43c2-8f3a-96856623e229');
insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e443', 'product4', 123.1, 456.7, false, false, 's4.jpg', 'description4', '4f773be3-b70a-43c2-8f3a-96856623e229');

insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e444', 'product5', 123.1, 456.7, true, false, 's5.jpg', 'description5', '7289637b-d7ee-4a14-9d0c-f919001dc427');
insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e445', 'product6', 123.1, 456.7, true, false, 's6.jpg', 'description6', '7289637b-d7ee-4a14-9d0c-f919001dc427');
insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e446', 'product7', 123.1, 456.7, false, false, 's7.jpg', 'description7', '7289637b-d7ee-4a14-9d0c-f919001dc427');
insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e447', 'product8', 123.1, 456.7, false, false, 's8.jpg', 'description8', '7289637b-d7ee-4a14-9d0c-f919001dc427');

insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e448', 'product9', 123.1, 456.7, true, false, 's9.jpg', 'description9', '9ab3715a-243e-47b2-aa4b-d5dbf038e2e9');
insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e449', 'product10', 123.1, 456.7, true, false, 's10.jpg', 'description10', '9ab3715a-243e-47b2-aa4b-d5dbf038e2e9');
insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e440', 'product11', 123.1, 456.7, false, false, 's11.jpg', 'description11', '9ab3715a-243e-47b2-aa4b-d5dbf038e2e9');
insert into product (id, name, price, old_price, is_new, is_hot, picture, description, category_id) values ('bea94a4b-0d87-4ffc-b8c7-1e14ae14e44c', 'product12', 123.1, 456.7, false, false, 's12.jpg', 'description12', '9ab3715a-243e-47b2-aa4b-d5dbf038e2e9');

insert into booking (id, order_date) values ('13dac2b8-6880-4c6e-8bea-1b1c10968ef6', '2023-02-06 19:32:30');
insert into booking (id, order_date) values ('13dac2b8-6880-4c6e-8bea-1b1c10968ef7', '2023-02-06 18:42:30');

insert into booking_products (orders_id, products_id) values ('13dac2b8-6880-4c6e-8bea-1b1c10968ef6', 'bea94a4b-0d87-4ffc-b8c7-1e14ae14e44b');
insert into booking_products (orders_id, products_id) values ('13dac2b8-6880-4c6e-8bea-1b1c10968ef6', 'bea94a4b-0d87-4ffc-b8c7-1e14ae14e444');

insert into booking_products (orders_id, products_id) values ('13dac2b8-6880-4c6e-8bea-1b1c10968ef7', 'bea94a4b-0d87-4ffc-b8c7-1e14ae14e444');
insert into booking_products (orders_id, products_id) values ('13dac2b8-6880-4c6e-8bea-1b1c10968ef7', 'bea94a4b-0d87-4ffc-b8c7-1e14ae14e44c');
insert into booking_products (orders_id, products_id) values ('13dac2b8-6880-4c6e-8bea-1b1c10968ef7', 'bea94a4b-0d87-4ffc-b8c7-1e14ae14e447');

insert into roles (id, name) values ('eb8f4b2c-df05-4f05-857d-46f4ff75eb62','ROLE_ADMIN');
insert into roles (id, name) values ('ff87dbfd-9f0e-48f6-9001-9e5091dc9a9b','ROLE_USER');

insert into users (id, login, name, password) values ('fab092ee-9b1a-4913-9de8-d7beb9fb864b', 'admin', 'John', '$2a$10$9zELWTjgWlR4mvCL0M10.eVSXulcwtQ3kfQ/7Rrfh7KnRAyYx/iES');
insert into users (id, login, name, password) values ('c15edd0e-0eb7-4982-ad4b-f05ea0ef98cd', 'user', 'Ann', '$2a$10$X/p2DcfMjwiXE/Ae64cuheVyrZUJg3Yekvb5kBH1PQxYlkSvvRMH.');

insert into users_roles (user_id, role_id) values ('fab092ee-9b1a-4913-9de8-d7beb9fb864b', 'eb8f4b2c-df05-4f05-857d-46f4ff75eb62');
insert into users_roles (user_id, role_id) values ('c15edd0e-0eb7-4982-ad4b-f05ea0ef98cd', 'ff87dbfd-9f0e-48f6-9001-9e5091dc9a9b');