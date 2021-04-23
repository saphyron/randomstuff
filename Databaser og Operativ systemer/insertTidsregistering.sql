--select navn, mobil from medarbejder where medlemsId = 2
--select * from Medlem order by alder

--1 --select navn, mobil from medarbejder
--2 --select navn, mobil from medarbejder where stillingsbetegnelse = 'Tester'
--3 --select * from Projekt where estimeretTimer <> 300
--4 --select * from Projekt where deadline > '2020-01-01'
--5 --select navn from Team

--select * from Medarbejder where navn like 'A%'
--select * from Medarbejder where navn like '__a%'
--select * from Medarbejder where medarbejderNr between 10 and 20

--select count(*) from Medlem
--select sum(alder) from Medlem
--select max(alder) from Medlem
--select min(alder) from Medlem
--select avg(alder) from Medlem
--select sum(alder) / count(*) from Medlem

--Lektion 02
--1 --
select min(estimeretTimer) as minimum from Projekt
--2 --
select max(estimeretTimer) as maximum from Projekt
--3 --
select count(*) as antal from Projekt
--4 --
select sum(estimeretTimer) as sum from Projekt
--5 --
select avg(estimeretTimer) as gennemsnit from Projekt
--6 --
select sum(estimeretTimer) / count(*) as gennemsnit from Projekt

-- Lektion 3
-- opgave 1
select count(*) as 'antal projekter'
from Projekt 

-- opgave 2
select navn, count(*) as antal
from Team t
inner join MedarbejderITeam mt
on t.teamId = mt.teamId
group by t.navn

-- opgave 3
select navn, sum(estimeretTimer) as timer
from Projekt p
inner join Team t
on t.teamId = p.teamId
group by t.navn

-- opgave 4
select ot.navn, count(*) as antal
from MedarbejderOpgavetype mot
inner join Opgavetype ot
on ot.typeId = mot.typeId
group by ot.navn

-- opgave 5
select m.navn, m.medarbejderNr
from Medarbejder m
inner join MedarbejderITeam mt
on mt.medarbejderNr = m.medarbejderNr
where mt.teamId = 3

-- opgave 6
select * from Medarbejder
order by stillingsbetegnelse

select m.stillingsbetegnelse, count(stillingsbetegnelse) as antal
from Medarbejder m
group by m.stillingsbetegnelse

--Lektion 4

--Opgave 01
select p.projektnavn, p.estimeretTimer
from Projekt p
where estimeretTimer = (select min(estimeretTimer)
from Projekt)

--Opgave 02
select m.navn
from Medarbejder m
where m.medarbejderNr in(select t.medarbejderNr
from Tidsregistering t)


--Opgave 03
select distinct navn
from Medarbejder m
inner join Tidsregistering t
on t.medarbejderNr = m.medarbejderNr

--Opgave 04
select distinct m.navn, o.opgaveNr, o.statusPaaOpgave, p.projektnavn
from Opgave o
inner join Projekt p
on p.projektNr = o.projektNr
inner join Tidsregistering t
on t.opgaveNr = o.opgaveNr
inner join Medarbejder m
on m.medarbejderNr = t.medarbejderNr

--Opgave 05
select distinct m.navn, o.statusPaaOpgave
from Medarbejder m, Opgave o, Tidsregistering t
where m.medarbejderNr = t.medarbejderNr
and t.opgaveNr = o.opgaveNr
and o.statusPaaOpgave = 'to do'

--Opgave 06
select o.statusPaaOpgave, count(*) as antal
from Opgave o
group by o.statusPaaOpgave

--Opgave 07
select count(p.projektNr) as antal
from Projekt p

select p.projektnavn, count(o.opgaveNr) as 'antal opgaver'
from Projekt p
inner join Opgave o
on p.projektNr = o.projektNr
where o.opgaveNr > 0
group by p.projektnavn

select p.projektnavn, count(o.opgaveNr) as 'antal opgaver'
from Projekt p
left join Opgave o
on p.projektNr = o.projektNr
group by p.projektnavn

