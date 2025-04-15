CREATE DEFINER=`mydb`@`%` PROCEDURE `test05`(OUT deleted_count INT)
BEGIN
	start transaction;
    DELETE FROM PRODUCT
    WHERE PDNO IN (SELECT PDNO 
				   FROM DISCARDED_PRODUCT);
                   
    SET  deleted_count =  ROW_COUNT();
    commit;
END