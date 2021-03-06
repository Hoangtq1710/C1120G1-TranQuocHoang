create database if not exists case_study_jsp;
use case_study_jsp;

/*-------------------------------------------------------------------------------------------------------------*/

create table position
(position_id int not null primary key auto_increment,
position_name varchar(45) not null
);

create table education_degree
(education_degree_id int not null primary key auto_increment,
education_degree_name varchar(45) not null
);

create table division
(division_id int not null primary key auto_increment,
division_name varchar(45) not null
);

create table customer_type
(customer_type_id int not null primary key auto_increment,
customer_type_name varchar(45) not null
);

create table rent_type
(rent_type_id int not null primary key auto_increment,
rent_type_name varchar(45) not null,
rent_type_cost double not null
);

create table service_type
(service_type_id int not null primary key auto_increment,
service_type_name varchar(45) not null
);

create table attach_service
(attach_service_id int not null primary key auto_increment,
attach_service_name varchar(45),
attach_service_cost double not null,
attach_service_unit varchar(45) not null,
attach_service_status varchar(45)
);

create table `user`
(username varchar(255) not null primary key,
password varchar(255)
);

create table `role`
(role_id int not null auto_increment primary key,
role_name varchar(255)
);

create table user_role
(role_id int,
username varchar(255),
primary key (role_id, username),
foreign key(role_id) references `role`(role_id) ON UPDATE CASCADE ON DELETE CASCADE,
foreign key(username) references `user`(username) ON UPDATE CASCADE ON DELETE CASCADE
);

/*-------------------------------------------------------------------------------------------------------------*/

create table employee
(employee_id int not null primary key auto_increment,
employee_name varchar(255) not null,
position_id int, foreign key(position_id) references `position`(position_id) ON UPDATE CASCADE ON DELETE CASCADE,
education_degree_id int, foreign key(education_degree_id) references education_degree(education_degree_id) ON UPDATE CASCADE ON DELETE CASCADE,
division_id int, foreign key(division_id) references division(division_id) ON UPDATE CASCADE ON DELETE CASCADE,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar(45) not null,
username varchar(255), foreign key(username) references `user`(username) ON UPDATE CASCADE ON DELETE CASCADE
);

create table customer
(customer_id varchar(45) not null primary key,
customer_type_id int, foreign key(customer_type_id) references customer_type(customer_type_id) ON UPDATE CASCADE ON DELETE CASCADE,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender bit(1) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45),
customer_email varchar(45),
customer_address varchar(45) not null
);

create table service
(service_id varchar(45) not null primary key,
service_name varchar(45) not null,
service_area int not null,
service_max_people int not null,
service_cost double not null,
rent_type_id int, foreign key(rent_type_id) references rent_type(rent_type_id) ON UPDATE CASCADE ON DELETE CASCADE,
service_type_id int, foreign key(service_type_id) references service_type(service_type_id) ON UPDATE CASCADE ON DELETE CASCADE,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int
);

create table contract
(contract_id int not null primary key auto_increment,
employee_id int, foreign key(employee_id) references employee(employee_id) ON UPDATE CASCADE ON DELETE CASCADE,
customer_id varchar(45), foreign key(customer_id) references customer(customer_id) ON UPDATE CASCADE ON DELETE CASCADE,
service_id varchar(45), foreign key(service_id) references service(service_id) ON UPDATE CASCADE ON DELETE CASCADE,
contract_start_date date not null,
contract_end_date date,
contract_deposit int,
contract_total_money int not null
);

create table contract_detail
(contract_detail_id int not null primary key auto_increment,
contract_id int, foreign key(contract_id) references contract(contract_id) ON UPDATE CASCADE ON DELETE CASCADE,
attach_service_id int, foreign key(attach_service_id) references attach_service(attach_service_id) ON UPDATE CASCADE ON DELETE CASCADE,
quantity int not null
);

/*-------------------------------------------------------------------------------------------------------------*/

insert into `position`(position_name)
	values ("Receptionist"),("Serve"),("Expert"),("Supervision"),("Manager"),("Director");

insert into education_degree(education_degree_name)
	values ("Intermediate"),("College"),("University"),("Postgraduate");

