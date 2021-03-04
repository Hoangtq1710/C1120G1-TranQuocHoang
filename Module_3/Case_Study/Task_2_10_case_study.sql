use module3_case_study;
/*TASK 2*/
/*2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và
		có tối đa 15 ký tự.*/
select * from nhan_vien
where (ho_ten LIKE 'H%' or ho_ten LIKE 'T%' or ho_ten LIKE 'K%') and length(ho_ten) <= 15;

/*TASK 3*/
/*3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/

select * from khach_hang
where (timestampdiff(year,ngay_sinh, now()) >= 18 or (timestampdiff(year,ngay_sinh, now()) <= 50)) and
		(dia_chi = 'Đà Nẵng' or dia_chi = 'Quảng Trị');

/*TASK 4*/
/*4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/

select 
	khach_hang.ho_ten as ho_ten,
    loai_khach.ten_loai_khach as loai_khach, 
    count(*) as so_luong
from 
	(khach_hang
	inner join loai_khach 
	on loai_khach.id_loai_khach = khach_hang.id_loai_khach)
inner join hop_dong 
on hop_dong.id_khach_hang = khach_hang.id_khach_hang
group by khach_hang.id_khach_hang
having ten_loai_khach = 'Platinum'
order by so_luong;

/*TASK 5*/
/*5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
 cho tất cả các Khách hàng đã từng đặt phòng. 
 (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/
 
 select khach_hang.id_khach_hang as IDKhachHang,
		khach_hang.ho_ten as HoTen,
		loai_khach.ten_loai_khach as TenLoaiKhach,
        hop_dong.id_hop_dong as IDHopDong,
        dich_vu.ten_dich_vu as TenDichVu,
        hop_dong.ngay_lam_hop_dong as NgayLamHopDong,
        hop_dong.ngay_ket_thuc as NgayKetThuc,
        case 
			when hop_dong.id_hop_dong in (select distinct id_hop_dong from hop_dong_chi_tiet)
			then sum(dich_vu.chi_phi_thue + (hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia))
				else dich_vu.chi_phi_thue
        end as TongTien
        
from khach_hang
left join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
left join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
left join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by hop_dong.id_hop_dong;

/*6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ 
chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/

Select 	dich_vu.id_dich_vu as IDDichVu,
		dich_vu.ten_dich_vu as TenDichVu,
        dich_vu.dien_tich as DienTich,
        dich_vu.chi_phi_thue as ChiPhiThue,
        loai_dich_vu.ten_loai_dich_vu as TenLoaiDichVu,
        hop_dong.ngay_lam_hop_dong as NgayLamHopDong
from dich_vu
inner join hop_dong on dich_vu.id_dich_vu = hop_dong.id_dich_vu
left join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
where hop_dong.id_dich_vu not in
	(select hop_dong.id_dich_vu 
	from hop_dong 
	where (year(ngay_lam_hop_dong) >= '2019' and month(ngay_lam_hop_dong) >= 1 ));


/*TASK 7*/
/*7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả 
các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng trong năm 2019.*/

select 	dich_vu.id_dich_vu as IDDichVu,
		dich_vu.ten_dich_vu as TenDichVu,
        dich_vu.dien_tich as DienTich,
        dich_vu.so_nguoi_toi_da as SoNguoiToiDa,
        dich_vu.chi_phi_thue as ChiPhiThue,
        loai_dich_vu.ten_loai_dich_vu as TenLoaiDichVu,
        hop_dong.ngay_lam_hop_dong as NgayLamHopDong
from dich_vu
inner join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
inner join hop_dong
on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where dich_vu.id_dich_vu 
in 
	(select id_dich_vu from hop_dong where year(ngay_lam_hop_dong) = 2018)
and dich_vu.id_dich_vu 
not in
	(select id_dich_vu from hop_dong where year(ngay_lam_hop_dong) = 2019);

/*TASK 8*/
/*8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoTenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
*/
/*Cách 1 : sử dụng group by ho_ten*/
select ho_ten from khach_hang
group by ho_ten;
/*Cách 2 : sử dụng distinct*/
select distinct ho_ten from khach_hang;
/*Cách 3 : sử dụng union*/
select ho_ten from khach_hang
union
select ho_ten from khach_hang;

/*TASK 9*/
/*9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là 
tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/

select month(ngay_lam_hop_dong) as thang, count(id_khach_hang) as so_hop_dong
from hop_dong
where year(ngay_lam_hop_dong) = 2019
group by thang;

/*TASK 10*/
/*10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
(được tính dựa trên việc count các IDHopDongChiTiet).*/

select 	hop_dong.id_hop_dong as IDHopDong,
		hop_dong.ngay_lam_hop_dong as NgayLamHopDong,
        hop_dong.ngay_ket_thuc as NgayKetthuc,
        hop_dong.tien_dat_coc as TienDatCoc,
        count(hop_dong_chi_tiet.id_dich_vu_di_kem) as SoLuongDichVuDiKem
from hop_dong
inner join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
group by hop_dong.id_hop_dong;

