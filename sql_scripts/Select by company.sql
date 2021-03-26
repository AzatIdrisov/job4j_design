insert into company (id, name) values (1, 'Company1');
insert into company (id, name) values (2, 'Company2');
insert into company (id, name) values (3, 'Company3');
insert into company (id, name) values (4, 'Company4');
insert into company (id, name) values (5, 'Company5');


insert into person (id, name, company_id) values (1, 'Azat', 1);
insert into person (id, name, company_id) values (2, 'Ivan', 1);
insert into person (id, name, company_id) values (3, 'Petr', 1);
insert into person (id, name, company_id) values (4, 'Alex', 1);
insert into person (id, name, company_id) values (5, 'Misha', 2);
insert into person (id, name, company_id) values (6, 'Maria', 2);
insert into person (id, name, company_id) values (7, 'Kate', 3);
insert into person (id, name, company_id) values (8, 'Ann', 4);
insert into person (id, name, company_id) values (9, 'Maxim', 5);
insert into person (id, name, company_id) values (10, 'Sergey', 5);

select p.name, c.name from person p left join company c on p.company_id = c.id where p.company_id != 5;

select company.name, count from company,
(SELECT company_id, COUNT(company_id) as count FROM person
GROUP BY company_id
ORDER BY count desc
LIMIT 1) as max_company
where company.id = max_company.company_id;