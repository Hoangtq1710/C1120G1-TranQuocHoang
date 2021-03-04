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
where loai_khach.ten_loai_khach = 'Diamond' and khach_hang.dia_chi IN ('Đà Nẵng', 'Quảng Ngãi');

/*TASK 12*/
/*12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
(được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.*/

select 	dich_vu.ten_dich_vu as TenDichVu,
		hop_dong.id_hop_dong as IDHopDong,
		nhan_vien.ho_ten as TenNhanVien,
        khach_hang.ho_ten as TenKhachHang,
        khach_hang.sdt as SoDienThoaiKhachHang,
        sum(hop_dong_chi_tiet.so_luong) as SoLuongDichVuDikem,
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
/*13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/

select 	dich_vu_di_kem.id_dich_vu_di_kem as IDDVDK,
		dich_vu_di_kem.ten_dich_vu_di_kem as TenDVDK,
        dich_vu_di_kem.gia as Gia,
        count(hop_dong_chi_tiet.id_dich_vu_di_kem) as SoLanSuDung
from dich_vu_di_kem
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
group by hop_dong_chi_tiet.id_dich_vu_di_kem
having count(hop_dong_chi_tiet.id_dich_vu_di_kem) = 
	(select max(SoLanSuDung)
    from 
		(select count(id_dich_vu_di_kem) as SoLanSuDung
        from hop_dong_chi_tiet
        group by id_dich_vu_di_kem) as SoLanSuDungDichVuDiKem
        );

/*TASK 14*/
/*14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/

select 	hop_dong_chi_tiet.id_hop_dong as IDHopDong,
		loai_dich_vu.ten_loai_dich_vu as TenLoaiDichVu,
        dich_vu_di_kem.ten_dich_vu_di_kem as TenDichVuDiKem,
        hop_dong_chi_tiet.so_luong as SoLanSuDung
from hop_dong_chi_tiet
inner join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
inner join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
inner join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
inner join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by hop_dong_chi_tiet.id_dich_vu_di_kem
having count(hop_dong_chi_tiet.id_dich_vu_di_kem) = 1;

/*TASK 15*/
/*15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/

select 	nhan_vien.id_nhan_vien as IDNhanVien,
		nhan_vien.ho_ten as HoTen,
        trinh_do.trinh_do as TrinhDo,
		bo_phan.ten_bo_phan as TenBoPhan,
        nhan_vien.sdt as SoDienThoai,
        nhan_vien.dia_chi as DiaChi
from nhan_vien
inner join trinh_do on trinh_do.id_trinh_do = nhan_vien.id_trinh_do
inner join bo_phan on bo_phan.id_bo_phan = nhan_vien.id_bo_phan
inner join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
where (year(hop_dong.ngay_lam_hop_dong) >= 2018 and year(hop_dong.ngay_lam_hop_dong) <= 2019)
group by hop_dong.id_nhan_vien
having (count(hop_dong.id_nhan_vien) <= 3);

/*TASK 16*/
/*16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.*/

create temporary table task16
	select nhan_vien.id_nhan_vien 
	from nhan_vien
	inner join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
	where year(hop_dong.ngay_lam_hop_dong) >= 2017 and year(hop_dong.ngay_lam_hop_dong) <= 2021
    group by id_nhan_vien;
    
DELETE from nhan_vien
where id_nhan_vien not in
(
	select id_nhan_vien from task16
);

/*TASK 17*/
/*17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ ~ 435$.*/
/*tạo bảng phụ*/

/*create or replace view task17 as
		select id_loai_khach
		from khach_hang
		inner join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
		where year(hop_dong.ngay_lam_hop_dong) = 2019
		group by khach_hang.id_khach_hang
		having sum(hop_dong.tong_tien) > 435;*/
        
create temporary table if not exists table17
select id_loai_khach
		from khach_hang
		inner join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
		where year(hop_dong.ngay_lam_hop_dong) = 2019
		group by khach_hang.id_khach_hang
		having sum(hop_dong.tong_tien) > 435;
select * from table17;

UPDATE khach_hang
set id_loai_khach = (select id_loai_khach from loai_khach where ten_loai_khach = 'Diamond')
where (id_loai_khach = (select id_loai_khach from loai_khach where ten_loai_khach = 'Platinum')) 
and id_loai_khach in 
	(
		select id_loai_khach from table17
	)
;

/*TASK 18*/
/*18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).*/
/*Xóa Nguyễn Tấn Khoa*/

/*Đã set lại khóa ngoại của 2 bảng hop_dong_chi_tiet và bảng hop_dong thêm " on delete cascade "
Mục đích : khi xóa 1 khách hàng từ bảng khách hàng thì nó sẽ xóa luôn những hợp đồng của khách hàng đó trong bảng hop_dong và xóa luôn
các hợp đồng chi tiết nằm trong bảng hop_dong_chi_tiet*/

delete from khach_hang
where id_khach_hang in 
	(
		select id_khach_hang 
		from hop_dong
        where year(hop_dong.ngay_lam_hop_dong) < 2016
	);

/*TASK 19*/
/*19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.*/

create temporary table if not exists task19
	select 	dich_vu_di_kem.id_dich_vu_di_kem as IDDVDK,
			dich_vu_di_kem.ten_dich_vu_di_kem as TenDVDK,
            dich_vu_di_kem.gia as Gia,
            sum(hop_dong_chi_tiet.so_luong) as SoLanSuDung
	from dich_vu_di_kem
	inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
    group by hop_dong_chi_tiet.id_dich_vu_di_kem
    having SoLanSuDung > 10;
    
UPDATE dich_vu_di_kem
set dich_vu_di_kem.gia = dich_vu_di_kem.gia * 2
where id_dich_vu_di_kem
in 
	(
		select IDDVDK from task19
	);

		/*select table_name, is_updatable
		from information_schema.views
		where table_schema = 'module3_case_study';*/
        
        
/*TASK 20*/
/*20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.*/

select 	khach_hang.id_khach_hang as ID,
		khach_hang.ho_ten,
        khach_hang.email,
        khach_hang.sdt,
        khach_hang.ngay_sinh,
        khach_hang.dia_chi,
        'Khách hàng' as ViTri
from khach_hang
union all
select 	nhan_vien.id_nhan_vien as ID,
		nhan_vien.ho_ten,
        nhan_vien.email,
        nhan_vien.sdt,
        nhan_vien.ngay_sinh,
        nhan_vien.dia_chi,
        'Nhân viên' as ViTri
from nhan_vien;

    
    