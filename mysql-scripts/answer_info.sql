drop table if exists answer_info;

create table answer_info(
answer_id int primary key auto_increment,
answer_data varchar(45)
);

insert into answer_info(answer_data) values
("26"),
("25"), 
("23");


select * from answer_info;

desc answer_info;