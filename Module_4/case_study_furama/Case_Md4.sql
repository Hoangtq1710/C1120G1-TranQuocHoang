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
	values	("ROLE_ADMIN"),("ROLE_MANAGER"),("ROLE_DIRECTOR"),("ROLE_EMPLOYEE"),("ROLE_GUEST");
    
insert into `user`(User_Name, `Password`,enabled)
values 	("hoang","hoang",1),
		("vi","vi",1),
		("thuan","thuan",1),
		("ngoc","ngoc",1),
		("quang","quang",1),
		("sang","sang",1),
		("long","long",1),
		("khoa","khoa",1),
        ("dong","dong",1),
        ("phuc","phuc",1);
        
insert into user_role(User_Id, Role_Id)
values 	(1, 1),
		(2, 2),
		(3, 2),
		(4, 3),
		(5, 3),
		(6, 4),
		(7, 4),
		(8, 5),
		(9, 5),
		(10, 5);
        
insert into customer(customer_id,customer_type_id,customer_name,customer_gender,customer_birthday,customer_id_card,customer_phone,customer_email,customer_address)
	values 	("KH-0699",1,"Tran Quoc Hoang",1,'1995-10-17',"205784966","0915682721","hoang@gmail.com","Quang Nam"),
			("KH-0532",4,"Nguyen Hoang Bao Ngoc",1,'1997-12-05',"205999757536","(84)+917949397","ngoc@gmail.com","Quang Tri"),
			("KH-8704",5,"Hoang Le Quang",0,'1993-11-23',"205999942980","0902007075","quang@gmail.com","Hue"),
			("KH-0802",2,"Tran Hoang Sang",1,'1996-12-21',"205155491","(84)+914610130","sang@gmail.com","Vinh"),
			("KH-9696",2,"Le Dinh Thinh",0,'1998-04-05',"205455263","0919262410","baongoc@gmail.com","Quang Tri"),
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
					 employee_salary,employee_phone,employee_email,employee_address,User_Name)
	values 	("Nguyen Trong Thuan",6,4,4,'1997-07-09','207999845112',900.0,'0914112449',"thuan@gmail.com","Da Nang",3),
			("Nguyen Van Khoa",2,1,2,'1999-12-19','205005430',500.0,'(84)+901112911',"khoa@gmail.com","Da Nang",8),
			("Pham Le Quang",1,2,1,'1995-04-24','203999334007',550.0,'0917415940',"quang@gmail.com","Hue",5),
			('Nguyen Trung Dong',2,3,1,'1992-05-06','204111334',500.0,'(84)+914221144','dong@gmail.com',"Ha Tinh",9),
			("Nguyen Tuong Vi",5,2,4,'1993-09-20','207999494007',930.0,'(84)+912515940',"tuongvi@gmail.com","Da Nang",2),
			("Khuong An Sang",2,2,2,'1985-11-04','200314007',520.0,'0918115110',"sang@gmail.com","Quang Tri",6),
			("Giang Thi Phuc",4,3,4,'1998-02-25','203310147',700.0,'(84)+907411940',"phuc@gmail.com","Quang Nam",10),
			("Nguyen Van Long",1,1,1,'2000-09-24','203114555',540.0,'(84)+914285363',"long@gmail.com","Hue",7),
            ("Tran Ngoc Hoang",6,3,4,'1995-10-17','202457884',930.0,'0914552169',"hoang@gmail.com","Quang Nam",1),
			("Cao Trung Nghia",3,4,2,'1994-01-27','201999112456',860.0,'0907402551',"nghia@gmail.com","Quang Ngai",4);
/*("Receptionist")-1,("Serve")-2,("Expert")-3,("Supervision")-4,("Manager")-5,("Director")-6*/

insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,
					standard_room,`description`,pool_area,number_of_floor)
	values 	("DV-6388","Villa-6388",50,500.0,10,2,2,
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
	values 	(2,"KH-4521","DV-6388",'2021-02-15','2021-02-26',2500,5500),
			(5,"KH-6008","DV-1478",'2019-02-25','2019-03-29',1500,3400),
			(4,"KH-9088","DV-9701",'2018-08-01','2018-08-04',750,1500),
			(6,"KH-1241","DV-3417",'2021-01-01','2021-01-11',4000,1250),
			(1,"KH-0802","DV-4581",'2020-03-07','2021-04-08',6000,9300),
			(7,"KH-3726","DV-0207",'2021-04-12','2021-04-23',2000,3300),
			(8,"KH-5599","DV-9701",'2021-04-15','2021-04-25',3000,5500),
			(6,"KH-9696","DV-1478",'2020-06-14','2020-09-02',5000,7800),
			(9,"KH-2686","DV-6388",'2018-10-17','2018-10-22',1500,2500)
            ;

insert into contract_detail(contract_id,attach_service_id,quantity) /*1-9*/ /*1-5*/
	values 	(2,4,1),(3,1,2),(1,2,1),(4,3,3),(7,5,2),(7,4,3),(8,1,2),
			(5,2,4),(1,3,2),(5,5,4),(4,4,5),(3,3,5),(2,2,1),(9,4,3),
            (1,1,2),(6,2,6),(8,2,4),(9,2,4),(4,2,4),(6,5,2),(7,1,4),
            (6,4,1),(3,4,4),(1,5,3);