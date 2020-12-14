select * from product where  type_id = (select id from type where name ='СЫР');
select * from product where  name like '%мороженное%';
select name from product where  expired_date between current_date and current_date + interval '1 month';
select * from product where price = (select max(price) from product);
select count(type_id) from product where type_id = 5;
select * from product where type_id in ( select id from type where name ='СЫР' or name ='МОЛОКО');
select type.name from type join product p on type.id = p.type_id group by type.name having count(p.type_id) < 10;
select prod.name, prod_type.name from product as prod left join type as prod_type on prod_type.id = prod.type_id;
