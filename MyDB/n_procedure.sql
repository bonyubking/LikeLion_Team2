/*
DELIMITER $$
CREATE PROCEDURE 프로시저명 ( [매개변수 목록] )
BEGIN
    -- SQL 문들
END$$
DELIMITER ;

매개변수 
IN : 입력값 전달
OUT : 출력값 반환
INOUT : 입력도 하고 수정된 값도 반환
CRUD 문법 (프로시저 안에서도 동일하게 사용 가능)

ex)
CREATE PROCEDURE sample_proc(IN param1 INT, OUT result INT)
BEGIN
   SELECT param1 * 2 INTO result;
END;
*/

DROP TABLE EMP_TEST;
USE MY_EMP;

-- sample_proc 호출
SET @OUTPUT = 0;
CALL sample_proc(5, @OUTPUT);
SELECT @OUTPUT AS RESULT;

-- 사칙연산 프로시저
SET @a = 10;
SET @b = 5;
SET @sum = 0;
SET @sub = 0;
SET @div = 0;
SET @r_mul = 0;

call my_calc(@a, @b, @sum, @sub, @mul, @r_div);
-- 결과
SELECT @sum as '+', @sub AS '-', @mul AS '*', @r_div AS '/';


use my_emp;
SELECT  * 
FROM EMP;

-- DOITERATE 만들어서 호출
call my_emp.doiterate(3);

SELECT @X;

-- 

call my_emp.dorepeat(10);

drop table my_temp;
DROP TABLE EMP_TEST;
-- Q1) 제약 조건이 없는 사원 테이블 `EMP_TEST`를 생성해보자.
CREATE TABLE EMP_TEST
AS
SELECT *
FROM EMP;

CALL PRO01_INSERT();

-- Q2) `PRO01_INSERT`() 프로시저를 작성하여, `EMP_TEST`에 사원의 번호, 이름, 부서번호를 여러 건 입력하자.
INSERT INTO EMP_TEST
	VALUES(2,'1111',10), (2,'2222',20), (3,'3333',30);
    
CALL PRO01_INSERT();

-- Q3) `PRO02_DELETE`(IN E_NO INT) 프로시저를 작성하여, 사원 번호를 입력받아 해당 사원을 삭제해보자.

CALL PRO02_DELETE(1);
SELECT * 
FROM EMP_TEST;

UPDATE EMP_TEST
SET EMP_TEST.SAL = 1500
WHERE EMPNO = 7369;

-- Q4) `PRO03_UPDATE`(IN E_NO INT, IN E_NAME VARCHAR(50)) 프로시저를 작성하여, 사번에 해당하는 사원의 이름을 수정하자.

UPDATE EMP_TEST
SET EMP_TEST.ENAME = E_NAME
WHERE EMPNO = E_NO;

CALL PRO03_UPDATE(7934,'bon');

-- Q5) `PRO04_SELECT`(IN EMP_NAME VARCHAR(50)) 프로시저를 작성하여, 사원 이름으로 해당 사원의 정보를 조회하자.

CALL PRO04_SELECT('FORD');

-- 5-1 프로시저 전체 확인


-- Q6) `PRO05_COUNT`(OUT CNT INT) 프로시저를 작성하여, EMP_TEST 테이블의 총 사원 수를 반환하자.
CALL PRO05_COUNT(@RES);

-- Q7) `PRO06_SELECTALL`() 프로시저를 작성하여, EMP_TEST 테이블의 모든 데이터를 조회하자.

CALL PRO06_SELECTALL();

-- Q8) `PRO07_IF`(IN ENO INT) 프로시저를 작성하여,
--      사원이 존재하면 해당 사원의 월급을 2배로 인상하고, 
--      존재하지 않으면 메시지를 출력하자.

SET @ENO = 1111;
CALL PRO07_IF(@ENO);

-- Q9) `PRO08_IF`(IN IN_SAL DECIMAL) 프로시저를 작성하여,
--      입력받은 월급보다 많이 받는 사원의 이름과 급여를 출력하되, 
--      존재하지 않으면 메시지를 출력하자.

SET @ENO = 30000;
CALL PRO08_IF(@ENO);

-- Q10) 모든 사원의 급여를 입력받은 비율만큼 인상하는 프로시저를 작성하자. (예: 비율 1.1 → 10% 인상)

CALL PRO09_IF(1.1);
/*  <<예외>> 
1) DECLARE ... HANDLER : CONTINUE, EXIT, UNDO 핸들러를 통해 오류 발생 후의 흐름 제어
         -DECLARE CONTINUE HANDLER FOR condition action: 지정된 조건이 발생하면 현재 실행 중인 구문을 완료하고 다음 구문을 계속 실행
         -DECLARE EXIT HANDLER FOR condition action: 지정된 조건이 발생하면 현재 블록(BEGIN ... END)을 즉시 종료
         -DECLARE UNDO HANDLER FOR condition action: (트랜잭션 스토리지 엔진에서) 지정된 조건이 발생하면 현재 트랜잭션을 롤백
         
condition 부분 지정  옵션 = SQLSTATE value: 특정 SQLSTATE 값 (5자리 문자열, 예를 들어 '45000').=SQLEXCEPTION: 모든 SQLSTATE 값 중에서 일반적인 오류를 나타내는 클래스=SQLWARNING: 모든 SQLSTATE 값 중에서 경고를 나타내는 클래스= NOT FOUND: 커서 작업에서 더 이상 행이 없을 때 발생하는 조건 (SQLSTATE '02000').=specific_error_code: 특정 MySQL 오류 코드 (정수).
2) SIGNAL SQLSTATE :SQL 예외 발생
3) GET DIAGNOSTICS:발생한 오류에 대한 자세한 정보(SQLSTATE, 오류 코드, 메시지 등)확인

*/



-- Q11) `DO` 문을 활용하여 반복 또는 조건문 기반 로직을 실습해보자.


DROP TABLE T;
CREATE TABLE t(
	s1 INT,
    PRIMARY KEY (s1));
    
DESC T;

CALL handlerdemo();
SELECT @X;

SELECT * FROM T;

CALL P();

DROP TABLE no_such_Table;

GET DIAGNOSTICS CONDITION 1 @p1 = RETURNED_SQLSTATE, @p2 = MESSAGE_TEXT;
SELECT @p1, @p2;

 -- 10-3 )) 예외 처리를 포함한 진단 정보를 출력하자
 
 CALL do_insert(100);
 
 -- Q11 )) DO 문 활용하여 반복 조건문 기반 로직 학습해보자
 -- 이름 전화번호 가입일을 저장하는 테이블 생성하고 프로시저를 통해 난수 기반으로 100명 데이터
 -- 자동 입력해보자.
 
 CREATE TABLE IF NOT EXISTS random_members (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    phone VARCHAR(20),
    join_date DATE
);

SELECT DATEDIFF('2024-12-31', '2020-01-01');

CALL PRO11_Insert_random_members();

SELECT * FROM random_Members;
 
 
 -- 위 테이블에 WED 컬럼 추가후 프로시저로 요일 계산해서 넣자
  -- Q12) `CURSOR`(커서)를 이용한 프로시저를 작성하여, TEST_EMP 사원의 이름과 봉급 출력.

CALL PRO12_CURSOR_SELECT();
 -- Q12-1) 위 커서내용을 전체출력한결과 내보자
 
 
 -- Q12) `CURSOR`(커서)를 이용한 프로시저를 작성하여, 부서번호가 10번인 사원들을 순차적으로 출력하자.



 


