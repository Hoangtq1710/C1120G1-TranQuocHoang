/*Bây giờ, nếu bạn muốn lấy customerNumber, customerName, phone, paymentDate, amount từ 
hai bảng customers và payments với điều kiện là các khách hàng sống ở thành phố Las Vegas thực hiện truy vấn sau: */

select customers.customerNumber,customerName,phone,payments.paymentDate,payments.amount
from customers
inner join payments
on customers.customerNumber = payments.customerNumber
where customers.city = 'Las Vegas';

/*Để tìm tất cả các đơn hàng thuộc từng khách hàng, bạn có thể sử dụng mệnh đề LEFT JOIN như sau:*/

select customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customers
left join orders
on customers.customerNumber = orders.customerNumber;

