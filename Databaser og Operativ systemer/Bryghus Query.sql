--Opgave 2.a
select pa.Navn, pl.Navn, p.Pris
from ProduktAlkohol pa, Prisliste pl, Pris p
where pa.id = p.ProduktID
and pl.Navn = p.Prisliste
and pa.id = 1

--Opgave 2.b
select k.Navn, kv.id, SUM(p.Pris * kl.Antal * kl.SpecialaftaltRabat) as Rabat
from Kunde k, Kvittering kv, Kvitteringslinje kl, PrisKvitteringslinje pkl, Pris p, Prisliste pl, ProduktAlkohol pa
where k.KundeNummer = kv.Kunde
and kv.id = kl.KvitteringID
and kl.id = pkl.KvitteringslinjeID
and pkl.PrisID = p.id
and pl.Navn = p.Prisliste
and p.ProduktID = pa.id
group by k.Navn, kv.id

--Opgave 2.c
select k.Navn, kv.id, SUM(p.Pris * kl.Antal * (1 - kl.SpecialaftaltRabat)) as NettoPris
from Kunde k, Kvittering kv, Kvitteringslinje kl, PrisKvitteringslinje pkl, Pris p, Prisliste pl, ProduktAlkohol pa
where k.KundeNummer = kv.Kunde
and kv.id = kl.KvitteringID
and kl.id = pkl.KvitteringslinjeID
and pkl.PrisID = p.id
and pl.Navn = p.Prisliste
and p.ProduktID = pa.id
group by k.Navn, kv.id

--Opgave 2.d
select pa.Navn, SUM(kl.Antal) as Antal
from Kunde k, Kvittering kv, Kvitteringslinje kl, PrisKvitteringslinje pkl, Pris p, Prisliste pl, ProduktAlkohol pa
where k.KundeNummer = kv.Kunde
and kv.id = kl.KvitteringID
and kl.id = pkl.KvitteringslinjeID
and pkl.PrisID = p.id
and pl.Navn = p.Prisliste
and p.ProduktID = pa.id
and kl.Antal > 5
group by pa.Navn

--Opgave 2.e
select pt.Typenavn, pa.Navn
from Pris p, Prisliste pl, ProduktAlkohol pa, Produkttype pt
where p.ProduktID = pa.id
and p.Prisliste = pl.Navn
and pa.Produkttype = pt.id
and p.Prisliste not in('Fredags Bar')

--Opgave 2.f
select AVG(NettoPris) as Gennemsnidt
from (
select k.Navn, kv.id, SUM(p.Pris * kl.Antal * (1 - kl.SpecialaftaltRabat)) as NettoPris
from Kunde k, Kvittering kv, Kvitteringslinje kl, PrisKvitteringslinje pkl, Pris p, Prisliste pl, ProduktAlkohol pa
where k.KundeNummer = kv.Kunde
and kv.id = kl.KvitteringID
and kl.id = pkl.KvitteringslinjeID
and pkl.PrisID = p.id
and pl.Navn = p.Prisliste
and p.ProduktID = pa.id
group by k.Navn, kv.id
) as inner_query

--Opgave 3
go
drop view if exists ProduktSalgsInformation
go
create view ProduktSalgsInformation
as
select pl.Navn as ProduktType, pt.Typenavn, pa.Navn, isnull(kl.Antal, 0) as Antal
from ProduktAlkohol pa
left join Produkttype pt
on pa.Produkttype = pt.id
left join Pris p
on p.ProduktID = pa.id
left join PrisKvitteringslinje pkl
on pkl.PrisID = p.id
left join Kvitteringslinje kl
on kl.id = pkl.KvitteringslinjeID
inner join Prisliste pl
on pl.Navn = p.Prisliste


select *
from ProduktSalgsInformation psi
order by psi.ProduktType

--Opgave 4.a
go
drop proc if exists EnSalgssituation
go
create proc EnSalgssituation
@SalgsSituation varchar(30)
as
begin
select pa.Navn, p.Pris
from Pris p, Prisliste pl, ProduktAlkohol pa
where pl.Navn = p.Prisliste
and p.ProduktID = pa.id
and pl.Navn = @SalgsSituation
end

execute EnSalgssituation 'Fredags Bar'

--Opgave 4.b
go
drop proc if exists RabatPÂProduktType
go
create proc RabatPÂProduktType
@ProduktType varchar(30),
@Rabatsats float
as
begin
update Pris
set Pris = Pris * (1 - @Rabatsats)
from Produkttype pt, ProduktAlkohol pa, Pris p
where pt.id = pa.Produkttype
and pa.id = p.ProduktID
and pt.Typenavn = @ProduktType
end

select pt.Typenavn, pa.Navn, p.Pris
from Produkttype pt, ProduktAlkohol pa, Pris p
where pt.id = pa.Produkttype
and pa.id = p.ProduktID
and pt.Typenavn = 'Kulsyre'
execute RabatPÂProduktType 'Kulsyre', 0.2
select pt.Typenavn, pa.Navn, p.Pris
from Produkttype pt, ProduktAlkohol pa, Pris p
where pt.id = pa.Produkttype
and pa.id = p.ProduktID
and pt.Typenavn = 'Kulsyre'

--Opgave 5
go
drop trigger if exists SletProduktType
go
create trigger SletProduktType on ProduktAlkohol
after delete
as 
declare @id int = (select d.Produkttype from deleted d, Produkttype pt where pt.id = d.Produkttype)
begin
	if not exists
	(select *
	from ProduktAlkohol pa
	where pa.Produkttype = @id
	)
		begin
		delete from Produkttype
		where id = @id
		end
end
go
drop proc if exists SletProdukt
go
create proc SletProdukt
@id int
as
begin
delete from Pris
where ProduktID = @id
delete from ProduktAlkohol
where @id = id
end

select pt.Typenavn, pa.Navn, pa.id
from ProduktAlkohol pa, Produkttype pt
where pa.Produkttype = pt.id
and pt.Typenavn = 'Malt'
execute SletProdukt 22
select pt.Typenavn, pa.Navn, pa.id
from ProduktAlkohol pa, Produkttype pt
where pa.Produkttype = pt.id
and pt.Typenavn = 'Malt'
select pt.Typenavn
from Produkttype pt


--Opgave 6
-- Se Eclipse