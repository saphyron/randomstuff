drop table DataTyperRep;

create table DataTyperRep(
id int primary key,
navn varchar(20) default 'Et godt navn',
navn2 varchar(20) unique,
postnummer char(4) check (postnummer in ('8000', '8200', '8300')),
alder int check (alder > 20),
tid time,
dato date,
pris decimal (7,2),
Boolean bit,
Boolean2 char(1),
lilleTal tinyint not null
)

insert into DataTyperRep values
(1, 'Rikke', 'Ib', '8000', 34, '22:22', '2018-12-12', 222.50, 1,'1', 39)

insert into DataTyperRep values
(2, 'Rikke', 'bo', '8000', 34, '22:22', '2018-12-12', 222.50, 'false','1', 39)

insert into DataTyperRep (id, navn2, lilleTal) values
(3, 'ulla', 39)

select * from DataTyperRep