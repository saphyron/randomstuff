drop table SkuespillerEpisode
drop table Episode
drop table Skuespiller
drop table Sæson
drop table Serie

create table Serie(
SerieID int identity primary key,
Title varchar(80),
Produktionsselskab varchar(30)
)

create table Sæson(
SæsonID int identity primary key,
Premiere date,
Finale date,
Sæsonnummer int,
SerieID int foreign key references Serie(SerieID)
)

create table Skuespiller(
SkuespillerID int identity primary key,
Navn varchar(20),
Fødselsår date
)

create table Episode(
EpisodeID int identity primary key,
Nummer int,
Længde int,
Titel varchar(20),
SæsonID int foreign key references Sæson(SæsonID)
)

create table SkuespillerEpisode(
SkuespillerID int foreign key REFERENCES Skuespiller(SkuespillerID),
EpisodeID int foreign key REFERENCES Episode(EpisodeID),
)