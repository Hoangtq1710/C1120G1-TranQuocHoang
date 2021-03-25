create database thi_module_3;
create table payment(
payment_id int primary key auto_increment not null,
payment_name varchar(255) not null
);

create table room(
id int auto_increment primary key not null,
customer_name varchar(255) not null,
phone varchar(50) not null,
rent_day date not null,
room_description varchar(200),
payment_id int, foreign key (payment_id) references payment(payment_id) on update cascade on delete cascade
);

insert into payment(payment_name)
 values("theo thang"), ("theo quy"), ("theo nam");
 
 insert into room(customer_name,phone,rent_day,room_description,payment_id)
 values ("Nguyen Van Hoang", "0912497745",'2020-06-06',"none",1),
		 ("Tran Van Tien", "0912222555",'2020-07-06',"none",2),
		 ("Pham Van Manh", "0906244555",'2020-08-06',"none",1),
		 ("Ly Thi Quynh", "0912443475",'2020-10-06',"none",3),
		 ("Nguyen Van Cong", "0912449675",'2021-01-08',"none",2);
         
