drop table SkuespillerEpisode
drop table Episode
drop table Skuespiller
drop table S�son
drop table Serie

create table Serie(
SerieID int identity primary key,
Title varchar(80),
Produktionsselskab varchar(30)
)

create table S�son(
S�sonID int identity primary key,
Premiere date,
Finale date,
S�sonnummer int,
SerieID int foreign key references Serie(SerieID)
)

create table Skuespiller(
SkuespillerID int identity primary key,
Navn varchar(20),
F�dsels�r date
)

create table Episode(
EpisodeID int identity primary key,
Nummer int,
L�ngde int,
Titel varchar(20),
S�sonID int foreign key references S�son(S�sonID)
)

create table SkuespillerEpisode(
SkuespillerID int foreign key REFERENCES Skuespiller(SkuespillerID),
EpisodeID int foreign key REFERENCES Episode(EpisodeID),
)