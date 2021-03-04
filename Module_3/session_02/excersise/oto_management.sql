use Oto_management;
create table offices
(office_code varchar(10) not null primary key,
city varchar(50) not null,
phone varchar(50) not null,
address_line_1 varchar(50) not null,
address_line_2 varchar(50),
state varchar(50),
country varchar(50) not null,
postalCode varchar(15) not null
);

create table product_lines
(product_line varchar(50) not null primary key,
text_description text,
image text
);

create table employees
(employee_number int not null primary key,
last_name varchar(50) not null,
first_name varchar(50) not null,
email varchar(100) not null,
job_title varchar(50) not null,
report_to int, foreign key(report_to) references employees(employee_number),
office_code varchar(10), foreign key (office_code) references offices(office_code)
);

create table customers
(customer_number int not null primary key,
customer_name varchar(50) not null,
contact_last_name varchar(50) not null,
contact_first_name varchar(50) not null,
phone varchar(50) not null,
address_line_1 varchar(50) not null,
address_line_2 varchar(50),
city varchar(50) not null,
state varchar(50) not null,
postalCode varchar(15) not null,
country varchar(50) not null,
credit_limit float,
sales_rep_emp_number int, foreign key (sales_rep_emp_number) references employees(employee_number)
);

create table orders
(order_number int not null primary key,
order_date date not null,
customer_number int, foreign key (customer_number) references customers(customer_number),
required_date date not null,
shipped_date date,
order_status varchar(15) not null,
comments text,
quantity_ordered int not null,
price_each float not null
);

create table payments
(customer_number int, foreign key(customer_number) references customers(customer_number),
check_number varchar(50) not null,
payment_date date not null,
amount float not null
);

create table products
(product_code varchar(15) primary key not null,
product_name varchar(70) not null,
product_line varchar(50), foreign key (product_line) references product_lines(product_line),
product_scale varchar(10) not null,
product_vendor varchar(50) not null,
product_description text not null,
quantity_in_stock int not null,
buy_price float not null,
msrp float not null 
);

create table order_details
(order_number int,
product_code varchar(15),
primary key(order_number,product_code),
foreign key (order_number) references orders(order_number),
foreign key (product_code) references products(product_code)
);