/*TASK 21*/
/*21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên 
có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ 
với ngày lập hợp đồng là “12/12/2019”*/

create or replace view V_NHANVIEN as
	select 	nhan_vien.id_nhan_vien as IDNhanVien,
			nhan_vien.ho_ten as HoTen,
            vi_tri.ten_vi_tri as ViTri,
            trinh_do.trinh_do as TrinhDo,
            bo_phan.ten_bo_phan as BoPhan,
            nhan_vien.ngay_sinh as NgaySinh,
            nhan_vien.so_cmnd as SoCMND,
            nhan_vien.email as Email,
            nhan_vien.dia_chi as DiaChi
    from nhan_vien
	inner join vi_tri on vi_tri.id_vi_tri = nhan_vien.id_vi_tri
    inner join trinh_do on trinh_do.id_trinh_do = nhan_vien.id_trinh_do
    inner join bo_phan on bo_phan.id_bo_phan = nhan_vien.id_bo_phan
    inner join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
    where nhan_vien.dia_chi = 'Hải Châu' and hop_dong.ngay_lam_hop_dong = '2019-12-12'
    group by hop_dong.id_nhan_vien
    having count(hop_dong.id_hop_dong) >= 1;

/*TASK 22*/
/*22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với 
tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.*/

UPDATE nhan_vien
SET nhan_vien.dia_chi = 'Liên Chiểu'
where nhan_vien.id_nhan_vien in 
	(	
		select IDNhanVien
		from v_nhanvien
	);

/*TASK 23*/
/*23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với 
Id Khách hàng được truyền vào như là 1 tham số của Sp_1*/

delimiter $$
create procedure Sp_1(IN in_id int)
begin
	delete from khach_hang
    where id_khach_hang = in_id;
end $$
delimiter ;

call Sp_1(9);

/*TASK 24*/
/*24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với 
yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.*/

delimiter $$
create procedure Sp_2(
		in in_id_nhan_vien int,in in_id_khach_hang int,in in_id_dich_vu int,
		in in_ngay_lam_hop_dong date,in in_ngay_ket_thuc date,in in_tien_dat_coc int,in in_tong_tien int
)
begin
	if 	in_id_nhan_vien in (select distinct id_nhan_vien from nhan_vien) and
		in_id_khach_hang in (select distinct id_khach_hang from khach_hang) and
        in_id_dich_vu in (select distinct id_dich_vu from dich_vu)
    then 
		insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien)
            value (in_id_nhan_vien,in_id_khach_hang,in_id_dich_vu,in_ngay_lam_hop_dong,in_ngay_ket_thuc,in_tien_dat_coc,in_tong_tien) ;
	end if;
end $$
delimiter ;

call Sp_2(3,8,4,'2019-05-08','2019-06-04',350,1600);

/*TASK 25*/
/*25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại
 có trong bảng HopDong ra giao diện console của database*/
 
 /*TASK 26*/
 /*26.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, 
 với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
 Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo
 “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database*/
        
/*TASK 27*/
 /*27.	Tạo user function thực hiện yêu cầu sau:
 a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ ~ 90$.
 
 b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng 
 mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ,
 không xét trên toàn bộ các lần làm hợp đồng). Mã của Khách hàng được truyền vào như là 1 tham số của function này.*/
 
 /*TASK 28*/
 /*28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” 
 từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) 
 và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản ghi trong bảng HopDong) và những bản liên quan khác*/
		
/**/
delimiter $$
drop procedure Sp_3 ;
create procedure Sp_3(in in_ten_loai_dv varchar(10), in in_nam_dau varchar(4), in in_nam_cuoi varchar(4))
begin
	drop temporary table if exists temp_table_Sp3;
	create temporary table temp_table_Sp3
		select dich_vu.id_dich_vu as IDDichVu
		from dich_vu
		inner join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
		inner join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
		where year(hop_dong.ngay_lam_hop_dong) between in_nam_dau and in_nam_cuoi
			and loai_dich_vu.ten_loai_dich_vu = in_ten_loai_dv
		group by dich_vu.id_dich_vu;
        
	DELETE from dich_vu
    where dich_vu.id_dich_vu in 
		(select IDDichVu from temp_table_Sp3);
    
end $$
delimiter ;

call Sp_3('Phòng', '2015', '2019');





