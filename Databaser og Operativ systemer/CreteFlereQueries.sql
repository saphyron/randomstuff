select cpr, navn
from AnsatIVirkA
union all
select cpr, Concat(fornavn, ' ', efternavn)
from AnsatIVirkB

select cpr, navn
from AnsatIVirkA
union
select cpr, Concat(fornavn, ' ', efternavn)
from AnsatIVirkB

select cpr, navn
from AnsatIVirkA
intersect
select cpr, Concat(fornavn, ' ', efternavn)
from AnsatIVirkB

select cpr, navn
from AnsatIVirkA
except
select cpr, Concat(fornavn, ' ' + efternavn)
from AnsatIVirkB

select cpr, navn
from Person
except
select cpr, CONCAT(fornavn, ' ' + efternavn)
from AnsatIVirkB
except
select cpr, navn
from AnsatIVirkA

select cpr, navn
from Person
except
(select cpr, CONCAT(fornavn, ' ' + efternavn)
from AnsatIVirkB
union
select cpr, navn
from AnsatIVirkA)

create table Person(
cpr char(10) primary key,
navn varchar(30),
adresse varchar(50)
)

create table AnsatIVirkA(
cpr char(10) primary key,
navn varchar(40),
stilling varchar(30)
)

create table AnsatIVirkB(
cpr char(10) primary key,
fornavn varchar(20),
efternavn varchar(30),
stilling varchar(30)
)

insert into Person values
('8908099876', 'Ulla Petersen', 'Æblevej 88'),
('6703259809', 'Lars Høj', 'Pærevej 89'),
('5512120987', 'Fin Andersen', 'Appelsingade 67'),
('9001019276', 'Kim Jensen', 'Skov Alle 1'),
('8812240983', 'Kirsten Hansen', 'Vestergade 9'),
('7804301234', 'Bo Nielsen', 'Søndergade 67'),
('6708083456', 'Mark Mark', 'Ananasgade 34'),
('9804059845', 'Mike Larsen', 'Aarhus vej 3'),
('4409098378', 'Pia Poulsen ', 'Spanien 4'),
('7601302638', 'Inge Skov', 'Gladgade 33')


insert into AnsatIVirkA values
('8908099876', 'Ulla Petersen', 'Chef'),
('6703259809', 'Lars Høj', 'Over Chef'),
('5512120987', 'Fin Andersen', 'Den der laver noget'),
('9001019276', 'Kim Jensen', 'Chef')

insert into AnsatIVirkB values
('9001019276', 'Kim', 'Jensen', 'Ansat'),
('8812240983', 'Kirsten', 'Hansen', 'Ansat'),
('7804301234', 'Bo',  'Nielsen', 'Chef'),
('6708083456', 'Mark', 'Mark', 'Chefen'),
('9804059845', 'Mike', 'Larsen', 'Ansat')