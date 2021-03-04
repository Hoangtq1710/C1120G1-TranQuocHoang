create database construction_management;
use construction_management;

create table phong_ban
(ma_pb int(20) not null unique primary key,
ten_pb varchar(255) not null
);

create table nhan_vien
(ma_nv int(30) not null unique primary key,
ho_ten varchar(255) not null,
ngay_sinh date not null,
gioi_tinh varchar(10),
dia_chi varchar(255) not null,
ma_pb int(20),
foreign key (ma_pb) references phong_ban(ma_pb)
);

create table so_bao_hiem
(ma_bh varchar(25) not null unique primary key,
ngay_cap date not null,
thoi_han date not null,
ma_nv int(30),
foreign key(ma_nv) references nhan_vien(ma_nv)
);

create table cong_trinh
(ma_ct int(20) not null primary key,
ten_ct varchar(255) not null,
dia_diem varchar(255) not null,
ngay_cap_gp date not null,
ngay_kc date not null,
ngay_ht date
);

create table ngay_cong
(ma_nv int(30),
ma_ct int(20),
primary key(ma_nv,ma_ct),
sl_ngay_cong int(5) check (sl_ngay_cong > 0),
foreign key(ma_nv) references nhan_vien(ma_nv),
foreign key(ma_ct) references cong_trinh(ma_ct)
);