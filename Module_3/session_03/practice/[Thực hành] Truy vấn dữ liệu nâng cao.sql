/*Bây giờ nếu muốn hiển thị ra các sản phẩm có giá lớn hơn 56.76 và số lượng trong kho lớn hơn 10 sử dụng truy vấn như sau:*/
select productCode, productName, buyprice, quantityInStock from products
where buyprice > 56.76 and quantityInStock > 10;

/*Bây giờ, nếu bạn muốn lấy productcode, productname và buyprice từ bảng products, textdescription
từ bảng productlines với điều kiện giá mua nằm trong khoảng từ 56.76 đến 95.59.
Bạn cần chọn dữ liệu từ cả hai bảng và đối chiếu các hàng bằng cách so sánh cột productline từ 
bảng sản phẩm với cột productline từ bảng productlines dưới dạng truy vấn sau:*/

select productCode,productName,buyPrice, productlines.textDescription from products
inner join productlines
on products.productLine = productlines.productLine
where (buyPrice >= 56.76 AND buyPrice <= 95.59);

/*Bây giờ nếu muốn hiển thị ra các sản phẩm có loại sản phẩm là Classic Cars hoặc nhà cung cấp là 'Min Lin Diecast' sử dụng truy vấn như sau:*/

select productCode, productName, buyprice, quantityInStock, productVendor, productLine 
from products
where productLine = 'Classic Cars' OR productVendor = 'Min Lin Diecast';
