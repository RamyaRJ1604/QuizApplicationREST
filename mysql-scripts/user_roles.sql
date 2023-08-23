drop table if exists user_roles;

create table user_roles(
user_id int primary key auto_increment,
user_name varchar(45),
user_password varchar(45),
enabled tinyint(1),
user_role varchar(45)
);

insert into user_roles(user_name, user_password, enabled, user_role) values 
("ramya", "{noop}test123", 1, "ROLE_ADMIN"),
("robert", "{noop}test123", 1, "ROLE_TEACHER"),
("pepper", "{noop}test123", 1, "ROLE_TEACHER"),
("peter", "{noop}test123", 1, "ROLE_STUDENT"),
("bruce", "{noop}test123", 1, "ROLE_STUDENT");

select * from user_roles;
-- delete from user_roles where user_id=6;