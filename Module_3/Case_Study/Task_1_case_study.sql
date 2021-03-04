/*TASK 1*/
insert into vi_tri(ten_vi_tri)
	values ("Lễ tân"),("Phục vụ"),("Chuyên viên"),("Giám sát"),("Quản lý"),("Giám đốc");

insert into trinh_do(trinh_do)
	values ("Trung cấp"),("Cao đẳng"),("Đại học"),("Sau đại học");

insert into bo_phan(ten_bo_phan)
	values ("Sale–Marketing"),("Hành chính"),("Phục vụ"),("Quản lý");

insert into loai_khach(ten_loai_khach)
	values ("Diamond"),("Platinum"),("Gold"),("Silver"),("Member");

insert into loai_dich_vu(ten_loai_dich_vu)
	values ("Villa"),("House"),("Phòng"), ("Dịch vụ đi kèm");

insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung)
	values 	("Massage",20,"lần","có"),
			("Karaoke",15,"giờ","không"),
			("Thức ăn",3,"dĩa","có"),
			("Nước uống",1,"chai","có"),
			("Thuê xe",10,"lần","có");
        
insert into kieu_thue(ten_kieu_thue,gia)
	values ("thuê theo giờ",50),("thuê theo ngày",500),("thuê theo tháng",7000),("thuê theo năm",60000);

insert into khach_hang(id_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi)
	values 	(1,"Trần Quốc Hoàng",'1995-10-17',"201784966","0794113544","hoang@gmail.com","Đà Nẵng"),
			(4,"Nguyễn Hoàng Bảo Ngọc",'1997-12-05',"207146212","0714531169","ngoc@gmail.com","Quảng Trị"),
			(5,"Trần Thị Lê Quang",'1993-11-23',"204184987","0771411074","quang@gmail.com","Huế"),
			(2,"Trần ngọc Ty",'1994-12-21',"204145135","0751237484","ty@gmail.com","Vinh"),
			(2,"Nguyễn Hoàng Bảo Ngọc",'1996-04-05',"200144613","0714531169","ngoc2@gmail.com","Quảng Trị"),
            (3,"Nguyễn Tấn Khoa",'1992-08-05',"204014613","0714743364","khoa@gmail.com","Huế"),
            (5,"Khương Thị Ngọc Thuần",'1999-11-30',"201444146","0145911074","thuan@gmail.com","Quảng Trị"),
            (1,"Quách Mộng Du",'1992-06-03',"200991142","0781569231","mongdu@gmail.com","Đà Nẵng"),
            (3,"Cao Thị Phương",'1998-02-07',"263319012","0354569974","caophuong@gmail.com","Liên Chiểu");
            

insert into nhan_vien(ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,so_cmnd,luong,sdt,email,dia_chi)
	values 	("Nguyễn Ngọc Thuần",4,3,4,'1997-07-09',207845112,800,0784112449,"thuan@gmail.com","Đà Nẵng"),
			("Nguyễn Văn Khoa",3,2,2,'1999-12-19',241005430,600,0361112911,"khoa@gmail.com","Đà Nẵng"),
			("Phạm Văn Tuấn",1,4,1,'1995-04-24',203334007,400,0367415940,"tuan@gmail.com","Huế"),
			('Trần Trung An', '2', '3', '1', '1992-05-06', '204111334', '500', '784221144', 'kien@gmail.com', "Hải Châu"),
			("Hồ A Quang",3,2,1,'1993-09-20',207494007,430,0122515940,"quangho@gmail.com","Vinh"),
			("Khách A Phủ",3,4,4,'1985-11-04',200314007,620,0978115110,"phukhach@gmail.com","Quảng Trị"),
			("Giàng A Tô",2,4,2,'1998-02-25',203310147,500,0367411940,"togiang@gmail.com","Quảng Ngãi"),
			("Nguyễn Văn Thoại",1,4,1,'2000-09-24',203114555,540,0154222333,"thoai@gmail.com","Hải Châu"),
			("Trần Trung Kiên",3,3,2,'1994-01-27',201112456,460,0897444551,"kien@gmail.com","Hải Châu");
        

insert into dich_vu(ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_loai_dich_vu,trang_thai)
	values 	("Villa 1",100,6,14,500,2,1,"có"),
			("House 1",50,4,17,300,3,2,"có"),
			("Villa 2",150,8,30,500,3,1,"không"),
			("House 2",320,5,35,450,2,1,"có"),
			("Villa 3",450,3,25,500,1,2,"không"),
			("Phòng 3",35,2,28,100,1,3,"có");
        
insert into dich_vu(ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_loai_dich_vu,trang_thai)
	values	("Phòng 1",24,3,10,100,2,3,"có"),
			("Phòng 2",60,9,40,650,4,3,"có");

insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien)
	values 	(2,1,5,'2017-02-11','2021-02-26',0,3500),
			(3,2,1,'2018-01-25','2021-03-22',1500,2500),
			(2,3,4,'2019-02-01','2021-02-20',3000,4500),
			(2,4,2,'2020-07-17','2021-01-18',1000,3000),
			(1,1,1,'2021-01-19','2021-01-16',500,3000),
            (4,2,1,'2019-12-12','2020-01-21',460,3500),
			(3,4,5,'2018-10-16','2018-12-06',400,2300),
            (4,6,3,'2019-12-12','2020-01-29',510,2400),
			(2,4,2,'2019-07-16','2019-10-29',240,1050),
            (8,4,3,'2019-12-12','2019-12-15',300,1200),
            (5,9,5,'2015-06-12','2015-12-06',800,2000),
			(6,3,1,'2016-05-29','2016-12-06',600,900),
			(7,5,3,'2015-01-20','2015-04-06',355,1500),
			(5,4,2,'2018-11-24','2019-01-02',100,1200);

insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien)
	values	(5,5,11,'2015-06-17','2015-09-06',420,1680),
			(1,9,12,'2016-05-02','2016-06-06',650,2450),
			(6,6,11,'2018-01-24','2018-02-06',500,1500);

insert into hop_dong_chi_tiet(id_hop_dong,id_dich_vu_di_kem,so_luong)
	values 	(2,4,1),(3,1,2),(1,2,1),(4,3,1),(6,5,2),(7,4,3),(8,1,2),
			(9,2,1),(13,3,2),(14,5,4),(8,4,4),(10,1,5),(11,2,2);
            
insert into hop_dong_chi_tiet(id_hop_dong,id_dich_vu_di_kem,so_luong)
	values 	(2,2,3),(3,1,2),(6,2,6),(8,2,4),(9,2,4),(10,2,4),
			(6,2,4),(12,1,1),(13,4,1),(7,4,7),(1,4,3);
            
insert into hop_dong_chi_tiet(id_hop_dong,id_dich_vu_di_kem,so_luong)
	values 	(19,1,2),(20,4,3),(21,3,1);
