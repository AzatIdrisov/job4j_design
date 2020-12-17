create table car_body
(
    id   serial primary key,
    name varchar(200)
);
create table engine
(
    id   serial primary key,
    name varchar(200)
);
create table gearbox
(
    id   serial primary key,
    name varchar(200)
);

create table car
(
    id   serial primary key,
    name varchar(200),
    car_body_id int references car_body(id) NOT NULL,
    engine_id int references engine(id) NOT NULL,
    gearbox_id int references gearbox(id) NOT NULL
);

insert into car_body(name) values ('Кузов-1');
insert into car_body(name) values ('Кузов-2');
insert into car_body(name) values ('Кузов-3');
insert into engine(name) values ('Двигатель-1');
insert into engine(name) values ('Двигатель-2');
insert into engine(name) values ('Двигатель-3');
insert into engine(name) values ('Двигатель-4');
insert into engine(name) values ('Двигатель-5');
insert into gearbox(name) values ('Ручная коробка передач');
insert into gearbox(name) values ('Автоматическая коробка передач');
insert into gearbox(name) values ('Робот');
insert into gearbox(name) values ('Вариатор');

insert into car(name, car_body_id, engine_id, gearbox_id) values ('Ока' , 1, 1, 1);
insert into car(name, car_body_id, engine_id, gearbox_id) values ('Лада' , 2, 2, 1);
insert into car(name, car_body_id, engine_id, gearbox_id) values ('BMW' , 3, 3, 2);
insert into car(name, car_body_id, engine_id, gearbox_id) values ('Rav-4' , 2, 3, 4);
insert into car(name, car_body_id, engine_id, gearbox_id) values ('Solaris' , 1, 1, 4);

select c.name, cb.name, e.name, g.name
from car c
         left join car_body cb on cb.id = c.car_body_id
         left join engine e on e.id = c.engine_id
         left join gearbox g on g.id = c.gearbox_id;

--детали, которые не используются в машине, кузова, двигатели, коробки передач.
select * from engine e left join car c on e.id = c.engine_id where c.id is null;
select * from gearbox g left join car c on g.id = c.gearbox_id where c.id is null;
select * from car_body cb left join car c on cb.id = c.car_body_id where c.id is null;
