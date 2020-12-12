select * from product where  type_id = (select id from type where name ='СЫР');
select * from product where  name like '%мороженное%';
select * from product where extract(month from expired_date) = extract(month from current_date)+1;
select * from product where price = (select max(price) from product);
select count(type_id) from product where type_id = 5;
select * from product where type_id in ( (select id from type where name ='СЫР'), (select id from type where name ='МОЛОКО'));
select name from type where (select count(a.id) from product as a where a.type_id = type.id) < 10;
select prod.name, prod_type.name from product as prod left join type as prod_type on prod_type.id = prod.type_id;