--Opgave 08
select p.projektnavn, count(o.opgaveNr) as 'antal opgaver'
from Projekt p
inner join Opgave o
on p.projektNr = o.projektNr
group by p.projektnavn
having count(o.opgaveNr) > 6

--Lektion 05
--Opgave 01
select m.navn, m.mobil
from MedarbejderITeam mt, Medarbejder m, Team t
where mt.medarbejderNr = m.medarbejderNr
and mt.teamId = t.teamId
and t.navn = 'Team Alfa'
go

--Opgave 02
create view MedarbejderListe
as
select t.navn as teamnavn, m.navn, m.mobil
from MedarbejderITeam mt, Medarbejder m, Team t
where mt.medarbejderNr = m.medarbejderNr
and mt.teamId = t.teamId

select *
from MedarbejderListe

drop view MedarbejderListe

--Opgave 03
create view MedarbejderListeTeamAlfa
as
select t.navn as teamnavn, m.navn, m.mobil
from MedarbejderITeam mt, Medarbejder m, Team t
where mt.medarbejderNr = m.medarbejderNr
and mt.teamId = t.teamId
and t.navn = 'Team Alfa'

select *
from MedarbejderListeTeamAlfa

drop view MedarbejderListeTeamAlfa

--Opgave 04
create proc HentTeamListe
@TeamNavn varchar(20)
as
begin
select m.navn, m.mobil
from MedarbejderITeam mt, Medarbejder m, Team t
where mt.medarbejderNr = m.medarbejderNr
and mt.teamId = t.teamId
and t.navn = @TeamNavn
end

execute HentTeamListe 'Team Alfa'

--Opgave 05
drop proc HentMedarbejderMedBogstav
create proc HentMedarbejderMedBogstav
@Bogstav char(1)
as
begin
select m.navn
from Medarbejder m
where m.navn like @Bogstav + '%'
end

execute HentMedarbejderMedBogstav 'a'

--Opgave 06
drop table SlettetMedarbejder
create table SlettetMedarbejder(
medarbejderNr int primary key,
navn varchar(30),
stillingsbetegnelse varchar(30),
mobil char(10)
)

drop trigger HentMedlemUdenAtSlette
create trigger HentMedlemUdenAtSlette on Medarbejder
instead of delete
as
begin
insert into SlettetMedarbejder values
(medarbejderNr, navn, stillingsbetegnelse, mobil)
(select medarbejderNr, navn, stillingsbetegnelse, mobil from deleted)
end

delete Medarbejder
where medarbejderNr = 1

select *
from SlettetMedarbejder
select *
from Medarbejder
where medarbejderNr = 1

--Opgave 07
select distinct m.navn
from Medarbejder m
left outer join SlettetMedarbejder sm
on m.navn = sm.navn

