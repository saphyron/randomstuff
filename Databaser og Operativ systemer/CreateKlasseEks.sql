drop table HoldMedlem;
drop table Hold;
drop table Klub;
drop table Medlem;

create table Klub(
klubId char(8) primary key,
navn varchar(20)
)

create table Hold(
holdId int primary key,
holdNavn varChar(20) default 'Hold',
antal int check (antal < 15),
klubId char(8) foreign key references Klub(klubId)
)

create table Medlem(
medlemsId int,
navn varchar(30),
alder int,
primary key(medlemsId)
)

create table HoldMedlem(
holdId int foreign key references Hold(holdid),
medlemsId int foreign key references Medlem(medlemsId),
primary key (holdID, medlemsID)
)