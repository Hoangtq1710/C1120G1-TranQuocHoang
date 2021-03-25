create database last_chance;
use last_chance;

create table product(
product_id int primary key not null auto_increment,
product_name varchar(255) not null,
price int not null,
percent int not null,
stock int not null);

create table employee(
employee_id int auto_increment primary key not null,
employee_name varchar(255) not null,
employee_address varchar(255) not null
);

create table customer(
customer_id int primary key auto_increment not null,
customer_name varchar(255) not null,
phone varchar(255) not null,
email varchar(255) not null
);

create table contract(
contract_id int auto_increment primary key not null,
payment varchar(255) not null,
start_date date not null,
end_date date not null,
address varchar(255) not null,
product_id int, foreign key (product_id) references product(product_id) on update cascade on delete cascade,
employee_id int, foreign key(employee_id)  references employee(employee_id) on update cascade on delete cascade,
customer_id int, foreign key (customer_id) references customer(customer_id) on update cascade on delete cascade
);

insert into product(product_name, price, percent, stock)
values("A", 10,10,5),("B", 20,8,5),("C", 30,9,5),("D", 15,11,5),("E", 18,12,5),("F", 22,17,5),
("G", 30,20,5),("K", 26,4,5),("H", 21,6,5),("I", 18,9,5),("M", 17,10,5);

insert into employee(employee_name, employee_address)
values("Nguyen Van A", "DN"), ("Nguyen Van B", "hue"),("Nguyen Van C", "DN"),("Nguyen Van D", "QN"),("Nguyen Van E", "DN"),
("Nguyen Van F", "DN"),("Nguyen Van G", "HN"),("Nguyen Van K", "DN"),("Nguyen Van H", "HN"),("Nguyen Van I", "DN");

insert into customer(customer_name,phone,email)
values("Tran Van Q", "0915222555","q@gamil.com"),("Tran Van J", "0915222555","j@gamil.com"),("Tran Van R", "0915222555","r@gamil.com"),("Tran Van X", "0915222555","x@gamil.com")
,("Tran Van Y", "0915222555","y@gamil.com"),("Tran Van U", "0915222555","u@gamil.com"),("Tran Van Z", "0915222555","z@gamil.com"),("Tran Van W", "0915222555","w@gamil.com")
,("Tran Van B", "0915222555","b@gamil.com"),("Tran Van T", "0915222555","t@gamil.com");

insert into contract(payment,start_date,end_date,address,product_id,employee_id,customer_id)
values	("COD",'2020-05-04','2020-05-09',"DN",1,10,2),
		("COD",'2020-06-08','2020-06-09',"QN",2,9,4),
		("COD",'2020-07-04','2020-07-09',"HN",3,8,6),
		("COD",'2020-08-04','2020-08-09',"QB",4,7,8),
		("COD",'2020-09-04','2020-09-09',"DN",5,6,10),
		("COD",'2020-10-04','2020-10-09',"H",6,5,1),
		("COD",'2020-11-04','2020-11-09',"DN",7,4,3),
		("COD",'2020-12-04','2020-12-09',"QN",8,3,5),
		("COD",'2021-02-04','2020-02-09',"DN",9,2,7),
		("COD",'2021-03-04','2020-03-09',"HN",10,1,9);







