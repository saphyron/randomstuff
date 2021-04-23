drop table OrderItem
drop table Order_T
drop table Customer
drop table Product
drop table Supplier

create table Supplier(
suppID int primary key,
compName varchar(30), 
city varchar(30),
phone varchar(10)
)

create table Product(
prodID int primary key,
prodName varchar(30),
unitPrice decimal(7,2),
suppID int foreign key references Supplier(suppID) 
)

create table Customer(
customerID int primary key,
customerName varchar(30),
city varchar(30),
phone varchar(10)
)

create table Order_T(
orderID int primary key,
orderDate date,
customerID int foreign key references Customer(customerID) 
)

create table OrderItem(
orderItemID int primary key,
quantity int,
orderID int foreign key references Order_T(orderID),
prodID int foreign key references Product(prodID) 
)