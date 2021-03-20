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
        
delimiter $$
create procedure get_user_by_id(in in_user_id int)
begin
	select * from users
    where id = in_user_id;
end ; $$
delimiter ;

call get_user_by_id(4);

delimiter $$
create procedure insert_user(
	in in_user_name varchar(20),
    in in_user_email varchar(50),
    in in_user_country varchar(50)
)
begin
	insert into users (`name`, email,country)
    values (in_user_name, in_user_email, in_user_country);
end ; $$
delimiter ;

create table permission(

id int(11) primary key,

name varchar(50)

);

create table user_permision(

permision_id int(11) primary key,

user_id int(11)

);

insert into permission(id, name)
values (1,'add'),(2,'edit'),(3,'delete'),(4,'view');

delimiter $$
create procedure find_all_user()
begin
	select * from users;
end ; $$
delimiter ;

delimiter $$
create procedure update_user(in in_user_id int, in in_user_name varchar(50), in in_user_email varchar(50),in in_user_country varchar(50))
begin
	update users
    set `name` = in_user_name,
		email = in_user_email,
        country = in_user_country
    where id = in_user_id;
end ; $$
delimiter ;

delimiter $$
create procedure delete_user(in in_user_id int)
begin
	delete from users
    where id = in_user_id;
end ; $$
delimiter ;






