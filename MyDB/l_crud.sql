/*

reference_definition:
    REFERENCES tbl_name (key_part,...)
      [MATCH FULL | MATCH PARTIAL | MATCH SIMPLE]
      [ON DELETE reference_option]
      [ON UPDATE reference_option]

reference_option:
    RESTRICT | 기본값, 부모 테이블의 값이 자식 테이블에 의해 참조되면 삭제 수정불가
    CASCADE | 부모 테이블의 데이터가 삭제/수정되면 자식테이블의 데이터도 같이 삭제/수정
    SET NULL | 부모 테이블의 데이터가 삭제/수정되면 자식 테이블의 컬럼값 NULL
    NO ACTION | RESTRICT와같음 즉시 적용되지않고 
    SET DEFAULT 부모 테이블의 데이터가 삭제/수정되면 자식테이블의 컬럼값은 기본값으로 대체됨

CREATE TABLE orders(
		order_id int primary key AUTO_INCREMENT,
        customer_id INT NOT NULL,
        order_date DATE NOT NULL,
        FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
			ON DELETE CASCADE
            ON UPDATE CASCDE
);
    -- 고객 정보가 삭제되면 고객의 주문도 함께 삭제
    -- 고객 ID 변경되ㅗ면 주문 정보의 고객 ID도 함꼐 변경
    
ALTER TABLE emp
ADD CONSTRAINT fk_emp_Dept
			FOREIGN KEY (DEPTNO) REFERENCES dept(Deptno)
						ON DELETE NO ACTION ON UPDATE NO ACTION;
	- ON DELETE NO ACTION; dept 테이블에서 deptno값을 삭제하려고할때
					deptno를 사용하는 emp테이블의 데이터가 있으면 삭제를 허용 X
	- ON UPDATE NO ACTION : dept 테이블에서 deptno값을 변경하려고할때
					deptno를 사용하는 emp테이블의 데이터가 있으면 삭제를 허용 X
*/
use my_emp;
	show create table emp;
    
SELECT
	CONSTRAINT_NAME,
    UPDATE_RULE,
    DELETE_RULE,
    TABLE_NAME,
    REFERENCED_TABLE_NAME
FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS
WHERE CONSTRAINT_SCHEMA = 'my_emp' AND TABLE_NAME = 'emp';

/*
1)CRUD
Create (삽입)	INSERT INTO 테이블명 (열1, 열2, ...) VALUES (값1, 값2, ...);	
Read (조회)	SELECT 열1, 열2 FROM 테이블명 [WHERE 조건];	
Update (수정)	UPDATE 테이블명 SET 열1 = 값1, 열2 = 값2 WHERE 조건;	
Delete (삭제)	DELETE FROM 테이블명 WHERE 조건;	

2)트랜잭션 제어 명령어
START TRANSACTION;	트랜잭션 시작 (명시적으로 시작하고 싶을 때 사용)
COMMIT;	트랜잭션 완료 후 변경 사항을 영구 저장
ROLLBACK;	트랜잭션 내의 모든 변경 사항을 취소하고 되돌림
SAVEPOINT 포인트명;	중간 저장점 지정 – ROLLBACK TO SAVEPOINT로 일부 취소 가능
ROLLBACK TO SAVEPOINT 포인트명;	특정 지점까지 롤백

3) 트랜잭션 특징 (ACID 원칙 요약)
Atomicity (원자성)	: 모든 작업이 모두 수행되거나, 하나도 수행되지 않아야 함
Consistency (일관성)	: 트랜잭션 완료 후에도 데이터의 일관성 유지
Isolation (고립성)	:트랜잭션끼리 서로 간섭하지 않아야 함
Durability (지속성)	:COMMIT 후 변경 내용은 영구 저장되어야 함
*/
USE MY_EMP;
CREATE TABLE MY_EMP  -- EMP의 테이블 구조와 데이터로만 테이블 생성   
AS
SELECT  * FROM EMP;   -- 제약 구조는 리턴되지 않음  

SELECT  * FROM MY_EMP;
DESC MY_EMP;

SET autocommit=0; -- mysql 서버에 변경한다
SET global autocommit = 1; -- mysql 서버에 변경
SELECT @@AUTOCOMMIT; -- 세션수준에 변수값 확인 = 세션이란 ? 클라이언트 객체를 생성해서 서버가 관리하는 인스턴스
SELECT @@GLOBAL.AUTOCOMMIT; -- 글로벌 수준의 변수값 확인

