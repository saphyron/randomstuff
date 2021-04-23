-- Opgave 4.A
select distinct s.navn
from Eksamen e, EksamensResultat er, Studerende s
where e.eksamenID = er.EksamensID
and er.StuderendeCPR = s.cpr
and er.karakter = 12

-- Opgave 4.B
select distinct s.navn
from Eksamen e, EksamensResultat er, Studerende s
where e.eksamenID = er.EksamensID
and er.StuderendeCPR = s.cpr
and er.best�et = 1
except
select distinct s.navn
from Eksamen e, EksamensResultat er, Studerende s
where e.eksamenID = er.EksamensID
and er.StuderendeCPR = s.cpr
and er.best�et = 0

-- Opgave 4.C
select distinct e.fag, avg(er.karakter) as Gennemsnitskarakter
from Eksamen e, EksamensResultat er, Studerende s
where e.eksamenID = er.EksamensID
and er.StuderendeCPR = s.cpr
and er.best�et = 1
group by e.fag

--------------------------
-- Opgave 5
go
drop proc IF EXISTS StuderendeBest�etEksamer
go
create proc StuderendeBest�etEksamer
@CPR char(10)
as
begin
select distinct s.navn, e.fag
from Eksamen e, EksamensResultat er, Studerende s
where e.eksamenID = er.EksamensID
and er.StuderendeCPR = s.cpr
and er.best�et = 1
and s.cpr = @CPR
end

execute StuderendeBest�etEksamer '0404801127'
execute StuderendeBest�etEksamer '0404801123'
go
-- Opgave 6

go
drop trigger IF EXISTS AlleredeBest�etEksamen
go
create trigger AlleredeBest�etEksamen on EksamensResultat
instead of insert 
as
declare @EkID int
declare @CPR char(10)
set @EkID = (select EksamensID from inserted)
set @CPR = (select StuderendeCPR from inserted)
begin
	if not exists
	(select er.best�et, er.StuderendeCPR
	from EksamensResultat er
	where er.best�et = 1
	and StuderendeCPR = @CPR
	and EksamensID = @EkID
	)
		begin
		insert into EksamensResultat
		select StuderendeCPR, karakter, best�et, EksamensID from inserted
		end
	else 
		begin
		raiserror('Du har allerede best�et dit fag!', 1, 1)
		end
end

insert into EksamensResultat values
('0404801123', 2, 1, 4)
--('0404801125', 12, 1, 2)

select * from EksamensResultat