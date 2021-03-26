create table rules
(
    id        serial primary key,
    rule_name varchar(2000)
);

create table roles
(
    id        serial primary key,
    role_name varchar(2000),
    priority  varchar(200)
);

create table tracker_roles_rules
(
    id      serial primary key,
    role_id int references roles (id),
    rule_id int references rules (id)
);

create table users
(
    id      serial primary key,
    name    varchar(2000),
    role_id int references roles (id)
);

create table category
(
    id            serial primary key,
    category_name varchar(2000)
);

create table state
(
    id         serial primary key,
    state_name varchar(2000)
);

create table item
(
    id          serial primary key,
    item_name   varchar(2000),
    user_id     int references users (id),
    category_id int references category (id),
    state_id    int references state (id)
);

create table comments
(
    id           serial primary key,
    comment_text text,
    item_id      int references item (id)
);

create table attachs
(
    id        serial primary key,
    file_name text,
    item_id   int references item (id)
);

create database products;

create table type
(
    id serial primary key ,
    name varchar(255)
);

create table product (
                         id serial primary key,
                         name varchar(255),
                         type_id int references type(id),
                         expired_date date,
                         price decimal
);

insert into type (name) values ('СЫР');
insert into type (name) values ('МОЛОКО');
insert into type (name) values ('ХЛЕБ');
insert into type (name) values ('МОРОЖЕННОЕ');
insert into type (name) values ('ШОКОЛАД');

insert into product(name, type_id, expired_date, price) values ('Пармезан', 1, date '2020-12-10', 250);
insert into product(name, type_id, expired_date, price) values ('Моцарелла', 1, date '2020-10-10', 100);
insert into product(name, type_id, expired_date, price) values ('СМАК', 3, date '2021-01-14', 30);
insert into product(name, type_id, expired_date, price) values ('мороженное Пломбир', 4, date '2021-06-25', 65);
insert into product(name, type_id, expired_date, price) values ('Аленка', 5, date '2021-02-10', 40);
insert into product(name, type_id, expired_date, price) values ('Аленка-2', 5, date '2020-12-15', 40);
insert into product(name, type_id, expired_date, price) values ('Аленка-3', 5, date '2020-12-15', 50);
insert into product(name, type_id, expired_date, price) values ('Аленка-4', 5, date '2020-12-15', 50);
insert into product(name, type_id, expired_date, price) values ('Аленка-5', 5, date '2020-11-10', 50);
insert into product(name, type_id, expired_date, price) values ('Аленка-6', 5, date '2021-12-10', 50);
insert into product(name, type_id, expired_date, price) values ('Аленка-7', 5, date '2021-12-10', 60);
insert into product(name, type_id, expired_date, price) values ('Аленка-8', 5, date '2021-12-10', 70);
insert into product(name, type_id, expired_date, price) values ('Аленка-9', 5, date '2021-12-10', 70);
insert into product(name, type_id, expired_date, price) values ('Аленка-10', 5, date '2021-12-10', 70);
insert into product(name, type_id, expired_date, price) values ('Аленка-11', 5, date '2021-12-10', 50);
insert into product(name, type_id, expired_date, price) values ('Аленка-12', 5, date '2021-12-10', 40);
insert into product(name, type_id, expired_date, price) values ('Домик в деревне 3,2%', 2, date '2021-12-17', 40);