--Opgave 6

GO
DROP TRIGGER IF EXISTS 
GO
CREATE TRIGGER
ON OrderItem
AFTER INSERT
AS
BEGIN
	DECLARE @sawQuantity INT
	SET @sawQuantity = (SELECT i.quantity
	FROM INSERTED i
	inner join Product p
	on i.prodID = p.prodID
	and p.prodName = 'Sav')
	
	declare @orderID int 
	set @orderID = (select i.orderID
	from INSERTED i
	inner join Product p
	on i.prodID = p.prodID
	and p.prodName = 'Sav')
	
	if @sawQuantity > 5
		begin
		print concat('Bestilling på antal ', @sawQuantity, 'på ordre ID nummer: ', @orderID)
		end
	else
		begin
		print (@sawQuantity)
		end
end