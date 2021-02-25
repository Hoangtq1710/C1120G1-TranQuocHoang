use session_02;
create table customers
(customer_number int auto_increment primary key,
fullname varchar(255) ,
address varchar(255),
email varchar(255),
phone varchar(255)
);
create table accounts
(account_number int primary key not null,
customer_number int,
account_type varchar(255),
date_account date,
balance double,
foreign key (customer_number) references customers(customer_number)
);
create table transactions
(tran_number int primary key not null,
account_number int,
tran_date date,
amounts int,
descriptions varchar(255),
 foreign key (account_number) references accounts(account_number)
);