create table departments
(
    id   serial primary key,
    name varchar(200)
);

create table emploees
(
    id   serial primary key,
    name varchar(200),
    department_id int references departments(id)
);

insert into departments(name) values ('Первый');
insert into departments(name) values ('Второй');
insert into departments(name) values ('Третий');
insert into departments (name) values ('Четвертый');

insert into emploees(name, department_id) values ('Азат',1);
insert into emploees(name, department_id) values ('Петр',1);
insert into emploees(name, department_id) values ('Алексей',2);
insert into emploees(name, department_id) values ('Сергей',2;
insert into emploees(name, department_id) values ('Павел',2);
insert into emploees(name, department_id) values ('Барсик',3);
insert into emploees(name) values ('Мария');
insert into emploees(name) values ('Оля');

--выполнить запросы с left, right, full, cross соединениями
select * from departments d left join emploees e on d.id = e.department_id;
select * from departments d right join emploees e on d.id = e.department_id;
select * from emploees full join departments d on d.id = emploees.department_id
select * from emploees cross join departments
--используя left join найти работников, которые не относятся ни к одну из департаментов.
select * from emploees e left join departments d on d.id = e.department_id where department_id is null;

--запросы с одинаковым результатом
select * from departments d right join emploees e on d.id = e.department_id;
select * from emploees e left join departments d on d.id = e.department_id;

create table teens
(
    id serial primary key,
    name varchar(200),
    gender varchar(200)
);

insert into teens (name, gender) values ('Mike', 'Male');
insert into teens (name, gender) values ('Nick', 'Male');
insert into teens (name, gender) values ('Emily', 'Female');
insert into teens (name, gender) values ('Elena', 'Female');
insert into teens (name, gender) values ('Barsik', 'Cat');

select  a.name, a.gender, b.name, b.gender from  teens a cross join teens b where a.id != b.id;
