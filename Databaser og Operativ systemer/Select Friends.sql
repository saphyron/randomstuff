--Opgave03
select se.SerieID, sk.Navn
from Skuespiller sk, Serie se, Episode e, Sæson sæ, SkuespillerEpisode ske
where sæ.SerieID = se.SerieID
and sæ.SæsonID = e.SæsonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and se.SerieID = 1
group by se.SerieID, sk.Navn

--Opgave04
select se.Title, count(distinct sk.Navn) as antal
from Skuespiller sk, Serie se, Episode e, Sæson sæ, SkuespillerEpisode ske
where sæ.SerieID = se.SerieID
and sæ.SæsonID = e.SæsonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
group by se.Title

--Opgave05
drop view SkuespillerNavn
create view SkuespillerNavn
as
select sæ.Sæsonnummer, sk.Navn
from Skuespiller sk, Serie se, Episode e, Sæson sæ, SkuespillerEpisode ske
where sæ.SerieID = se.SerieID
and sæ.SæsonID = e.SæsonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and se.SerieID = 1
group by sæ.Sæsonnummer, sk.Navn

select *
from SkuespillerNavn

--Opgave06
drop proc SkuespillerListe
create proc SkuespillerListe
@SæsonNr int,
@SerieNavn varchar(80)
as
begin
select distinct sk.Navn
from Skuespiller sk, Serie se, Episode e, Sæson sæ, SkuespillerEpisode ske
where sæ.SerieID = se.SerieID
and sæ.SæsonID = e.SæsonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and sæ.Sæsonnummer = @SæsonNr
and se.Title = @SerieNavn
end

execute SkuespillerListe 1, 'Mulon Ruoge 2.0'

--Opgave 07
drop proc SerieLængde
create proc SerieLængde
@Serie varchar(80)
as
begin
select distinct se.Title , sum(e.Længde) as 'Serie Længde'
from Skuespiller sk, Serie se, Episode e, Sæson sæ, SkuespillerEpisode ske 
where sæ.SerieID = se.SerieID
and sæ.SæsonID = e.SæsonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and se.Title = @Serie
group by se.Title
end

execute SerieLængde 'Mulon Ruoge 2.0'

--Opgave 08
drop proc SæsonLængde
create proc SæsonLængde
@Serie varchar(80)
as
begin
select sæ.Sæsonnummer, sum(e.Længde) as 'Sæson Længde'
from Skuespiller sk, Serie se, Episode e, Sæson sæ, SkuespillerEpisode ske 
where sæ.SerieID = se.SerieID
and sæ.SæsonID = e.SæsonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and se.Title = @Serie
group by sæ.Sæsonnummer
end

execute SæsonLængde 'Mulon Ruoge 2.0'

--Opgave 09
go
drop view ViewAfSæsonLængde
go
create view ViewAfSæsonLængde
as
select se.Title, sæ.Sæsonnummer, sum(e.Længde) as Længde
from Skuespiller sk, Serie se, Episode e, Sæson sæ, SkuespillerEpisode ske 
where sæ.SerieID = se.SerieID
and sæ.SæsonID = e.SæsonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
group by se.Title, sæ.Sæsonnummer

select *
from ViewAfSæsonLængde

--Opgave 10
drop proc SæsonLængde2
create proc SæsonLængde2
@Serie varchar(80),
@Sæson int
as
begin
select distinct se.Title , sum(e.Længde) as 'Sæson Længde'
from Skuespiller sk, Serie se, Episode e, Sæson sæ, SkuespillerEpisode ske 
where sæ.SerieID = se.SerieID
and sæ.SæsonID = e.SæsonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and se.Title = @Serie
and sæ.Sæsonnummer = @Sæson
group by se.Title
end

execute SæsonLængde2 'Mulon Ruoge 2.0', 1

--Opgave 11 Se Eclipse
--Opgave 12
drop proc SkueSpillersAlder
create proc SkueSpillersAlder
@Skuespiller varchar(20)
as
begin
select sk.Navn, DATEDIFF(year, sk.Fødselsår, GETDATE())
from Skuespiller sk
where sk.Navn = @Skuespiller
end

--Opgave 13 se Eclipse