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