CREATE TABLE MY_DEPT
AS
SELECT * FROM DEPT;

SELECT  * FROM MY_DEPT;
DESC MY_DEPT;

-- 1(자동 커밋활성화)  ,  0 (자동 커밋 비활성화 )
SET  autocommit= 0;  -- mysql 서버에  변경한다.  
SET  global autocommit= 0;  -- mysql 서버에  변경한다.  
SELECT @@autocommit;  -- 세션수준의 변수값 확인  
SELECT @@global.autocommit;  -- 글로벌 수준의 변수값 확인 

START TRANSACTION;
-- DML 실행
COMMIT;

############ DML 연습 해보자 ############
START TRANSACTION;
 -- 1) 간단 테이블 생성
DROP TABLE TEST;
CREATE TABLE TEST(
ID INT,
NAME VARCHAR(20));

-- 2) 입력
INSERT INTO TEST VALUES(1,1);
INSERT INTO TEST VALUES(2,1);
SELECT * FROM TEST;

commit;
INSERT INTO TEST VALUES(3,1);
INSERT INTO TEST VALUES(4,2);
commit;
INSERT INTO TEST VALUES(5,1);
INSERT INTO TEST VALUES(6,2);
commit; 
ROLLBACK; -- 입력한 내용 취소 -- 3번
SELECT * FROM TEST;

DESC TEST;

#############################################

-- SAVEPOINT 포인트명;	중간 저장점 지정 – ROLLBACK TO SAVEPOINT로 일부 취소 가능
-- ROLLBACK TO SAVEPOINT 포인트명;	특정 지점까지 롤백

DROP TABLE TEST;
CREATE TABLE TEST(
ID INT,
NAME VARCHAR(20));

START TRANSACTION;

INSERT INTO TEST VALUES(1,'A');
INSERT INTO TEST VALUES(2,'B');

SAVEPOINT SP01;
ROLLBACK TO SAVEPOINT SP01;
INSERT INTO TEST VALUES(3,'C');
INSERT INTO TEST VALUES(4,'D');


SELECT * FROM TEST;

DROP TABLE IF EXISTS MY_EMP;
DROP TABLE IF EXISTS MY_DEPT;

CREATE TABLE MY_EMP
AS
SELECT * FROM EMP;

CREATE TABLE MY_DEPT
AS
SELECT * FROM DEPT;


-- Q1) 사원 테이블에서 사원의 번호가 7499인 사원의 월급을 700으로 변경하자.
START TRANSACTION;
UPDATE MY_EMP 
SET SAL = 700
WHERE EMPNO = 7499;
SELECT * FROM MY_EMP;
-- Q2) 부서 번호가 20번인 사원의 월급을 2000으로 변경하자.
UPDATE MY_EMP
SET SAL = 2000
WHERE DEPTNO = 20;
COMMIT;
-- Q3) MY_DEPT 테이블에 50번, RESERCH, BOSTON 데이터를 입력하자.
INSERT INTO MY_DEPT VALUES(50,'RESEARCH','BOSTON');
-- Q4) MY_DEPT 테이블에서 부서번호 50번 데이터를 삭제하자.
DELETE FROM MY_DEPT WHERE DEPTNO = 50;
-- Q5) FORD의 월급을 4000으로, 부서번호를 30으로 변경하자.
UPDATE EMP
SET SAL = 4000, DEPTNO = 30
WHERE ENAME = 'FORD';
-- Q6) 사원번호 7698의 부서번호를 사원번호 7934의 부서번호로 변경하자.
SET @dept_no = (SELECT DEPTNO FROM MY_EMP WHERE EMPNO = 7934);
UPDATE MY_EMP
SET DEPTNO = @dept_no
WHERE EMPNO = 7968;


