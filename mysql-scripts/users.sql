use questions;

drop table if exists users;

create table users(
user_name varchar(100) primary key,
user_password varchar(100),
enabled tinyint(1)
);


insert into users (user_name, user_password, enabled) values 
("ramya", "{noop}test123", 1),
("robert", "{noop}test123", 1),
("pepper", "{noop}test123", 1),
("peter", "{noop}test123", 1),
("bruce", "{noop}test123", 1);

select * from users;

desc users;