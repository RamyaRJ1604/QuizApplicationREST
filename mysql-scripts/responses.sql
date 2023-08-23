drop table if exists responses;

create table responses(
student_id int,
response_id int primary key auto_increment,
selected_option varchar(200),
question_id int,
foreign key(question_id) references question_info(id)
);

insert into responses(student_id, selected_option, question_id) values 
(4, "24", 1),
(4, "25", 2),
(4, "23", 3);

select * from responses;

