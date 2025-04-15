CREATE DEFINER=`mydb`@`%` PROCEDURE `test02`()
BEGIN
	SELECT PDSUBNAME, PDCOST, PDPRICE
    FROM PRODUCT
    WHERE 
    (
		PDCOST > (SELECT MIN(PDCOST)
					  FROM PRODUCT
                      WHERE PDNAME = 'TV'
                      )
    ) 
	AND
   (
		PDCOST < (SELECT MAX(PDCOST)
					 FROM PRODUCT
                     WHERE PDNAME='CELLPHONE'
                     )
    );
END