insert into division(division_name)
	values ("Sale–Marketing"),("Administration"),("Serve"),("Manager");

insert into customer_type(customer_type_name)
	values ("Diamond"),("Platinum"),("Gold"),("Silver"),("Member");

insert into service_type(service_type_name)
	values ("Villa"),("House"),("Room"), ("Attach Service");
    
insert into rent_type(rent_type_name,rent_type_cost)
	values ("Rent by Hour",50.0),("Rent by Day",500.0),("Rent by Month",7000.0),("Rent by Year",60000.0);

insert into attach_service(attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)
	values 	("Massage",20.0,"times","available"),
			("Karaoke",15.0,"hours","not available"),
			("Food",3.0,"plates","available"),
			("Water",1.0,"bottles","available"),
			("Car rental",10.0,"times","available");
insert into `role`(role_name)
	values	("admin"),("manager"),("director"),("employee");
    
insert into `user`(username, `password`)
	values	("hoang", "hoang"), ("thuan","thuan"), ("khoa","khoa"), ("quang","quang"), 
			("dong","dong"), ("vi","vi"),("sang","sang"),("phuc","phuc"),("long","long"), ("nghia","nghia");
    
insert into user_role(role_id,username)
	values	(1,"nghia"), (2,"phuc"), (3, "thuan"), (4, "khoa"), (4, "quang"), 
			(4, "dong"), (2, "vi"), (4,"sang"), (4, "long"),(1,"hoang");

/*-------------------------------------------------------------------------------------------------------------*/

insert into customer(customer_id,customer_type_id,customer_name,customer_gender,customer_birthday,customer_id_card,customer_phone,customer_email,customer_address)
	values 	("KH-0699",1,"Tran Quoc Hoang",1,'1995-10-17',"205784966","0915682721","hoang@gmail.com","Quang Nam"),
			("KH-0532",4,"Nguyen Hoang Bao Ngoc",1,'1997-12-05',"205999757536","(84)+917949397","ngoc@gmail.com","Quang Tri"),
			("KH-8704",5,"Hoang Le Quang",0,'1993-11-23',"205999942980","0902007075","quang@gmail.com","Hue"),
			("KH-0802",2,"Tran Hoang Sang",1,'1996-12-21',"205155491","(84)+914610130","sang@gmail.com","Vinh"),
			("KH-9696",2,"Nguyen Hoang Bao Ngoc",0,'1998-04-05',"205455263","0919262410","baongoc@gmail.com","Quang Tri"),
            ("KH-7556",3,"Ho Ngoc Dang Khoa",1,'1999-08-05',"205999332103","0902558286","khoa@gmail.com","Hue"),
            ("KH-6008",5,"Nguyen Ngoc Thuan",0,'1998-11-30',"205162301","(84)+908744685","thuan@gmail.com","Quang Tri"),
            ("KH-5599",1,"Nguyen Ngoc Dong",1,'1985-02-01',"205999286084","0909257543","dong@gmail.com","Da Nang"),
            ("KH-4521",1,"Nguyen Thi Tuong Vi",0,'1992-06-03',"205999369714","0917676972","vi.36@gmail.com","Da Nang"),
            ("KH-9088",4,"Ho Nhat Long",1,'1999-11-08',"205734522","0916009807","long@gmail.com","Hue"),
            ("KH-3726",2,"Nguyen Thi Thu Ha",0,'1993-10-24',"205066974","0909004921","ha@codegym.vn","Da Nang"),
            ("KH-2686",3,"Nguyen Van Phuc",1,'1991-08-07',"205999381448","(84)+902965588","phuc@gmail.com","Quang Nam"),
            ("KH-1241",2,"Nguyen Thanh Tung",1,'1988-02-08',"205317845","(84)+907843956","tung@gmail.com","Quang Nam"),
            ("KH-3004",3,"Le Van Quang",1,'1993-11-28',"205083310","0911823963","quang@gmail.com","Quang Nam");

