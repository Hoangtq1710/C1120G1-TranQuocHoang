create database library;
use library;

create table category
(ma_loai_sach int not null auto_increment primary key,
ten_loai_sach varchar(50) not null
);

create table student
(ma_sv int not null auto_increment primary key,
ten_sv varchar(255) not null,
dia_chi varchar(255) not null,
email varchar(255) not null,
image varchar(255)
);

create table book
(ma_sach int not null auto_increment primary key,
ten_sach varchar(255) not null,
nxb varchar(255) not null,
tac_gia varchar(255) not null,
nam_xb varchar(255) not null,
sl_xb int not null,
gia int not null,
anh varchar(255),
ma_loai_sach int,
foreign key (ma_loai_sach) references category(ma_loai_sach)
);

create table borrow_orders
(ma_phieu int not null auto_increment primary key,
ma_sach int, foreign key(ma_sach) references book(ma_sach),
ma_sv int, foreign key(ma_sv) references student(ma_sv),
ngay_muon date not null,
ngay_tra date not null
);