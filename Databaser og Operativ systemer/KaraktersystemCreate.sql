DROP TABLE IF EXISTS EksamensResultat
DROP TABLE IF EXISTS Studerende
DROP TABLE IF EXISTS Eksamen
DROP TABLE IF EXISTS Uddanelse

create table Uddanelse(
navn varchar(30) Primary key
)

create table Eksamen(
eksamenID int identity(1,1) Primary key,
fag varchar(30),
Uddannelsesnavn varchar(30) foreign key references Uddanelse(navn)
)

create table Studerende(
cpr char(10) primary key,
navn varchar(50),
Udannelsesnavn varchar(30) foreign key references Uddanelse(navn)
)

create table EksamensResultat(
id int identity(1,1) primary key,
StuderendeCPR char(10) foreign key references Studerende(cpr),
karakter int check(karakter in (-3, 0, 2, 4, 7, 10, 12)),
bestået bit,
EksamensID int foreign key references Eksamen(eksamenID)

)