select *
from Medarbejder m
where m.medarbejderNr not in
(select m.medarbejderNr from SlettetMedarbejder

select * from Medarbejder except
select * from SlettetMedarbejder

--Opgave 08
create view OpgaverDerErTidsregistreret
as
select o.opgaveNr, o.deadline, p.projektnavn, m.navn, t.datoRegistering
from Opgave o, Projekt p, Tidsregistering t, Medarbejder m
where p.projektNr = o.projektNr
and t.medarbejderNr = m.medarbejderNr
and t.opgaveNr = o.opgaveNr
and t.opgaveNr > 0

select *
from OpgaverDerErTidsregistreret

drop view OpgaverDerErTidsregistreret

--Opgave 09
create proc ListeOverTidsregistreringAfMedlem
@PersonNavne varchar(20)
as
begin
select o.opgaveNr, p.projektnavn, o.deadline, t.datoRegistering
from Opgave o, Projekt p, Tidsregistering t, Medarbejder m
where p.projektNr = o.projektNr
and t.medarbejderNr = m.medarbejderNr
and t.opgaveNr = o.opgaveNr
and m.navn = @PersonNavne
end

execute ListeOverTidsregistreringAfMedlem 'Jennifer Lawrence'

--Opgave 10
drop proc ListeOverAntalTimerAfMedlem
create proc ListeOverAntalTimerAfMedlem
@PersonNavnn varchar(20)
as
begin
select m.navn, sum(DATEDIFF(hour, starttid, sluttid)) as timer
from Medarbejder m, Tidsregistering t
where m.medarbejderNr = t.medarbejderNr
and m.navn = @PersonNavnn
group by m.navn
end

execute ListeOverAntalTimerAfMedlem 'Jennifer Lawrence'

--Opgave 11
drop trigger UdskriverAntalTimerRegistreret
create trigger UdskriverAntalTimerRegistreret on Tidsregistering
after insert
as
select cast(DATEDIFF(ss, starttid, sluttid)/60.0/60.0 as numeric(10, 2)) as timer
from inserted
go

--Lektion06 java opgave 04
create proc HentMedarbejderNavnMobil
as
begin
select navn, mobil from Medarbejder
end

select * from Tidsregistering

insert into Tidsregistering
values('08:00', '15:30', 'noget', '2019-05-19', 1, 1)


insert into Team values
(1, 'Team Alfa'),
(2, 'Team Beta'),
(3, 'Team Gamma'),
(4, 'Team Delta'),
(5, 'Team Epsilon')

insert into Opgavetype values
(1, 'Planlægning', 'Planlægning af en opgave'),
(2, 'Design', 'Design af en opgave'),
(3, 'Programmering', 'Programmering af en opgave'),
(4, 'Test', 'Test af en opgave')


--medarbejderNr int primary key,
--navn varchar(30),
--stillingsbetegnelse varchar(30),
--mobil char(10)
insert into Medarbejder values
(1,'Jennifer Lawrence', 'Systemudvikler', '32659874'),
(2,'Robert Downey Jr', 'Tester', '12365478'),
(3,'Leonardo DiCaprio', 'Systemudvikler', '12369854'),
(4,'Bradley Cooper', 'Tester', '78564578'),
(5,'Dwayne Johnson', 'Systemudvikler', '12121212'),
(6,'Tom Cruise', 'Systemdesigner', '12365498'),
(7,'Hugh Jackman', 'Systemudvikler', '78965412'),
(8,'Sandra Bullock', 'Tester', '12369874'),
(9,'Channing Tatum', 'Systemdesigner', '45632145'),
(10,'Scarlett Johansson', 'Systemudvikler', '42369854'),
(11,'Chris Pratt', 'Systemudvikler', '12365985'),
(12,'Tom Hanks', 'Systemudvikler', '12369874'),
(13,'Matt Damon', 'Tester', '12369875'),
(14,'Matthew McConaughey', 'Systemudvikler', '78965412'),
(15,'George Clooney', 'Systemudvikler', '11122365'),
(16,'Brad Pitt', 'Tester', '78569854'),
(17,'Angelina Jolie', 'Systemudvikler', '12365478'),
(18,'Liam Neeson', 'Systemdesigner', '78965412'),
(19,'Ben Affleck', 'Systemudvikler', '85236974'),
(20,'Chris Hemsworth', 'Systemudvikler', '12369854'),
(21,'Charlize Theron', 'Systemudvikler', '47852369'),
(22,'Denzel Washington', 'Systemudvikler', '36921478'),
(23,'Vin Diesel', 'Systemdesigner', '52369874'),
(24,'Melissa McCarthy', 'Systemdesigner', '12365474'),
(25,'Johnny Depp', 'Tester', '14785566'),
(26,'Will Smith', 'Systemudvikler', '44556677'),
(27,'Meryl Streep', 'Systemdesigner', '99663322'),
(28,'Christian Bale', 'Systemdesigner', '11447788'),
(29,'Mark Wahlberg', 'Systemdesigner', '78998745'),
(30,'Kevin Hart', 'Systemudvikler', '12121111'),
(31,'Jake Gyllenhaal', 'Systemdesigner', '44556689'),
(32,'Chris Evans', 'Tester', '15151515'),
(33,'Daniel Craig', 'Systemudvikler', '78787878'),
(34,'Shailene Woodley', 'Systemudvikler', '33669955'),
(35,'Emma Stone', 'Systemdesigner', '99999999'),
(36,'Benedict Cumberbatch', 'Systemdesigner', '88888888'),
(37,'Natalie Portman', 'Systemudvikler', '11111111'),
(38,'Jennifer Aniston', 'Systemudvikler', '77777777'),
(39,'Amy Schumer', 'Systemudvikler', '36547852'),
(40,'Ryan Gosling', 'Systemdesigner', '12365478'),
(41,'Zach Galifianakis', 'Systemdesigner', '12365478'),
(42,'Emily Blunt', 'Systemdesigner', '12365478'),
(43,'Anne Hathaway', 'Systemdesigner', '77445652'),
(44,'Michael Fassbender', 'Systemudvikler', '12365247'),
(45,'Chris Pine', 'Systemudvikler', '12365478'),
(46,'Cate Blanchett', 'Systemdesigner', '12365478'),
(47,'Seth Rogen', 'Systemdesigner', '12365475'),
(48,'Will Ferrell', 'Tester', '78541236'),
(49,'Ryan Reynolds', 'Systemudvikler', '45636978'),
(50,'Julia Roberts', 'Systemudvikler', '47852136')



--medarbejderNr int foreign key REFERENCES Medarbejder(medarbejderNr), 
--teamId char(10) foreign key REFERENCES Team(teamId)
insert into MedarbejderITeam values
(1,1),(2,3),(3,4),(4,1),(5,2),(6,5),(7,4),(8,1),(9,3),
(10,1),(11,1),(12,3),(13,4),(14,3),(15,4),(16,3),(17,1),(18,5),(19,3),
(20,1),(21,2),(22,2),(23,1),(24,2),(25,5),(26,2),(27,1),(28,4),(29,2),
(30,4),(31,1),(32,3),(33,1),(34,4),(35,1),(36,4),(37,2),(38,2),(39,2),
(40,5),(41,3),(42,4),(43,2),(44,5),(45,1),(46,3),(47,5),(48,1),(49,3),
(50,5)


--projektNr int primary key,
--projektnavn varchar(30),
--estimeretTimer int,
--deadline date,
--teamId char(10) foreign key references Team(teamId)
insert into Projekt values
(1, 'Projekt 1', 300, '2019-09-24', 1),
(2, 'Projekt 2', 300, '2019-09-24', 1),
(3, 'Projekt 3', 200, '2019-10-30', 2),
(4, 'Projekt 4', 50, '2019-06-06', 1),
(5, 'Projekt 5', 50, '2019-12-23', 4),
(6, 'Projekt 6', 40, '2019-05-01', 5),
(7, 'Projekt 7', 150, '2020-01-22', 3),
(8, 'Projekt 8', 100, '2020-02-13', 5),
(9, 'Projekt 9', 200, '2019-09-30', 2),
(10, 'Projekt 10', 60, '2019-12-01', 1),
(11, 'Projekt 11', 90, '2020-03-12', 1),
(12, 'Projekt 12', 110, '2020-02-02', 3),
(13, 'Projekt 13', 120, '2020-01-01', 2),
(14, 'Projekt 14', 240, '2020-02-20', 4),
(15, 'Projekt 15', 500, '2019-11-03', 5),
(16, 'Projekt 16', 210, '2019-10-05', 2),
(17, 'Projekt 17', 360, '2020-04-17', 1),
(18, 'Projekt 18', 400, '2019-10-28', 3),
(19, 'Projekt 19', 700, '2019-11-24', 3)


--medarbejderNr int foreign key REFERENCES Medarbejder(medarbejderNr), 
--typeId int foreign key REFERENCES Opgavetype(typeId)
--En Opgavertype
insert into MedarbejderOpgavetype values
(1,2),(2,1),(3,4),(4,3),(5,1),(6,4),(7,2),(8,3),(9,1),
(10,1),(11,2),(12,1),(13,4),(14,3),(15,1),(16,4),(17,2),(18,3),(19,1),
(20,4),(21,2),(22,1),(23,4),(24,3),(25,1),(26,4),(27,2),(28,3),(29,1),
(30,4),(31,2),(32,1),(33,4),(34,3),(35,1),(36,4),(37,2),(38,3),(39,1),
(40,4),(41,2),(42,1),(43,4),(44,3),(45,1),(46,4),(47,2),(48,3),(49,1),
(50,3)

--To Opgavetyper
insert into MedarbejderOpgavetype values
(1,3),(2,2),(3,1),(4,2),(5,2),(6,3),(7,1),(8,1),
(10,4),(11,3),(12,2),(13,1),(14,2),(16,1),(17,3),(18,1),(19,4),
(20,1),(21,4),(24,1),(25,2),(26,3),(27,4),(28,1),(29,3),
(32,2),(33,3),(34,1),(36,2),(37,3),
(40,2),(44,1),(46,3),(48,2),(49,4)

--Tre Opgavetyper
insert into MedarbejderOpgavetype values
(1,4),(2,3),(8,2),
(10,2),(14,4),(18,4),
(21,1),(24,4),
(32,3),(33,2),
(49,2)

--Fire Opgavetyper
insert into MedarbejderOpgavetype values
(1,1),
(32,4),
(49,3)


--opgaveNr int primary key,
--beskrivelse varchar(50),
--priotet int check (priotet in (1,2,3,4,5)),
--forventetStart date,
--deadline date,
--statusPaaOpgave char(7) check (statusPaaOpgave in ('To do', 'Igang', 'Færdig', 'Checked')),
--projektNr int foreign key references Projekt(projektNr),
--typeId int foreign key references Opgavetype(typeId)

--Projekt 1
--(1, 'Projekt 1', 300, '2019-09-24', 1)
insert into Opgave values
(1, 'Planlægningopgave', 1, '2019-08-01', '2019-08-05', 'Færdig', 1, 1),
(2, 'Designopgave', 1, '2019-08-05', '2019-08-09', 'Igang', 1, 2),
(3, 'Programmeringsopgave', 2, '2019-09-03', '2019-09-18', 'To do', 1, 3),
(4, 'Programmeringsopgave', 1, '2019-09-01', '2019-09-17', 'To do', 1, 3),
(5, 'Programmeringsopgave', 2, '2019-09-01', '2019-09-16', 'To do', 1, 3),
(6, 'Testopgave', 1, '2019-09-18', '2019-09-24', 'To do', 1, 4)

--Projekt 2
--(2, 'Projekt 2', 300, '2019-09-24', 1)
insert into Opgave values
(7, 'Planlægningopgave', 1, '2019-08-01', '2019-08-05', 'Færdig', 2, 1),
(8, 'Designopgave', 1, '2019-08-05', '2019-08-09', 'Igang', 2, 2),
(9, 'Programmeringsopgave', 2, '2019-09-03', '2019-09-18', 'To do', 2, 3),
(10, 'Programmeringsopgave', 1, '2019-09-01', '2019-09-17', 'To do', 2, 3),
(11, 'Programmeringsopgave', 2, '2019-09-01', '2019-09-16', 'To do', 2, 3),
(12, 'Testopgave', 1, '2019-09-18', '2019-09-24', 'To do', 2, 4),
(13, 'Testopgave', 2, '2019-09-18', '2019-09-24', 'To do', 2, 4)

--Projekt 3
--(3, 'Projekt 3', 200, '2019-10-30', 2)
insert into Opgave values
(14, 'Planlægningopgave', 1, '2019-09-01', '2019-09-05', 'To do', 3, 1),
(15, 'Designopgave', 1, '2019-09-05', '2019-09-09', 'To do', 3, 2),
(16, 'Programmeringsopgave', 2, '2019-10-03', '2019-10-18', 'To do', 3, 3),
(17, 'Programmeringsopgave', 1, '2019-10-01', '2019-10-17', 'To do', 3, 3),
(18, 'Programmeringsopgave', 2, '2019-10-01', '2019-10-16', 'To do', 3, 3),
(19, 'Testopgave', 1, '2019-10-18', '2019-10-30', 'To do', 3, 4),
(20, 'Testopgave', 2, '2019-10-18', '2019-10-30', 'To do', 3, 4)

--Projekt 4
--(4, 'Projekt 4', 50, '2019-06-06', 1)
insert into Opgave values
(21, 'Planlægningopgave', 1, '2019-04-01', '2019-04-18', 'Færdig', 4, 1),
(22, 'Designopgave', 1, '2019-04-19', '2019-04-30', 'Færdig', 4, 2),
(23, 'Programmeringsopgave', 2, '2019-05-01', '2019-05-22', 'Checked', 4, 3),
(24, 'Programmeringsopgave', 1, '2019-05-01', '2019-06-01', 'Checked', 4, 3),
(25, 'Testopgave', 1, '2019-06-01', '2019-06-06', 'Checked', 4, 4)

--Projekt 5
--(5, 'Projekt 5', 50, '2019-12-23', 4)
insert into Opgave values
(26, 'Planlægningopgave', 2, '2019-08-23', '2019-09-01', 'Igang', 5, 1),
(27, 'Designopgave', 2, '2019-09-01', '2019-09-30', 'To do', 5, 2),
(28, 'Programmeringsopgave', 1, '2019-10-03', '2019-10-18', 'To do', 5, 3),
(29, 'Programmeringsopgave', 2, '2019-10-18', '2019-10-30', 'To do', 5, 3),
(30, 'Programmeringsopgave', 3, '2019-11-01', '2019-11-30', 'To do', 5, 3),
(31, 'Testopgave', 1, '2019-12-01', '2019-12-23', 'To do', 5, 4),
(32, 'Testopgave', 5, '2019-12-03', '2019-12-23', 'To do', 5, 4)

--Projekt 6
--(6, 'Projekt 6', 40, '2019-05-01', 5)
insert into Opgave values
(33, 'Planlægningopgave', 1, '2019-03-01', '2019-03-18', 'Færdig', 6, 1),
(34, 'Designopgave', 1, '2019-03-19', '2019-03-30', 'Færdig', 6, 2),
(35, 'Programmeringsopgave', 2, '2019-04-01', '2019-04-22', 'Checked', 6, 3),
(36, 'Programmeringsopgave', 1, '2019-04-01', '2019-04-29', 'Checked', 6, 3),
(37, 'Testopgave', 1, '2019-04-01', '2019-05-01', 'Checked', 6, 4)


--Projekt 7
--(7, 'Projekt 7', 150, '2020-01-22', 3)
insert into Opgave values
(38, 'Planlægningopgave', 1, '2019-11-23', '2019-12-01', 'To do', 6, 1)

--Projekt 8
--(8, 'Projekt 8', 100, '2020-02-13', 5)
insert into Opgave values
(39, 'Planlægningopgave', 1, '2020-01-02', '2020-01-05', 'Igang', 7, 1)


--starttid time,
--sluttid time,
--beskrivelseAfArbejde varchar(100),
--datoRegistering date,
--medarbejderNr int foreign key REFERENCES Medarbejder(medarbejderNr), 
--opgaveNr int foreign key references Opgave(opgaveNr)

insert into Tidsregistering values
('8:30', '16:00', 'Godt arbejde', '2019-08-01', 1, 1)

insert into Tidsregistering values
('8:30', '16:00', 'Godt arbejde', '2019-08-02', 1, 1),
('8:30', '16:00', 'Godt arbejde', '2019-08-03', 1, 1),
('8:30', '16:00', 'Godt arbejde', '2019-08-04', 1, 1)

insert into Tidsregistering values
('8:30', '16:00', 'Godt arbejde', '2019-08-02', 4, 2),
('8:30', '16:00', 'Godt arbejde', '2019-08-05', 4, 2),
('8:30', '16:00', 'Godt arbejde', '2019-08-06', 4, 2),
('8:00', '16:00', 'Godt arbejde', '2019-08-07', 4, 2)

insert into Tidsregistering values
('8:30', '16:00', 'Godt arbejde', '2019-08-02', 2, 3),
('8:30', '16:00', 'Godt arbejde', '2019-08-05', 2, 3),
('8:30', '16:00', 'Godt arbejde', '2019-08-06', 9, 3),
('8:00', '16:00', 'Godt arbejde', '2019-08-07', 9, 3)