SELECT EMPNO, DEPTNO FROM MY_EMP WHERE EMPNO IN (7968, 7934);
-- Q7) 사번이 0001인 홍길동 사원 데이터를 여러 개 추가한 후, 다양한 UPDATE 및 DELETE 작업을 수행하자.
ALTER TABLE My_EMP MODIFY EMPNO VARCHAR(10);
INSERT INTO My_EMP (EMPNO, ENAME) VALUES(0001,'홍길동');
-- Q7-1) 사원번호 1이고 매니저가 7785인 홍길동을 삭제하자.
DELETE 
FROM MY_EMP 
WHERE EMPNO = 1 AND MGR = 7785;
-- Q7-2) 사번 0001의 부서번호를 20으로 변경하자.
UPDATE MY_EMP
SET DEPTNO = 20
WHERE EMPNO = 1;
-- Q7-3) 홍길동의 직업을 SALESMAN으로 변경하자.
UPDATE MY_EMP
SET JOB = 'SALESMAN'
WHERE ENAME = '홍길동';
-- Q7-4) 홍길동의 봉급을 KING과 같게 변경하자.
SET @KING_SAL = (SELECT SAL FROM MY_EMP WHERE ENAME = 'KING');
UPDATE MY_EMP a2
SET SAL = @KING_SAL
WHERE ENAME = '홍길동';

CREATE TEMPORARY TABLE TEMP_KING AS SELECT SAL FROM MY_EMP WHERE ENAME = 'KING';
UPDATE MY_EMP SET SAL = (SELECT SAL FROM TEMP_KING) WHERE ENAME = '홍길동';
DROP TEMPORARY TABLE TEMP_KING;
-- Q7-5) 매니저가 7785인 홍길동의 봉급을 0으로 수정하자.

UPDATE MY_EMP a1
SET SAL = 0
WHERE MGR = 7785 AND ENAME = '홍길동';

-- Q7-6) 매니저가 7784인 홍길동의 커미션을 1000으로 수정하자.
UPDATE MY_EMP a1
SET COMM = 1000
WHERE MGR = 7784 AND ENAME = '홍길동';

use my_emp;
-- Q8) 서브쿼리를 이용한 INSERT, DELETE, UPDATE를 활용해보자.
-- Q8-1) WARD와 같은 직업을 가진 사원을 삭제하자.
DELETE MY_EMP
FROM MY_EMP
JOIN MY_EMP AS temp ON MY_EMP.JOB = temp.JOB
WHERE temp.ENAME = 'WARD' AND MY_EMP.ENAME != 'WARD';

delete from my_emp
where job = (SELECT M_NEW.JOB
				FROM ( SELECT job
						FROM MY_EMP
						WHERE ename = 'WARD') M_NEW);

SET @WARD_JOB = (SELECT JOB FROM MY_EMP
							WHERE ENAME = 'WARD');
DELETE FROM MY_EMP
WHERE job = @WARD_JOB;
ROLLBACK;

-- Q8-2) WARD의 월급을 SMITH의 월급과 같게 수정하자.
UPDATE MY_EMP m1
JOIN MY_EMP m2 ON m2.ENAME = 'SMITH'
SET m1.SAL = m2.SAL
WHERE m1.ENAME = 'WARD';

-- Q8-3) KING의 직업을 SMITH와 같게 수정하자.
UPDATE MY_EMP m1
JOIN MY_EMP m2 ON m2.ENAME = 'SMITH'
SET m1.JOB = m2.JOB
WHERE m1.ENAME = 'KING';
-- Q8-4) 사원번호 7499와 같은 직업을 가진 사원의 입사일을 오늘 날짜로 수정하자.
UPDATE MY_EMP m1
JOIN MY_EMP m2 ON m1.JOB = m2.JOB
SET m1.HIREDATE = CURDATE()
WHERE m2.EMPNO = 7499;
-- Q9) MY_EMP, MY_DEPT 테이블에 PRIMARY KEY를 추가하자.
ALTER TABLE MY_EMP
ADD PRIMARY KEY(empno);
ALTER TABLE MY_DEPT
ADD PRIMARY KEY (deptno);

-- Q10) MY_EMP 테이블에 외래키를 설정하고 ON DELETE/UPDATE CASCADE 옵션을 추가하자.

ALTER TABLE MY_EMP
ADD CONSTRAINT FK_DEPTNO 
FOREIGN KEY (DEPTNO) REFERENCES MY_DEPT(DEPTNO)
ON DELETE CASCADE
ON UPDATE CASCADE;

SHOW CREATE TABLE MY_EMP;
-- Q11) MY_DEPT에서 DEPTNO 10을 삭제한 후, MY_EMP에서 DEPTNO 10을 확인하자.
DELETE FROM MY_DEPT
WHERE DEPTNO = 10;

-- Q12) MY_DEPT에서 DEPTNO 20을 200으로 변경한 후, MY_EMP에서 DEPTNO 200을 확인하자.
UPDATE MY_DEPT
SET DEPTNO = 200
WHERE DEPTNO = 20;





