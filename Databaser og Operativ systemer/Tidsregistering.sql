drop table Tidsregistering
drop table Opgave
drop table MedarbejderOpgavetype
drop table Projekt
drop table MedarbejderITeam
drop table Medarbejder
drop table Opgavetype
drop table Team


create table Team(
teamId char(10) primary key,
navn varchar(20)
)

create table Opgavetype(
typeId int primary key,
navn varchar(30),
beskrivelse varchar(30)
)

create table Medarbejder(
medarbejderNr int primary key,
navn varchar(30),
stillingsbetegnelse varchar(30),
mobil char(10)
)

create table MedarbejderITeam(
medarbejderNr int foreign key REFERENCES Medarbejder(medarbejderNr), 
teamId char(10) foreign key REFERENCES Team(teamId)
)

create table Projekt(
projektNr int primary key,
projektnavn varchar(30),
estimeretTimer int,
deadline date,
teamId char(10) foreign key references Team(teamId)
)

create table MedarbejderOpgavetype(
medarbejderNr int foreign key REFERENCES Medarbejder(medarbejderNr), 
typeId int foreign key REFERENCES Opgavetype(typeId),
Primary key(medarbejderNr, typeId)
)

create table Opgave(
opgaveNr int primary key,
beskrivelse varchar(50),
prioritet int check (prioritet in (1,2,3,4,5)),
forventetStart date,
deadline date,
statusPaaOpgave char(7) check (statusPaaOpgave in ('To do', 'Igang', 'Færdig', 'Checked')),
projektNr int foreign key references Projekt(projektNr),
typeId int foreign key references Opgavetype(typeId)
)

create table Tidsregistering(
tidsId int IDENTITY(1,1) primary key,
starttid time,
sluttid time,
beskrivelseAfArbejde varchar(100),
datoRegistering date,
medarbejderNr int foreign key REFERENCES Medarbejder(medarbejderNr), 
opgaveNr int foreign key references Opgave(opgaveNr),
)

