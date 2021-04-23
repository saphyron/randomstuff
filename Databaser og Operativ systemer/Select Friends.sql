--Opgave03
select se.SerieID, sk.Navn
from Skuespiller sk, Serie se, Episode e, S�son s�, SkuespillerEpisode ske
where s�.SerieID = se.SerieID
and s�.S�sonID = e.S�sonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and se.SerieID = 1
group by se.SerieID, sk.Navn

--Opgave04
select se.Title, count(distinct sk.Navn) as antal
from Skuespiller sk, Serie se, Episode e, S�son s�, SkuespillerEpisode ske
where s�.SerieID = se.SerieID
and s�.S�sonID = e.S�sonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
group by se.Title

--Opgave05
drop view SkuespillerNavn
create view SkuespillerNavn
as
select s�.S�sonnummer, sk.Navn
from Skuespiller sk, Serie se, Episode e, S�son s�, SkuespillerEpisode ske
where s�.SerieID = se.SerieID
and s�.S�sonID = e.S�sonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and se.SerieID = 1
group by s�.S�sonnummer, sk.Navn

select *
from SkuespillerNavn

--Opgave06
drop proc SkuespillerListe
create proc SkuespillerListe
@S�sonNr int,
@SerieNavn varchar(80)
as
begin
select distinct sk.Navn
from Skuespiller sk, Serie se, Episode e, S�son s�, SkuespillerEpisode ske
where s�.SerieID = se.SerieID
and s�.S�sonID = e.S�sonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and s�.S�sonnummer = @S�sonNr
and se.Title = @SerieNavn
end

execute SkuespillerListe 1, 'Mulon Ruoge 2.0'

--Opgave 07
drop proc SerieL�ngde
create proc SerieL�ngde
@Serie varchar(80)
as
begin
select distinct se.Title , sum(e.L�ngde) as 'Serie L�ngde'
from Skuespiller sk, Serie se, Episode e, S�son s�, SkuespillerEpisode ske 
where s�.SerieID = se.SerieID
and s�.S�sonID = e.S�sonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and se.Title = @Serie
group by se.Title
end

execute SerieL�ngde 'Mulon Ruoge 2.0'

--Opgave 08
drop proc S�sonL�ngde
create proc S�sonL�ngde
@Serie varchar(80)
as
begin
select s�.S�sonnummer, sum(e.L�ngde) as 'S�son L�ngde'
from Skuespiller sk, Serie se, Episode e, S�son s�, SkuespillerEpisode ske 
where s�.SerieID = se.SerieID
and s�.S�sonID = e.S�sonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and se.Title = @Serie
group by s�.S�sonnummer
end

execute S�sonL�ngde 'Mulon Ruoge 2.0'

--Opgave 09
go
drop view ViewAfS�sonL�ngde
go
create view ViewAfS�sonL�ngde
as
select se.Title, s�.S�sonnummer, sum(e.L�ngde) as L�ngde
from Skuespiller sk, Serie se, Episode e, S�son s�, SkuespillerEpisode ske 
where s�.SerieID = se.SerieID
and s�.S�sonID = e.S�sonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
group by se.Title, s�.S�sonnummer

select *
from ViewAfS�sonL�ngde

--Opgave 10
drop proc S�sonL�ngde2
create proc S�sonL�ngde2
@Serie varchar(80),
@S�son int
as
begin
select distinct se.Title , sum(e.L�ngde) as 'S�son L�ngde'
from Skuespiller sk, Serie se, Episode e, S�son s�, SkuespillerEpisode ske 
where s�.SerieID = se.SerieID
and s�.S�sonID = e.S�sonID
and e.EpisodeID = ske.EpisodeID
and ske.SkuespillerID = sk.SkuespillerID
and se.Title = @Serie
and s�.S�sonnummer = @S�son
group by se.Title
end

execute S�sonL�ngde2 'Mulon Ruoge 2.0', 1

--Opgave 11 Se Eclipse
--Opgave 12
drop proc SkueSpillersAlder
create proc SkueSpillersAlder
@Skuespiller varchar(20)
as
begin
select sk.Navn, DATEDIFF(year, sk.F�dsels�r, GETDATE())
from Skuespiller sk
where sk.Navn = @Skuespiller
end

--Opgave 13 se Eclipse