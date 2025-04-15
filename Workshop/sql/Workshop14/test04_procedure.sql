CREATE DEFINER=`mydb`@`%` PROCEDURE `test04`(OUT inserted_count INT)
BEGIN

	start transaction;

    INSERT INTO DISCARDED_PRODUCT (
        PDNO, PDNAME, PDSUBNAME, FACTNO, PDDATE, 
        PDCOST, PDPRICE, PDAMOUNT, DISCARDED_DATE
    )
    SELECT 
        PDNO, PDNAME, PDSUBNAME, FACTNO, PDDATE, 
        PDCOST, PDPRICE, PDAMOUNT, CURRENT_DATE()
    FROM PRODUCT
    WHERE -- 폐기 조건은 여기에 명시
        PDAMOUNT IS NULL;
    
    SET inserted_count = ROW_COUNT();
    commit;

END