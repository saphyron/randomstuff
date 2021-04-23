drop table A;
drop table B;

create table A(
tal int primary key
);

create table B(
tal int primary key
);

insert into A values
(102),
(104),
(106),
(107);

insert into B values
(101),
(102),
(104),
(106),
(108);

select A.tal, B.tal
from A
cross join B

select A.tal, B.tal
from A, B

select A.tal, B.tal
from A
join B
on A.tal =  B.tal;

select A.tal, B.tal
from A, B
where A.tal = B.tal;


select A.tal, B.tal
from A
right outer join B
on A.tal = B.tal;

select A.tal, B.tal
from A
left join B
on A.tal = B.tal;

select A.tal, B.tal
from A
full join B
on A.tal = B.tal;