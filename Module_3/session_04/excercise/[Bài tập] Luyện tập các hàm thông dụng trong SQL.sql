create database session_04;
use session_04;

create table hoc_vien
(id int not null,
ten varchar(255) not null,
tuoi int not null,
khoa_hoc varchar(255) not null,
so_tien int not null
);

insert into hoc_vien(id,ten,tuoi,khoa_hoc,so_tien)
values 	(1,"Hoang",21,"CNTT", 400000),
		(2,"Viet",19,"DTVT", 320000),
		(3,"Thanh",18,"KTDN", 400000),
		(4,"Nhan",19,"CK", 450000),
		(5,"Huong",20,"TCNH", 500000),
		(5,"Huong",20,"TCNH", 200000);
/*Viết câu lệnh hiện thị tất cả các dòng có tên là Huong*/
Select id, ten, tuoi, khoa_hoc, so_tien 
from hoc_vien
where ten = 'Huong';

/*Viết câu lệnh lấy ra tổng số tiền của Huong*/
Select sum(so_tien)
from hoc_vien
where ten = 'Huong';

/*Viết câu lệnh lấy ra danh sách tên của tất cả học viên, không trùng lặp*/
select distinct ten
from hoc_vien;