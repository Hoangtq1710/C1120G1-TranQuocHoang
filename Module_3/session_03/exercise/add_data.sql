use library;

insert into category(ten_loai_sach)
values ("Sách Văn Học"), ("Sách Toán Học"), ("Sách Tin Học"), ("Sách Sinh Học"), ("Sách Hóa Học");

insert into student(ten_sv,dia_chi,email,image)
values 	("Trần Hoàng Sang","K35 Ngô Quyền","sang@gmail.com","ảnh của Sang"),
		("Hoàng Lê Quang","99 Thái Thị Bôi","quang@gmail.com","ảnh của Quang"),
        ("Nguyễn Hoàng Bảo Ngọc","K345/1 Nguyễn Hoàng","ngoc@gmail.com","ảnh của Ngọc"),
        ("Lê Văn Quang","Đại Quang","lequang@gmail.com","ảnh của Văn Quang"),
        ("Donald Trump","97 Thái Thị Bôi","trump@gmail.com","ảnh của anh Trump");
        
insert into book(ten_sach,nxb,tac_gia,nam_xb,sl_xb,gia,anh,ma_loai_sach)
values 	("Sinh học lớp 9","NXB GD","Lê Văn Đức","2008",500000,20000,"sách sinh lớp 9",4),
		("Sách tập đọc lớp 3","NXB Kim Đồng","Nguyễn Văn Toàn","2014",750000,23000,"sách tập đọc lớp 3",1),
		("Sách bài tập Hóa 10","NXB Đà Nẵng","Huỳnh Văn Ngọc","2010",1200000,29000,"sách bài tập hóa lớp 10",5),
		("Lập trình C/C++","NXB Thanh Thanh","Mark Gordy & John Leminton","1998",325000,25000,"lập trình c/c++",3),
		("Hình học 12","NXB GD","Cao Minh Thắng","2003",1500000,18000,"sách hình học lớp 12",2)
;

insert into borrow_orders(ma_sach,ma_sv,ngay_muon,ngay_tra)
values 	(3,2,'2021-01-01','2021-01-16'),
		(5,1,'2021-02-10','2021-02-25'),
		(2,4,'2021-01-13','2021-01-28'),
		(4,3,'2021-02-03','2021-02-18'),
		(1,5,'2021-01-17','2021-02-02');