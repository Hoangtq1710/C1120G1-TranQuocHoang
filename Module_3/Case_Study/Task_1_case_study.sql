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
values 
(3,"Trần Quốc Hoàng",'1995-10-17',"201784966","0794113544","hoang@gmail.com","Đà Nẵng"),
(4,"Nguyễn Hoàng Bảo Ngọc",'1997-12-05',"207146212","0714531169","ngoc@gmail.com","Quảng Trị"),
(5,"Trần Thị Lê Quang",'1993-11-23',"204184987","0771411074","quang@gmail.com","Huế"),
(2,"Trần ngọc Ty",'1994-12-21',"204145135","0751237484","ty@gmail.com","Vinh");

insert into khach_hang(id_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi)
values (2,"Nguyễn Hoàng Bảo Ngọc",'1996-04-05',"200144613","0714531169","ngoc2@gmail.com","Quảng Trị");

insert into khach_hang(id_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi)
values (5,"Khương Thị Ngọc Thuần",'1999-11-30',"201444146","0145911074","thuan@gmail.com","Quảng Trị");

insert into nhan_vien(ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,so_cmnd,luong,sdt,email,dia_chi)
values 	("Nguyễn Ngọc Thuần",4,3,4,'1997-07-09',207845112,800,0784112449,"thuan@gmail.com","Đà Nẵng"),
		("Nguyễn Văn Khoa",3,2,2,'1999-12-19',241005430,600,0361112911,"khoa@gmail.com","Đà Nẵng"),
		("Phạm Văn Tuấn",1,4,1,'1995-04-24',203334007,400,0367415940,"tuan@gmail.com","Huế"),
        ('Trần Trung An', '2', '3', '1', '1992-05-06', '204111334', '500', '784221144', 'kien@gmail.com', "Quảng Trị");

insert into dich_vu(ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_loai_dich_vu,trang_thai)
values 	("Villa 1",100,6,14,500,2,1,"có"),
		("House 1",50,4,17,300,3,2,"có"),
		("Phòng 1",24,3,10,100,2,3,"có"),
		("Villa 2",150,8,30,500,3,1,"không"),
		("Phòng 2",32,2,28,100,1,3,"có")
;

insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien)
values 	(2,1,5,'2017-02-11','2021-02-26',0,3500),
		(3,2,1,'2018-01-25','2021-03-22',1500,2500),
		(2,3,4,'2019-02-01','2021-02-20',3000,4500),
		(2,4,2,'2020-07-17','2021-01-18',1000,3000),
		(1,1,1,'2021-01-19','2021-01-16',500,3000);
insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien)
values 	(4,2,1,'2019-10-16','2020-01-21',460,3500);
        
insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien)
values 	(4,6,3,'2019-07-16','2020-01-29',510,2400),
		(2,4,2,'2019-07-16','2019-10-29',240,1050);

insert into hop_dong_chi_tiet(id_hop_dong,id_dich_vu_di_kem,so_luong)
values 	(6,4,1),
		(7,1,2),
		(8,2,1),
		(6,3,1),
        (9,5,2),
        (10,2,4),
        (8,1,2),
        (9,2,2);
