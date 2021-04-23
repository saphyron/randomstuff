insert into Kunde values
('Gæst', 0, 0),
('Joakim', 1, 0),
('Kristian', 0, 1),
('John', 0, 0)

insert into Kvittering values
('Dankort', '2019-11-08', '12:00', 1, 0.00, 1, '2019-11-08'),
('MobilePay', '2019-11-08', '12:00', 1, 0.00, 1, '2019-11-08'),
('Kontant', '2019-11-08', '12:00', 2, 0.00, 1, '2019-11-08'),
('Klippekort', '2019-11-08', '12:00', 3, 0.00, 1, '2019-11-08'),
('Regning', '2019-11-08', '12:00', 4, 0.00, 0, '2019-12-08')

insert into Prisliste values
('Butik'),
('Fredags Bar'),
('Fest Uge')

insert into Produkttype values
('Flaske'),
('Fadøl, 40 cL'),
('Spiritus'),
('Fustage'),
('Kulsyre'),
('Malt'),
('Beklædning'),
('Anlæg'),
('Glas'),
('Sampakning'),
('Rundvisning'),
('Klippekort')

insert into ProduktAlkohol values
-- Flaske
('Klosterbryg', 0.05, 0.60, 1, 1),
('Extra Pilsner', 0.05, 0.60, 1, 1),
('Julebryg', 0.05, 0.60, 1, 1),
('Tribute', 0.05, 0.60, 1, 1),
-- Fadøl
('Klosterbryg', 0.05, 0.40, 1, 2),
('Extra Pilsner', 0.05, 0.40, 1, 2),
('Julebryg', 0.05, 0.40, 1, 2),
('Tribute', 0.05, 0.40, 1, 2),
--Spiritus
('Spirit of Aarhus', 0.1, 0.75, 3, 3),
('SOA med Pind', 0.1, 0.75, 3, 3),
('Whiskey', 0.1, 0.75, 3, 3),
('Liquor of Aarhus', 0.1, 0.75, 3, 3),
-- Fustage
('Klosterbryg', 0.05, 20.00, 200, 4),
('Extra Pilsner', 0.05, 25.00, 200, 4),
('Extra Pilsner', 0.05, 30.00, 200, 4),
('Julebryg', 0.05, 20.00, 200, 4),
('Julebryg', 0.05, 25.00, 200, 4),
('Blondie', 0.05, 25.00, 200, 4),
-- Kulsyre
('Kulsyre 4 kg', 0.00, 0.00, 1000, 5),
('Kulsyre 6 kg', 0.00, 0.00, 1000, 5),
('Kulsyre 10 kg', 0.00, 0.00, 1000, 5),
-- Malt
('Malt 25 kg', 0.00, 0.00, 0, 6),
-- Beklædning
('T-shirt', 0.00, 0.00, 0, 7),
('Polo', 0.00, 0.00, 0, 7),
('Cap', 0.00, 0.00, 0, 7),
-- Anlæg
('1-Hane', 0.00, 0.00, 0, 8),
('2-Haner', 0.00, 0.00, 0, 8),
('Bar med flere haner', 0.00, 0.00, 0, 8),
('Krus', 0.00, 0.00, 0, 8),
-- Glas
('Glas', 0.00, 0.00, 0, 9),
-- Sampakning
('Gaveæske 2 øl, 2 glas', 0.00, 0.00, 0, 10),
('Gaveæske 4 øl', 0.00, 0.00, 0, 10),
('Trækasse 6 øl', 0.00, 0.00, 0, 10),
('Gavekurv 6 øl, 2 glas', 0.00, 0.00, 0, 10),
('Trækasse 6 øl, 6 glas', 0.00, 0.00, 0, 10),
('Trækasse 12 øl', 0.00, 0.00, 0, 10),
('Papkasse 12 øl', 0.00, 0.00, 0, 10),
-- Rundvisning
('Rundvisning', 0.00, 0.00, 0, 11),
-- Klippekort
('Klippekort 4-klip', 0.00, 0.00, 0, 12)

