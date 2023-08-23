create table roles(
user_name varchar(100),
user_type varchar(100),
foreign key (user_name) references users(user_name)
);

insert into roles(user_name, user_type) values
("ramya", "ROLE_ADMIN"),
("robert", "ROLE_TEACHER"),
("pepper", "ROLE_TEACHER"),
("peter", "ROLE_STUDENT"),
("bruce", "ROLE_STUDENT");

select * from roles;

desc roles;