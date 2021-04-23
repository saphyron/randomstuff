drop table if exists PrisKvitteringslinje
drop table if exists Pris
drop table if exists Kvitteringslinje
drop table if exists ProduktAlkohol
drop table if exists Produkttype
drop table if exists Prisliste
drop table if exists Kvittering
drop table if exists Kunde

create table Kunde(
KundeNummer int identity(1,1) primary key,
Navn varchar(30),
Student bit,
Erhverv bit)

create table Kvittering(
id int identity(1,1) primary key,
Betalingsmetode varchar(30),
Dato Date,
Tid time,
Kunde int foreign key references Kunde(KundeNummer),
NettoPris float,
Betalt bit,
Senestbetalingsdato date,
constraint chk_betaling check(Betalingsmetode IN ('Dankort', 'MobilePay', 'Kontant', 'Klippekort', 'Regning'))
)

create table Prisliste(
Navn varchar(30) primary key,
)

create table Produkttype(
id int identity(1,1) primary key,
Typenavn varchar(30)
)

create table ProduktAlkohol(
id int identity(1,1) primary key,
Navn varchar(30),
AlkoholProcent float,
Volume float,
pant int,
Produkttype int foreign key references Produkttype(id)
)

create table Kvitteringslinje(
id int identity(1,1) primary key,
Antal int,
SpecialaftaltRabat float,
KvitteringID int foreign key references Kvittering(id)
)

create table Pris(
id int identity(1,1) primary key,
Pris float,
Prisliste varchar(30) foreign key references Prisliste(Navn),
ProduktID int foreign key references ProduktAlkohol(id)
)

create table PrisKvitteringslinje(
KvitteringslinjeID int foreign key references Kvitteringslinje(id),
PrisID int foreign key references Pris(id)
)