insert into Kvitteringslinje values
-- Gæst 1
(10, 0.00, 1),
(6, 0.00, 1),
(3, 0.00, 1),
(4, 0.00, 1),
(2, 0.00, 1),
(5, 0.00, 1),
-- Gæst 2
(200, 0.35, 2),
(50, 0.35, 2),
(20, 0.35, 2),
-- Joakim
(20, 0.00, 3),
(15, 0.00, 3),
(10, 0.00, 3),
(5, 0.00, 3),
(1, 0.00, 3),
-- Kristian
(5, 0.00, 3),
(4, 0.00, 3),
(3, 0.00, 3),
(2, 0.00, 3),
(1, 0.00, 3),
-- John
(1100, 0.00, 4)

insert into Pris values
-- Flaske
(36, 'Butik', 1),
(50, 'Fredags Bar', 1),
(40, 'Fest Uge', 1),
(36, 'Butik', 2),
(50, 'Fredags Bar', 2),
(40, 'Fest Uge', 2),
(36, 'Butik', 3),
(50, 'Fredags Bar', 3),
(40, 'Fest Uge', 3),
(36, 'Butik', 4),
(50, 'Fredags Bar', 4),
(40, 'Fest Uge', 4),
-- Fadøl
(30, 'Fredags Bar', 5),
(30, 'Fest Uge', 5),
(30, 'Fredags Bar', 6),
(30, 'Fest Uge', 6),
(30, 'Fredags Bar', 7),
(30, 'Fest Uge', 7),
(30, 'Fredags Bar', 8),
(30, 'Fest Uge', 8),
--Spiritus
(300, 'Butik', 9),
(300, 'Fredags Bar', 9),
(300, 'Fest Uge', 9),
(350, 'Butik', 10),
(350, 'Fredags Bar', 10),
(350, 'Fest Uge', 10),
(500, 'Butik', 11),
(500, 'Fredags Bar', 11),
(500, 'Fest Uge', 11),
(175, 'Butik', 12),
(175, 'Fredags Bar', 12),
(175, 'Fest Uge', 12),
-- Fustage
(775, 'Butik', 13),
(575, 'Butik', 14),
(690, 'Butik', 15),
(775, 'Butik', 16),
(969, 'Butik', 17),
(700, 'Butik', 18),
-- Kulsyre
(267, 'Butik', 19),
(400, 'Butik', 20),
(667, 'Butik', 21),
(267, 'Fredags Bar', 19),
(400, 'Fredags Bar', 20),
(667, 'Fredags Bar', 21),
-- Malt
(300, 'Butik', 22),
-- Beklædning
(70, 'Butik', 23),
(70, 'Fredags Bar', 23),
(70, 'Fest Uge', 23),
(100, 'Butik', 24),
(100, 'Fredags Bar', 24),
(100, 'Fest Uge', 24),
(30, 'Butik', 25),
(30, 'Fredags Bar', 25),
(30, 'Fest Uge', 25),
-- Anlæg
(250, 'Butik', 26),
(400, 'Butik', 27),
(500, 'Butik', 28),
(60, 'Butik', 29),
-- Glas
(15, 'Butik', 30),
-- Sampakning
(100, 'Butik', 31),
(100, 'Fredags Bar', 31),
(100, 'Fest Uge', 31),
(130, 'Butik', 32),
(130, 'Fredags Bar', 32),
(130, 'Fest Uge', 32),
(240, 'Butik', 33),
(240, 'Fredags Bar', 33),
(240, 'Fest Uge', 33),
(250, 'Butik', 34),
(250, 'Fredags Bar', 34),
(250, 'Fest Uge', 34),
(290, 'Butik', 35),
(290, 'Fredags Bar', 35),
(290, 'Fest Uge', 35),
(390, 'Butik', 36),
(390, 'Fredags Bar', 36),
(390, 'Fest Uge', 36),
(360, 'Butik', 37),
(360, 'Fredags Bar', 37),
(360, 'Fest Uge', 37),
-- Rundvisning
(100, 'Butik', 38),
-- Klippekort
(100, 'Butik', 39),
(100, 'Fredags Bar', 39),
(100, 'Fest Uge', 39)

insert into PrisKvitteringslinje values
(1,1),
(2,21),
(3,10),
(4,36),
(5,39),
(6,55),
(7,1),
(8,4),
(9,13),
(10,15),
(11,17),
(12,19),
(13,22),
(14,33),
(15,34),
(16,35),
(17,36),
(18,37),
(19,1),
(20,14)