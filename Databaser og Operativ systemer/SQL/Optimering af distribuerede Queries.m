Table S			Table SP					Table P
10.000 tupler	1.000.000 tupler			100.000 tupler
1.000 London	100.000 london suppliers	1.000 røde
Site A			Site A						Site B

Alle felter er 500 bits lange og hver tupel
(record)
er dermed 1000 bit.
Antal røde dele (Parts) 
= 1000
Antal leveringer af London-Suppliers 
= 100.000
Datatransmissions rate 
= 1.000.000 bits/sekund
Access delay (udførelse af arbejde på site)
= 1 sekund. 

Responstiden for forespørgslen kan udregnes efter følgende formel:
T = Total Access delay + (Total datavolume / Datatransmissions rate)

1.
Flyt relation P til site A og udfør forespørgslen på A.
2.
Flyt relation S og SP til site B og udfør f
orespørgslen på B.
3.
Join S og SP  på A og udvælg de tupler, der har city = ”London”. For hver sådan 
tupel, checkes B for at se, om stykdelen er ’red’. Hvert af disse check vil medføre, at 
to messages sendes, forespørgslen og svaret.
4.
Udvælg tupler fra P på B
, som har color = ’red’ og for hvert af disse check på A, om 
der eksisterer en levering på den stykdel relateret til en London
-
supplier. Igen to 
messages pr. check.
5.
Join relation S og SP på A, udvælg de tupler fra resultatet, der har city = ’London’ og 
projekter resultatet over SNO og PNO, hvorefter dette overføres til B for færdigbehandling.
6.
Udvælg de tupler P på B, som har color = ’red’ og flyt resultatet til A for 
færdigbehandling.

1)	T = 1 sec + ((100.000 x 1.000 bits) / (1.000.000 bits/sekund)) ->
		1 sec + (100.000.000 bits / 1.000.000 bits/sekund) ->
		1 sec + (100 sec) = 101 sec
		
2)	T = 1 sec + (((1.000.000 + 10.000) x 1.000 bits) / (1.000.000 bits/sekund)) ->
		1 sec + (1.010.000.000 bits / 1.000.000 bits/sekund) ->
		1 sec + (1.010 sec) = 1.011 sec
		
3)	T = 1 sec x 2 Spørgsmål/svar x 100.000 London + ((1.000 x 1.000 bits) / 1.000.000 bits/sekund) ->
		200.000 sec + (1.000.000 bits / 1.000.000 bits/sekund) ->
		200.000 sec + (1 sec) = 200.001 sec
		
4)	T = 1 sec x 2 Spørgsmål/svar x 1.000 Røde + ((1.000 x 1.000 bits) / 1.000.000 bits/sekund) ->
		2.000 sec + (1.000.000 bits / 1.000.000 bits/sekund) ->
		2.000 sec + (1 sec) = 2.001 sec
		
5)	T = 1 sec + ((100.000 x 1.000 bits) / 1.000.000 bits/sekund) ->
		1 sec + (100.000.000 bits / 1.000.000 bits/sekund) ->
		1 sec + (100 sec) = 101 sec
		
6)	T = 1 sec + ((1.000 x 1.000 bits) / 1.000.000 bits/sekund) ->
		1 sec + (1.000.000 bits / 1.000.000 bits/sekund) ->
		1 sec + (1 sec) = 2 sec