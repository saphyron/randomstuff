--select * from Klub
--select * from Hold
--select * from Medlem
--select * from HoldMedlem
--update Medlem set navn = 'Lars' where medlemsId = 2
--delete from HoldMedlem where medlemsId = 2
--select navn, alder from Medlem where medlemsId = 2
--select * from Medlem order by alder

select navn, alder
from Medlem
where alder = (select min(alder)
from Medlem)

select navn, alder
from Medlem
where alder > (select avg(alder)
from Medlem)

select navn, alder
from Medlem
where alder > (select sum(alder) / count(alder)
from Medlem)

select h.holdNavn, avg(m.alder) as alder
from Medlem m
inner join HoldMedlem hm
on hm.medlemsId = m.medlemsId
inner join hold h
on hm.holdId = h.holdId
group by h.holdNavn

select h.holdNavn, avg(m.alder) as alder
from Medlem m
inner join HoldMedlem hm
on hm.medlemsId = m.medlemsId
inner join hold h
on hm.holdId = h.holdId
group by h.holdNavn
having avg(m.alder) > 17

select h.holdId, h.holdNavn, count(hm.holdId) as antal
from Medlem m
inner join HoldMedlem hm
on hm.medlemsId = m.medlemsId
inner join hold h
on hm.holdId = h.holdId
group by h.holdNavn, h.holdId
order by holdNavn

select h.holdNavn, (select count(hm.holdId)
from HoldMedlem hm 
where h.holdId = hm.holdId) as antal
from Hold h
order by holdNavn

--insert HoldMedlem values (2, 6)

select distinct m.navn, hm.medlemsId
from HoldMedlem hm, Medlem m, HoldMedlem hm2
where hm.medlemsId = hm2.medlemsId
and hm.holdId != hm2.holdId
and hm.medlemsId = m.medlemsId

select hm.holdId ,m.navn, hm.medlemsId
from HoldMedlem hm, Medlem m, HoldMedlem hm2
where hm.medlemsId = hm2.medlemsId
and hm.holdId != hm2.holdId
and hm.medlemsId = m.medlemsId

select m.navn, m.medlemsId
from Medlem m
where m.medlemsId in(select hm.medlemsId
from HoldMedlem hm, HoldMedlem hm2
where hm.holdId != hm2.holdId
and hm.medlemsId = hm2.medlemsId)

insert into Klub values
('KIF', 'test1'),
('ABK', 'test2'),
('SU', 'test3'),
('TFB', 'test4'),
('FCB', 'test5')

insert into Hold values
(1, 'U12 Piger', 11, 'KIF'),
(2, '2. Holdet', 14, 'KIF'),
(3, 'U14 Drenge', 13, 'ABK'),
(4, 'U10 Piger', 14, 'ABK'),
(5, '1. Holdet', 9, 'ABK'),
(6, '2. Holdet', 14, 'SU'),
(7, 'U8 Drenge', 7, 'SU'),
(8, '2. Holdet', 9, 'TFB'),
(9, 'U10 Piger', 11, 'TFB'),
(10, '1. Holdet', 14, 'TFB'),
(11, 'U14 Drenge', 7, 'FCB'),
(12, 'U12 Piger', 8, 'FCB')

insert into Medlem values
(1, 'Peter', 35),
(2, 'Jens', 8),
(3, 'Ulla', 9),
(4, 'Kim', 10),
(5, 'Fin', 12),
(6, 'Bente', 14),
(7, 'Pia', 15),
(8, 'Karen', 28),
(9, 'Lise', 27)


insert into Medlem values
(10, 'Ole', 10),
(11, 'Niels', 11),
(12, 'Åse', 7),
(13, 'Tina', 16),
(14, 'Lene', 19),
(15, 'Erik', 12),
(16, 'Ron', 14),
(17, 'Ryan', 15),
(18, 'Arie', 18),
(19, 'Andres', 56)


insert into Medlem values
(20, 'Arne', 14),
(21, 'Bob', 21),
(22, 'Alice', 7),
(23, 'Bo', 10),
(24, 'Dennis', 18),
(25, 'Allan', 16),
(26, 'Rikke', 14),
(27, 'Pernille', 45),
(28, 'Rasmus', 42),
(29, 'Hans', 13)

insert into HoldMedlem values
(10,1),
(7,2),
(9,3),
(7,4),
(11,5),
(1,6),
(5,7),
(5,8),
(5,9)

insert into HoldMedlem values
(7,10),
(7,11),
(9,12),
(6,13),
(6,14),
(11,15),
(11,16),
(10,17),
(10,18),
(10,19)

insert into HoldMedlem values
(11,20),
(2,21),
(4,22),
(7,23),
(2,24),
(2,25),
(8,26),
(8,27),
(11,28),
(11,29)

