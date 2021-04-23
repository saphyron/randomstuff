--where σ (Sigma)
--select Π (PI(stor))
--select π (pi (lille))
--join/and ⋈ butterfly
--intersect ∩
--union ∪
--renaming p (rho)
--full join x (gange X)
--or v (eller)
--and ^ (og)
--condition c = condition


--Opgave 01
select b.color
from Sailors s, Reserves r, Boats b
where s.said = r.said
and b.bid = r.bid
and s.sname = 'Lubber'

--ΠBoats.color((σsname = 'Lubber'(Sailors)) ⋈ r ⋈ b)

--Opgave 02
select s.said
from Sailors s
where s.age > 8
union
select r.said
from Reserves r
where r.bid = 103

--Πs.said(σs.rating>8(s))∪Πsaid(σbid=103(r))

--Opgave 03
select s.sname
from Sailors s
where s.said in
((select s.said
from Sailors s)
except
(select r.said
from Boats b, Reserves r
where b.color = 'red'
and b.bid = r.bid))

select s.sname
from Sailors s
where s.said not in
(select r.said
from Boats b, Reserves r
where b.color = 'red'
and b.bid = r.bid)

--Πsname((Πsaid(Sailors)-Πsaid(σcolor='red'(Boats))⋈Reserves)⋈Sailors)

--Opgave 04
select s.said
from Sailors s
where s.age > 20
and s.said not in
(select r.said
from Boats b, Reserves r
where b.color = 'red'
and b.bid = r.bid)

--Πsaid(σage>20(Sailors))-Πsaid((σcolor='red'(Boats))⋈Reserves)

--Opgave 05
select distinct s.sname
from Sailors s, Reserves r1, Reserves r2
where s.said = r2.said
and r1.bid <> r2.bid

--Πsname((Sailors)((Sailors⋈Reserves)-(Reserves⋈Reserves)))



