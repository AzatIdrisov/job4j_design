insert into rules (rule_name) VALUES ('change state');

insert into rules (rule_name) VALUES ('change role');

insert into rules (rule_name) values ('add item');

insert into rules (rule_name) VALUES ('manage comments');

insert into roles (role_name, priority) values ('admin', 1);

insert into roles (role_name, priority) values ('user', 2);

insert into tracker_roles_rules ( role_id, rule_id) values (1, 1);

insert into tracker_roles_rules ( role_id, rule_id) values (1, 2);

insert into tracker_roles_rules ( role_id, rule_id) values (1, 3);

insert into tracker_roles_rules ( role_id, rule_id) values (1, 4);

insert into tracker_roles_rules ( role_id, rule_id) values (2, 3);

insert into category (category_name) values ('critical');

insert into category (category_name) values ('high');

insert into category (category_name) values ('low');

insert into state (state_name) values ('open');

insert into state (state_name) values ('on working');

insert into state (state_name) values ('pause');

insert into state (state_name) values ('closed');