insert into employee(employee_name,position_id,education_degree_id,division_id,employee_birthday,employee_id_card,
					 employee_salary,employee_phone,employee_email,employee_address,username)
	values 	("Nguyen Trong Thuan",6,4,4,'1997-07-09','207999845112',900.0,'0914112449',"thuan@gmail.com","Da Nang","thuan"),
			("Nguyen Van Khoa",2,1,2,'1999-12-19','205005430',500.0,'(84)+901112911',"khoa@gmail.com","Da Nang","khoa"),
			("Pham Le Quang",1,2,1,'1995-04-24','203999334007',550.0,'0917415940',"quang@gmail.com","Hue","quang"),
			('Nguyen Trung Dong',2,3,1,'1992-05-06','204111334',500.0,'(84)+914221144','dong@gmail.com',"Ha Tinh","dong"),
			("Nguyen Tuong Vi",5,2,4,'1993-09-20','207999494007',930.0,'(84)+912515940',"tuongvi@gmail.com","Da Nang","vi"),
			("Khuong An Sang",2,2,2,'1985-11-04','200314007',520.0,'0918115110',"sang@gmail.com","Quang Tri","sang"),
			("Giang Thi Phuc",4,3,4,'1998-02-25','203310147',700.0,'(84)+907411940',"phuc@gmail.com","Quang Nam","phuc"),
			("Nguyen Van Long",1,1,1,'2000-09-24','203114555',540.0,'(84)+914285363',"long@gmail.com","Hue","long"),
            ("Tran Ngoc Hoang",6,3,4,'1995-10-17','202457884',930.0,'0914552169',"hoang@gmail.com","Quang Nam","hoang"),
			("Cao Trung Nghia",3,4,2,'1994-01-27','201999112456',860.0,'0907402551',"nghia@gmail.com","Quang Ngai","nghia");
/*("Receptionist")-1,("Serve")-2,("Expert")-3,("Supervision")-4,("Manager")-5,("Director")-6*/

insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,
					standard_room,description_other_convenience,pool_area,number_of_floors)
	values 	("DV-6388","Villa-6388",50,500.0,10,2,1,
			"VIP","6388-description",45.0,6),
            ("DV-4581","House-4581",38,300.0,8,2,2,
            "Normal","none",0,7),
            ("DV-1478","Room-1478",26,100.0,7,3,3,
            "","",0,0),
            ("DV-9701","Villa-9701",65,550.0,15,3,1,
			"Bussiness","9701-description",55.0,9),
            ("DV-0207","House-0207",30,285.0,7,1,2,
            "VIP","none",0,5),
            ("DV-3417","Room-3417",25,125.0,11,4,3,
            "","",0,0)
            ;
insert into contract(employee_id,customer_id,service_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money)
	values 	(2,"KH-4521","DV-6388",'2020-12-01','2021-02-26',1000,2000),
			(5,"KH-6008","DV-1478",'2019-01-25','2019-03-22',500,1000),
			(4,"KH-9088","DV-9701",'2018-08-01','2018-12-20',750,1500),
			(6,"KH-1241","DV-3417",'2021-01-01','2021-03-11',1500,2500),
			(1,"KH-0802","DV-4581",'2020-09-07','2021-04-16',2000,5000),
			(7,"KH-3726","DV-0207",'2016-11-23','2017-02-19',400,1000),
			(8,"KH-5599","DV-9701",'2017-05-23','2017-06-26',600,1200),
			(6,"KH-9696","DV-1478",'2020-06-14','2020-09-02',700,1000),
			(9,"KH-2686","DV-6388",'2018-10-17','2018-10-22',350,1000)
            ;

insert into contract_detail(contract_id,attach_service_id,quantity) /*1-9*/ /*1-5*/
	values 	(2,4,1),(3,1,2),(1,2,1),(4,3,3),(6,5,2),(7,4,3),(8,1,2),
			(9,2,4),(1,3,2),(5,5,4),(4,4,5),(3,1,5),(2,2,1),(2,2,3),
            (3,1,2),(6,2,6),(8,2,4),(9,2,4),(4,2,4),(6,5,2),(7,1,4),
            (6,4,1),(3,4,4),(1,3,3);

/*-------------------------------------------------------------------------------------------------------------*/  
         
/*("Rent by Hour",50.0)		1,("Rent by Day",500.0)		2,("Rent by Month",7000.0)		3,("Rent by Year",60000.0)		4;*/
/*("Villa")		1,("House")		2,("Room")		3, ("Attach Service")		4*/

