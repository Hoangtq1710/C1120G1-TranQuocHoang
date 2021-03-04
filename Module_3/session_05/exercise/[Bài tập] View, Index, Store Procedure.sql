/*Bước 1*/
create database if not exists session_05_view_procedure;
use session_05_view_procedure;

/*Bước 2*/
create table products(
id int not null primary key auto_increment,
productCode varchar(20) not null,
productName varchar(50) not null,
productPrice int(20) not null,
productAmount int(20) not null,
productDescription varchar(255),
productStatus varchar(255) not null
);

insert into products(productCode,productName,productPrice,productAmount,productDescription,productStatus)
values	("Product-01","Sony",3000,15000,"Product of Sony","available"),
		("Product-02","Samsung",2500,13500,"Product of Samsung","available"),
		("Product-03","Hitachi",1600,9800,"Product of Hitachi","not availabel"),
		("Product-04","Apple",4500,25000,"Product of Apple","availabel");

/*Bước 3*/
alter table products
add index indexProduct(productCode);

alter table products
add index compositeIndex(productName,productPrice);

select * from products where productCode = 'Product-03';
explain select * from products where productCode = 'Product-03';

select * from products where productName = 'Samsung' and productPrice = '2500';
explain select * from products where productName = 'Samsung' and productPrice = '2500';

/*Bước 4*/
/*tạo view*/
create or replace view ProductInfor
as
	select productCode, productName, productPrice, productStatus
    from products;
    
select * from ProductInfor;

/*sửa đổi view*/
create or replace view ProductInfor
as
	select productCode, productName, productPrice, productStatus, productDescription
    from products
    where productPrice = '4500';
    
select * from ProductInfor;

/*xóa view*/
drop view ProductInfor;

/*Bước 5*/

/*lấy thông tin của tất cả sản phẩm*/
delimiter $$
create procedure getProductInfor()
begin
	select * from products;
end $$
delimiter ;

call getProductInfor();

/*thêm 1 sản phẩm mới*/
delimiter $$
create procedure addNewProduct()
begin
	insert into products(productCode,productName,productPrice,productAmount,productDescription,productStatus)
    values ("Product-05","Oppo",3500,17500,"Product of Oppo","available");
end $$
delimiter ;

call addNewProduct();
call getProductInfor();

/*sửa thông tin sản phẩm theo id*/
delimiter $$
create procedure editProductById(IN in_id int)
begin
	update products
    set productPrice = 2000
    where in_id = id;
end $$
delimiter ;

call editProductById(3);

/*xóa sản phẩm theo id*/
delimiter $$
create procedure deleteProductById(IN in_id int)
begin
	delete from products
    where in_id = id;
end $$
delimiter ;

call getProductInfor();
call deleteProductById(2);
call getProductInfor();
