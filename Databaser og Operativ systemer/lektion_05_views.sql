--view
--create view <navn p� view>
--as
--select <tablekolonne1>, <tablekolonne2>
--from <table>

--select *
--from <navn p� view>

--------------------------------
--forenkle view
--create view <navn p� view>
--as
--select <tablekolonne1>, <tablekolonne1>
--from <table>, <table>, <table>
--where <table.kollonne> = <table.kollonne>
--and <table.kollonne> = <table.kollonne>

--select *
--from <navn p� view>
--where <betingelse>

--------------------------------
--stored procedure
--execute <procedure-navn> <parameter1>

--create proc <navn p� procedure>
--as
--select <tablekolonne1>, <tablekolonne1>
--from <table>

--execute <procedure-navn>

---------
--create proc <navn p� procedure>
--@parameter
--as
--select <tablekolonne1>, <tablekolonne1>
--from <table>
--where @parameter

------------------------------
--triggers
--insert --update --delete
--inserted og deleted tabeller

--create trigger <navn p� trigger> on <table1>
--after <en af de 3 triggers>
--as
--declare @parameter as <value>
--set @parameter = (<subquery> from <inserted og deleted tabeller>)
--begin
--update <tablekolonne1>
--set <table2>
--where <tablekolonne1> = @parameter
--end

--select *
--from <table2>

--insert into <table1>
--values(1,2,3)

------------
