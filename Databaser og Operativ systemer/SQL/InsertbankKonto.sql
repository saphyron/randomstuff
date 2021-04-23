drop table if exists Konto

CREATE TABLE Konto (
regNr INT,
ktoNr BIGINT,
tekst CHAR(20),
saldo REAL,
renteIndlaan REAL,
renteUdlaan REAL,
PRIMARY KEY (regNr, ktoNr))

insert into Konto (regNr, ktoNr, tekst, saldo, renteIndlaan, renteUdlaan) values 
( 1234, 1234567, 'Loenkonto', 10000.00, 1.2, 5.2),
( 1234, 1231236, 'Loenkonto', 5000.00, 1.2, 5.2),
( 1234, 1357967, 'Loenkonto', 12000.00, 1.2, 5.2),
( 1216, 1256788, 'Loenkonto', 15000.00, 1.2, 5.2),
( 1216, 2234567, 'Boliglaan', 2550000.00, 1.2, 5.2),
( 1234, 2231236, 'Boliglaan', 3175000.00, 1.2, 5.2)

select *
from Konto

--update Konto
--set saldo = saldo - 100
--where ktoNr = 1231236

--select *
--from Konto