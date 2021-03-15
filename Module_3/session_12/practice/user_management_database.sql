create database session_12_practice_user_management;
use session_12_practice_user_management;

create table users(
id int not null auto_increment primary key,
`name` nvarchar(255) not null,
email nvarchar(255) not null,
country nvarchar(255) not null
);

insert into users(`name`, email, country)
values 	("Hoang", "hoang@gmail.com", "VietNam"),
		("Ngoc", "ngoc@gmail.com", "Korea"),
		("Thuan", "thuan@gmail.com", "Japan"),
		("Dong", "dong@gmail.com", "Japan"),
		("Vi", "vi@gmail.com", "VietNam"),
		("Khoa", "khoa@gmail.com", "Thailand"),
		("Long", "long@gmail.com", "Laos"),
		("Quang", "quang@gmail.com", "USA");