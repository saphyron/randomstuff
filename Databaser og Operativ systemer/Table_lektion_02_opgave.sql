drop table Tidsregistrering
drop table Opgave
drop table MedarbejderOpgavetype
drop table Opgavetype
drop table TeamMedarbejder
drop table Medarbejder
drop table Projekt
drop table Team

create table Team(
teamId int primary key,
navn varchar(40)
)

create table Projekt(
projektNr int primary key,
navn varchar(40),
estimeretTimer int,
deadline date,
teamId int foreign key references Team(teamId)
)


create table Medarbejder(
medarbejderNr int primary key,
navn varchar(40),
stillingsbetegnelse varchar(40),
mobil char(8)
)

create table TeamMedarbejder(
medarbejderNr int foreign key references Medarbejder(medarbejderNr),
teamId int foreign key references Team(teamId) not null,
primary key (medarbejderNr, teamId)
)

create table Opgavetype(
opgavetypeId int primary key,
navn varchar(20),
beskrivelse text
)

create table MedarbejderOpgavetype(
opgavetypeId int foreign key references Opgavetype(opgavetypeId),
medarbejderNr int foreign key references Medarbejder(medarbejderNr) not null,
primary key (medarbejderNr, opgavetypeId)
)

create table Opgave(
opgaveNr int primary key,
beskrivelse text,
prioritet tinyint check(prioritet > 0 and prioritet < 11),
forventetStart date,
deadline date,
opgavestatus varchar(20) check(opgavestatus in ('todo', 'done')) ,
projektNr int foreign key references Projekt(projektNr) not null,
opgavetypeId int foreign key references Opgavetype(opgavetypeId) not null
)

create table Tidsregistrering(
id int primary key,
starttid date,
sluttid date,
beskrivelseAfArbejdet text,
datoRegistrering date,
medarbejderNr int foreign key references Medarbejder(medarbejderNr)not null,
opgaveNr int foreign key references Opgave(opgaveNr) not null
)

