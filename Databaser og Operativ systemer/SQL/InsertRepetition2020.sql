insert into Supplier values
(1, 'Primus', 'Billund', '999999999'),
(2, 'xlmoto', 'København', '888888888'),
(3, 'Profil', 'Aarhus', '777777777'),
(4, 'FixFix', 'København', '666666666'),
(5, 'FixFax', 'Aarhus', '555555555')


insert into Product values
(1, 'Sav', 100.0, 1),
(2, 'Hammer', 50.0, 1),
(3, 'Skrutrækker', 20.5, 1),
(4, 'Søm', 0.5, 1),
(5, 'Skruer', 1.5, 1)

insert into Product values
(6, 'Sav', 120.0, 2),
(7, 'Hammer', 40.0, 2),
(8, 'Skrutrækker', 15.0, 2),
(9, 'Søm', 0.4, 2),
(10, 'Skruer', 1.3, 2)

insert into Product values
(11, 'Sav', 110.0, 3),
(12, 'Hammer', 75.0, 3),
(13, 'Skrutrækker', 30.0, 3),
(14, 'Søm', 0.3, 3)

insert into Product values
(15, 'Skrutrækker', 15.0, 4),
(16, 'Søm', 0.4, 4),
(17, 'Skruer', 1.3, 4)

insert into Product values
(18, 'Sav', 90.0, 5),
(19, 'Søm', 1.4, 5),
(20, 'Skruer', 1.0, 5)

insert into Customer values
(1, 'Jens Jensen', 'Aarhus', '123456789'),
(2, 'Ulla Petersen', 'Aarhus', '987654321'),
(3, 'Finn Holgersen', 'København', '999888777'),
(4, 'Ib Hansen', 'København', '444433333'),
(5, 'Kim Nielsen', 'Aarhus', '123451234')

insert into Order_T values
(1, '2020-03-10', 1),
(2, '2020-02-12', 1),
(3, '2020-01-31', 2),
(4, '2020-03-09', 2),
(5, '2020-02-29', 3),
(6, '2020-01-03', 1),
(7, '2020-03-01', 4)

insert into OrderItem values
(1, 2, 1, 1),
(2, 10, 1, 17),
(3, 10, 1, 10)

insert into OrderItem values
(4, 2, 2, 1),
(5, 1, 2, 6),
(6, 10, 2, 17),
(7, 10, 2, 20)

insert into OrderItem values
(8, 1, 3, 2)

insert into OrderItem values
(9, 1, 4, 1),
(10, 1, 4, 2),
(11, 1, 4, 3),
(12, 1, 4, 4)

insert into OrderItem values
(13, 1, 5, 4),
(14, 2, 5, 5),
(15, 3, 5, 6)

insert into OrderItem values
(16, 20, 6, 4),
(17, 20, 6, 20)

insert into OrderItem values
(18, 20, 7, 4),
(19, 20, 7, 20),
(20, 1, 7, 18),
(21, 2, 7, 15),
(22, 3, 7, 6)




orderItemID int primary key,
quantity int,
orderID int foreign key references Order_T(orderID),
prodID int foreign key references Product(prodID) 
