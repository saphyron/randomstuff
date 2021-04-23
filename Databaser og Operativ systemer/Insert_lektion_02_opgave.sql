--use Lektion_01_Introduktion
--insert into <> values
--()
--select * from PersonRegister
--update Medlem set navn = 'Lars' where medlemsId = 2
--delete from HoldMedlem where medlemsId = 2
--select navn, alder from Medlem where medlemsId = 2
--select * from Medlem order by alder

insert into Team values
(1, '19v'),
(2, '19s'),
(3, '20v')

insert into Projekt values
(1, 'DAOS', 30, '2019-12-12'),
(2, 'SU2', 45, '2019-12-12'),
(3, 'PRO2', 60, '2019-12-12'),
(4, 'FIT2', 30, '2019-12-12')

insert into TeamProjekt values
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(3, 1)

insert into Medarbejder values
(1, 'John', 'Student', '88888888'),
(2, 'Martin', 'Student', '87878787'),
(3, 'Andreas', 'Student', '81818181')

insert into TeamMedarbejder values
(1, 1),
(2, 2),
(3, 3)

insert into Opgavetype values
(1, 'Yatzy', 'Lav et Yatzy spil'),
(2, 'KAS Projekt', 'Lav et konference system'),
(3, 'Designsekvendsdiagam', 'SU2 opgave')

insert into MedarbejderOpgavetype values
(1, 1),
(2, 2),
(3, 3)

insert into opgave values
(1, 'GUI', 2, '2019-08-27', '2019-09-15', '30%', 3, 1),
(2, 'MODEL', 1, '2019-08-27', '2019-09-15', '10%', 3, 1),
(3, 'GUI', 2, '2019-08-27', '2019-09-15', '70%', 3, 2),
(4, 'MODEL', 1, '2019-08-27', '2019-09-15', '12%', 3, 2),
(5, 'Analyse', 1, '2019-08-27', '2019-09-15', '52%', 2, 3),
(6, 'Design', 2,  '2019-08-27', '2019-09-15', '7%', 2, 3)

insert into Tidsregistrering values
(1, '2019-08-27', '2019-08-29', 'Har arbejdet på programmering', '2019-08-29', 1, 1),
(2, '2019-08-27', '2019-08-29', 'Har arbejdet på programmering', '2019-08-29', 2, 2),
(3, '2019-08-27', '2019-08-29', 'Har arbejdet på systemudvikling', '2019-08-29', 3, 3)