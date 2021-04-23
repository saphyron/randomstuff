drop table if exists produkter
drop table if exists bydning
drop table if exists kunde


create table kunde(
KundeNummer int identity(1,1) primary key,
Navn varchar(30),
EMail varchar(30),
Brugernavn varchar(30),
Telefon varchar(30)
)

create table produkter(
ProduktID int identity(1,1) primary key,
MetalType varchar(30),
Maengde varchar(30),
Bud float,
Auktionsfrist datetime,
KundeNr int foreign key references kunde(KundeNummer)
)

create table bydning(
bydningsNr int identity(1,1) primary key,
KundeNr int foreign key references kunde(KundeNummer),
PiID int foreign key references produkter(ProduktID),
budt bit
)
