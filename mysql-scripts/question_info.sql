use questions;

create table question_info(
id int primary key auto_increment,
question_name varchar(2000),
option1 varchar(200),
option2 varchar(200),
option3 varchar(200),
option4 varchar(200),
correct_option varchar(200)
);

insert into question_info(question_name, option1, option2, option3, option4, correct_option) values
("How many letters are there in English alphabets?", "22", "23", "24", "26", "26"), 
("How many even numbers are there in the range 1 to 50 inclusive?", "25", "26", "27", "24", "25"), 
("How many odd numbers are there in the range 1 to 49 exclusive?", "22", "23", "24", "25", "23");


select * from question_info;


desc question_info;