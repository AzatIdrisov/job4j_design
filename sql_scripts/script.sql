create table meetings(
    id serial primary key ,
    name text
);

create table users (
    id serial primary key ,
    name text
);

create table usersOnMeetings (
	user_id int references users(id),
	meeting_id int references meetings(id),
	status text
);

insert into meetings (name) values ('meeting-1');
insert into meetings (name) values ('meeting-2');
insert into meetings (name) values ('meeting-3');
insert into meetings (name) values ('meeting-4');
insert into meetings (name) values ('meeting-5');

insert into users (name) values ('User-1');
insert into users (name) values ('User-2');
insert into users (name) values ('User-3');
insert into users (name) values ('User-4');
insert into users (name) values ('User-5');

insert into usersOnMeetings (user_id, meeting_id, status) values (1,1, 'Confirmed');
insert into usersOnMeetings (user_id, meeting_id, status) values (2,1, 'Confirmed');
insert into usersOnMeetings (user_id, meeting_id, status) values (3,1, 'Rejected');
insert into usersOnMeetings (user_id, meeting_id, status) values (1,2, 'Confirmed');
insert into usersOnMeetings (user_id, meeting_id, status) values (2,2, 'Confirmed');
insert into usersOnMeetings (user_id, meeting_id, status) values (1,3, 'Rejected');

SELECT name, count FROM meetings inner join
(SELECT meeting_id, COUNT(case status when 'Confirmed' then 1 else null end) as count FROM usersOnMeetings
GROUP BY meeting_id) as confirmed
on meetings.id = meeting_id

SELECT * FROM meetings left join usersOnMeetings on meetings.id = meeting_id where  meeting_id is null

