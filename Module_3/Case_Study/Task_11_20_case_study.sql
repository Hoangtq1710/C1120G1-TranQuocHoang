/*TASK 11*/
/*11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng 
có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.*/
use module3_case_study;
select 	khach_hang.ho_ten as HoTen,
		dich_vu_di_kem.id_dich_vu_di_kem as IDDVDK,
		dich_vu_di_kem.ten_dich_vu_di_kem as TenDVDK,
        dich_vu_di_kem.gia as Gia,
        dich_vu_di_kem.don_vi as DonVi,
        dich_vu_di_kem.trang_thai_kha_dung as KhaDung,
        loai_khach.ten_loai_khach as TenLoaiKhachHang,
        khach_hang.dia_chi as DiaChi
from dich_vu_di_kem
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
inner join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
inner join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
inner join loai_khach on loai_khach.id_loai_khach = khach_hang.id_loai_khach
where loai_khach.ten_loai_khach = 'Gold' and (khach_hang.dia_chi IN ('Đà Nẵng', 'Quảng Ngãi'));

/*TASK 12*/
/*12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
(được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.*/

select 	dich_vu.ten_dich_vu as TenDichVu,
		hop_dong.id_hop_dong as IDHopDong,
		nhan_vien.ho_ten as TenNhanVien,
        khach_hang.ho_ten as TenKhachHang,
        khach_hang.sdt as SoDienThoaiKhachHang,
        hop_dong_chi_tiet.so_luong as SoLuongDichVuDikem,
        hop_dong.tien_dat_coc as TienDatCoc

from dich_vu
inner join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
inner join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
inner join nhan_vien on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
where 
hop_dong.id_dich_vu 
in 
	(select id_dich_vu from hop_dong where (month(ngay_lam_hop_dong) in (10,11,12) and (year(ngay_lam_hop_dong) = 2019)))
and hop_dong.id_dich_vu 
not in
	(select id_dich_vu from hop_dong where (month(ngay_lam_hop_dong) in (1,2,3,4,5,6) and (year(ngay_lam_hop_dong) = 2019)))
group by hop_dong.id_dich_vu;

/*TASK 13*/
/**/








