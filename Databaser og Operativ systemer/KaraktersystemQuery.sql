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
and er.bestået = 1
except
select distinct s.navn
from Eksamen e, EksamensResultat er, Studerende s
where e.eksamenID = er.EksamensID
and er.StuderendeCPR = s.cpr
and er.bestået = 0

-- Opgave 4.C
select distinct e.fag, avg(er.karakter) as Gennemsnitskarakter
from Eksamen e, EksamensResultat er, Studerende s
where e.eksamenID = er.EksamensID
and er.StuderendeCPR = s.cpr
and er.bestået = 1
group by e.fag

--------------------------
-- Opgave 5
go
drop proc IF EXISTS StuderendeBeståetEksamer
go
create proc StuderendeBeståetEksamer
@CPR char(10)
as
begin
select distinct s.navn, e.fag
from Eksamen e, EksamensResultat er, Studerende s
where e.eksamenID = er.EksamensID
and er.StuderendeCPR = s.cpr
and er.bestået = 1
and s.cpr = @CPR
end

execute StuderendeBeståetEksamer '0404801127'
execute StuderendeBeståetEksamer '0404801123'
go
-- Opgave 6

go
drop trigger IF EXISTS AlleredeBeståetEksamen
go
create trigger AlleredeBeståetEksamen on EksamensResultat
instead of insert 
as
declare @EkID int
declare @CPR char(10)
set @EkID = (select EksamensID from inserted)
set @CPR = (select StuderendeCPR from inserted)
begin
	if not exists
	(select er.bestået, er.StuderendeCPR
	from EksamensResultat er
	where er.bestået = 1
	and StuderendeCPR = @CPR
	and EksamensID = @EkID
	)
		begin
		insert into EksamensResultat
		select StuderendeCPR, karakter, bestået, EksamensID from inserted
		end
	else 
		begin
		raiserror('Du har allerede bestået dit fag!', 1, 1)
		end
end

insert into EksamensResultat values
('0404801123', 2, 1, 4)
--('0404801125', 12, 1, 2)

select * from EksamensResultat