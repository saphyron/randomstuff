drop table if exists Reserves
drop table if exists Sailors
drop table if exists Boats
create table Sailors(
said int primary key,
sname varchar(20),
rating int,
age int
)
create table Boats(
bid int primary key,
bname varchar(20),
color varchar(10)
)
create table Reserves(
said int FOREIGN KEY REFERENCES sailors(said),
bid int FOREIGN KEY REFERENCES boats(bid),
dag date
)


