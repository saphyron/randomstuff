drop table a
drop table b

create table a(
tal int primary key
);

create table b(
tal int primary key
);

insert into A values
(102),
(104),
(106),
(107)

insert into B values
(101),
(102),
(104),
(106),
(108)

select a.tal, b.tal
from A
cross join B

select a.tal, b.tal
from A, B

select a.tal, b.tal
from A
join B
on A.tal = B.tal

select A.tal, B.tal
from A, B
where A.tal = B.tal

select a.tal, b.tal
from A
right outer join B
where A.tal = B.tal

select a.tal, b.tal
from A
left join B
where A.tal = B.tal

select a.tal, b.tal
from A
full join B
on A.tal = B.tal