/*
서브쿼리의 특징  15.2.15 Subqueries

1) 서브쿼리는 내부 쿼리(Subqueries)와 외부 쿼리(Main query)로 구성된다. 
	
2) 서브쿼리는 SELECT, INSERT, UPDATE, DELETE 문에서 WHERE, HAVING, FROM, SELECT절 등 
            위치에 사용
           - WHERE	조건절로 사용	WHERE SAL > (SELECT ...)
           -SELECT	출력 컬럼으로 사용	SELECT ENAME, (SELECT COUNT(*) ...) AS CNT
           - FROM	임시 테이블로 사용	FROM (SELECT ... ) AS TEMP
            

3) 단일 행 또는 다중 행 결과를 반환할 수 있고, 사용되는 연산자가 달라진다.
     - 단일 행     :  서브쿼리 결과가 1개의 행만 리턴
                       연산자: =, >, <, >=, <=, != 등 일반 비교 연산자
	 - 다중행    : 서브쿼리 결과가 여러 개의 행을 리턴
                연산자: IN, NOT IN, ANY, ALL, EXISTS, NOT EXISTS 등
                
    - 서브쿼리 연산자  
        IN	:서브쿼리 결과 목록 중 포함된 값이면 참
		NOT IN	:서브쿼리 결과 목록 중 포함되지 않으면 참
		> ANY	:서브쿼리 결과 중 하나라도 초과하면 참
		< ALL	:서브쿼리 결과 모두보다 작으면 참
		EXISTS	:서브쿼리 결과가 존재하면 참
		NOT EXISTS:	서브쿼리 결과가 없으면 참

4) 일반적으로 서브쿼리는 주 쿼리의 실행에 의존적이며, 외부 쿼리의 컬럼을 참조할 수 있다.

5) EXISTS와 NOT EXISTS를 사용하여 특정 조건이 충족되는지 여부만을 판단하는 논리적 테스트를 수행한다.

6) Correlated subqueries: 서브쿼리가 외부 쿼리의 컬럼을 참조하는 경우를 말하며
   서브쿼리는 외부 쿼리의 각 행에 대해 반복적으로 실행된다.

7)서브쿼리 내에서 LIMIT 절의 사용이 제한될 수 있다.
*/
-- Q1. JONES의 월급보다 더 많은 월급을 받는 사원의 이름과 봉급을 출력하시오.

USE my_emp;
SELECT SAL
FROM EMP
WHERE ENAME = 'JONES';

SELECT ENAME, SAL
FROM EMP
WHERE SAL > 2975;

-- 쿼리 중첩

SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT SAL
FROM EMP
WHERE ENAME = 'JONES');

-- Q2. 직업이 'SALESMAN'인 사원과 같은 월급을 받는 사원의 이름과 월급을 출력하시오.
SELECT ENAME,SAL
FROM EMP
WHERE SAL IN (SELECT SAL
				FROM EMP
				WHERE JOB ='SALESMAN');
-- Q3. 부서번호가 10번인 사원들과 같은 월급을 받는 사원의 이름과 월급을 출력하시오.

SELECT ENAME, SAL
FROM EMP
WHERE SAL IN (SELECT SAL
				FROM EMP
				WHERE DEPTNO ='10');

-- Q4. 직업이 'CLERK'인 사원과 같은 부서에서 근무하는 사원의 이름, 월급, 부서번호를 출력하시오.

SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO
				FROM EMP
				WHERE JOB ='CLERK');

-- Q5. 'CHICAGO'에서 근무하는 사원들과 같은 부서에서 근무하는 사원의 이름과 월급을 출력하시오.

SELECT ENAME, SAL
from EMP
WHERE DEPTNO IN (SELECT DEPTNO
					FROM DEPT
					WHERE LOC = 'CHICAGO');
                    
-- Q5-1. 'CHICAGO'에서 근무하는 사원들과 [같은 부서]에서 근무하는 사원의 이름과 월급을 출력하시오.
-- CNT로 출력

SELECT ENAME, SAL, (SELECT COUNT(*)
from EMP
WHERE DEPTNO IN (SELECT DEPTNO
					FROM DEPT
					WHERE LOC = 'CHICAGO')
                    ) AS COUNT
                    
From EMP
WHERE DEPTNO IN (SELECT DEPTNO
					FROM DEPT
					WHERE LOC = 'CHICAGO');
                    
                    
-- Q6. 부하직원이 있는 사원의 사원번호와 이름 출력 ! - > 자기자신이 관리자이면 된다


SELECT EMPNO, ENAME
FROM EMP
WHERE EMPNO IN (SELECT MGR
				FROM EMP);
                
-- Q7 부하직원이 없는 사원 사원번호이름출력

SELECT EMPNO, ENAME
FROM EMP
WHERE EMPNO NOT IN (SELECT IFNULL(MGR,0)
				FROM EMP);
                
SELECT EMPNO, ENAME
FROM EMP
WHERE EMPNO != ALL (SELECT IFNULL(MGR,0)
				FROM EMP);
                
                
-- Q8.  KING에게 보고하는 사원의 이름과 월급 출력
-- MG이 KING인 사원의 이름과월급

SELECT ENAME,SAL
FROM EMP
WHERE MGR = (SELECT EMPNO
				FROM EMP
				WHERE ENAME ='KING');
                
-- Q9. 20번 부서의 사원중 가장 많은 월급 받는사원들
-- 보다 더많은 월급을 받는 사원 이름과 월급 출력.

SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT MAX(SAL)
				FROM EMP
				WHERE DEPTNO = 20
                );
                
-- Q9- 1. 20번 부서의 사원중 가장 많은 월급 받는사원들
-- 보다 더많은 월급을 받는 사원 이름과 월급 출력. (ALL ANY 사용)

SELECT ENAME, SAL
FROM EMP
WHERE SAL > ALL( SELECT SAL
				FROM EMP
				WHERE DEPTNO = 20);
        
-- Q10 --> Q9와반대        
SELECT ENAME, SAL
FROM EMP
WHERE SAL > ANY( SELECT SAL
				FROM EMP
				WHERE DEPTNO = 20);
                
SELECT ENAME, SAL
FROM EMP
WHERE SAL > 	( SELECT MIN(SAL)
				FROM EMP
				WHERE DEPTNO = 20);         


-- Q11( 직업이 SALESMAN인 사원증 가장많은월급보다 너많은월급 (MAX없이)

SELECT ENAME, SAL
FROM EMP
WHERE SAL > ALL (SELECT SAL
					FROM EMP
					WHERE JOB = 'SALESMAN');
                    
-- Q12 ( 직업이 SALESMAN인 사원증 가장적은월급보다 더적은월급 (MAX없이)

SELECT ENAME, SAL
FROM EMP
WHERE SAL < ALL (SELECT SAL
					FROM EMP
					WHERE JOB = 'SALESMAN');
                    
/*
  Recursive Common Table Expressions [계층 구조를 재귀적으로 탐색할 때 사용]   :  재귀적 CTE
  WITH RECURSIVE cte (n) AS
(
  SELECT 1
  UNION ALL
  SELECT n + 1 FROM cte WHERE n < 5
)
SELECT * FROM cte;
  */
	WITH RECURSIVE cte(n) AS
(
  SELECT 1
  UNION ALL
  SELECT n + 1 FROM cte WHERE n < 5
)
SELECT * FROM cte;
-- Q14) CTE 사용해서 MGR 상관부터 말단까지 구조를 탐색해보자.
-- [1] 최상의 정보 출력해보장.

WITH RECURSIVE EMP_RES AS (

	SELECT EMPNO, ENAME, MGR, 1 AS LEVEL
    FROM EMP
    WHERE MGR IS NULL
   UNION ALL
	
 SELECT E.EMPNO, E.ENAME, E.MGR , ET.LEVEL+1
 FROM EMP E
	   JOIN EMP_RES ET ON E.MGR = ET.EMPNO

)

SELECT EMPNO, ENAME, MGR, LEVEL
FROM EMP_RES
ORDER BY LEVEL, MGR, EMPNO;

-- Q14 -1 위 내용을 GetEmp_ReS procedure로출력
CALL 01_GetEmp_REs();

show create procedure 01_getemp_res;

-- Q15) CTE를 구구단 중 3단출력

WITH RECURSIVE GUGUDAN AS(
	SELECT 3 AS DAN, 1 AS NUM, 3*1 AS RESULT
    
    UNION ALL
    
    SELECT DAN, NUM+1, DAN * (NUM+1)
    FROM  GUGUDAN
    WHERE NUM<9
    )
    SELECT CONCAT(DAN, " * ", NUM , " = ", RESULT ) AS GUGUDAN_PRN
    FROM GUGUDAN;
    
call my_emp.03_gugudan(8);


-- Q16 ) CTE를 활용해서 피보나치수열계산해보장


WITH RECURSIVE FIBONACCI AS(
	-- [1] 초기값
    SELECT 0 AS N, 0 AS FIB, 1 AS PREV_FIB 
	UNION ALL
    -- [2] 재귀
    SELECT N+1, PREV_FIB AS FIB, FIB + PREV_FIB AS PREV_FIB
    FROM FIBONACCI
    WHERE N+1 < 10
)
	SELECT N+1 AS "항 번호", FIB AS "피보나치 수열값"
    FROM FIBONACCI;
  
  CALL 04_FIBONACCI(12);
  
-- MULTI COULUMN SUBQUERY
-- Q1 직업이 SALESMAN인 사원과 같이 근무하고
-- 같은 월급을 받는사람
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO
					FROM EMP
					WHERE JOB = 'SALESMAN')

AND
	SAL IN (SELECT SAL
			FROM EMP
			WHERE JOB = 'SALESMAN');

/*
ALLEN 1600.00 30
WARD 1250.00 30
MARTIN 1250.00 30
TURNER 1500.00 30 

*/

SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, SAL
							FROM EMP
							WHERE JOB = 'SALESMAN');




-- 서브 쿼리 사용법 
 -- 2)서브쿼리는 SELECT, INSERT, UPDATE, DELETE 문에서  WHERE, HAVING, FROM, SELECT절 등  위치에 사용
  -- SELECT절  서브 쿼리 사용방법
 /*
WHERE     :조건 비교용 하위 질의
HAVING     : 그룹 조건에 대한 비교
FROM     : 인라인 뷰(하위 결과셋을 테이블처럼)
SELECT     : 선택된 컬럼 값을 계산 또는 비교용 
 */
 
 --  CASE 1 ) 각 사원의 봉급이  그 사원이 속한  부서의 평균급여보다 얼마나 높은지 출력 해보자. 
	 SELECT ENAME,  SAL-( SELECT AVG(SAL)
						  FROM EMP
						  WHERE DEPTNO  = E.DEPTNO)  AS RES
	 FROM EMP E;
-- CASE 2)  사원의 이름과 모든 사원의 봉급의 합을  출력한 결과 
-- 전체 급여합
 SELECT ENAME ,  (SELECT  SUM(SAL)   FROM EMP   ) AS "TOTAL SAL"
 FROM EMP;
 
 -- CASE 3) 사원의 이름과 모든 사원의 봉급의 평균을 출력한 결과
 SELECT ENAME ,  (SELECT  AVG(SAL)   FROM EMP   ) AS "AVG SAL"
 FROM EMP;
 
 -- CASE 4) SELECT 에서 계산된 SAL의 별칭을 WHERE 절에서사용하고싶다 -> 쿼리를 재구성한다
 -- SELECT의 별칭을 WHERE에 사용하려면 -> 별칭은 SELECT 이후에 정의되므로 WHERE 절에서 직접 호출 xa
 -- 해결 : 서브쿼리 또는 CTE 사용
 
 -- 4-1) 서브쿼리 재구성
	SELECT *
    FROM (
		SELECT ENAME, (SELECT SUM(SAL) FROM EMP) AS MYSAL
        FROM EMP
	) AS SUBQUERY
    WHERE MYSAL > 2000;
    
    -- 4-2) cte사용
    WITH CTE AS (
		SELECT ENAME AS );
        
	-- 5) exists와 not exists를 사용하여 특정 조건이 충족되는지 여부만을 판단하는 논리적 테스트 구현
     -- exists를 사용해서 부서에 사원이 존재 하는지 확인후 부서명 출력
	
    SELECT DNAME
    FROM dept d
    WHERE EXISTS (SELECT 1
					FROM emp
					WHERE DEPTNO = d.DEPTNO);
                    
	SELECT DNAME
    FROM dept d
    WHERE EXISTS (SELECT *
					FROM emp
					WHERE DEPTNO = d.DEPTNO);
                    
-- 6) Correlated subqueries: 서브쿼리가 외부 쿼리의 컬럼을 참조하는 경우를 말하며
   -- 서브쿼리는 외부 쿼리의 각 행에 대해 반복적으로 실행된다. 
  -- 각 부서에서 가장 높은 급여를 받는 사원의 모든 내용을 출력 해보자.
  
  SELECT  *
  FROM EMP E1
  WHERE  SAL  =  (
                  SELECT MAX(SAL)
                  FROM EMP  E2
                  WHERE E1.DEPTNO = E2.DEPTNO
                 ) ;
###############################################
  SELECT  *
  FROM EMP E1
  WHERE  SAL  =  (
                  SELECT MAX(SAL)
                  FROM EMP
                  WHERE E1.DEPTNO = DEPTNO
                 ) ;
#####################  서브쿼리 안에서 JOIN하면 안돼요?
  SELECT  *
  FROM EMP E1
  WHERE  SAL  =  (
                  SELECT MAX(SAL)
                  FROM EMP E2
                  JOIN E1 USING(DEPTNO)
                 );
/* Error Code: 1146. Table 'my_emp.e1' doesn't exist    0.000 sec
서브쿼리가 외부쿼리의 별칭을 직접 참조 할 수 없다. !!!!1 */

-- 6-1))  JOIN 활용

SELECT *
FROM EMP E1 JOIN (
				SELECT DEPTNO, MAX(SAL) AS MAX_SAL
                FROM EMP
                GROUP BY DEPTNO ) E2 on E1.DEPTNO = E2.DEPTNO AND E1.SAL = E2.MAX_SAL;
                
-- 6-2) 윈도우 함수
USE MY_emp;
SELECT ENAME, SAL, DEPTNO
FROM (
		SELECT ENAME, SAL, DEPTNO, 
        RANK() OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) AS RNK
        FROM  EMP
        ) T
WHERE RNK = 1;


-- 7) 서브쿼리 내에서 LIMIT 절의 사용이 제한될 수 있다.
 -- 각 부서에서 월급이 가장 높은 상위 3명 사원번호, 이름, 봉급, 부서번호 출력
-- 각 부서별로 월급이 높은 순으로 정렬된 사원의 목록을 만든다 -> 상위 3명 추출한다

SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP E
WHERE (SELECT COUNT(*)
		FROM EMP E2
		WHERE E2.SAL > E.SAL AND E2.DEPTNO = E.DEPTNO ) < 3
ORDER BY 4, 3 DESC;		


####### HAVING 서브 쿼리를 확인 해보자. 
 -- Q1. HAVING 서브 쿼리 
 -- 평균 급여가 전체 평균 보다 더 높은 부서를 찾아 보자.
SELECT DEPTNO, AVG(SAL) as avg_salary
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) > (SELECT AVG(SAL) 
                    FROM EMP );

  -- Q2. HAVING 서브 쿼리 
  --  부서별로 사원 수가 전체 사원 수의 평균 보다 많은 부서를 찾아 부서번호, 직원수를 출력 해보자 
  SELECT DEPTNO, COUNT(EMPNO) AS NUM_COUNT
  FROM EMP
  GROUP BY DEPTNO
  HAVING COUNT(EMPNO)  >  ( SELECT AVG(NUM_COUNT)
                            FROM (SELECT COUNT(EMPNO) NUM_COUNT
                            FROM EMP
                            GROUP BY DEPTNO ) as AVG_DEPT);

-- 1 . 모든 부서별 사원 수를 계산
SELECT COUNT(EMPNO) NUM_COUNT
                    FROM EMP
                    GROUP BY DEPTNO;   -- 결과   3, 5, 6 
-- 2. 평균 값을 구한다.
SELECT AVG(NUM_COUNT)  -- AVG(3,5,6 )   -> 4.6667
         FROM (SELECT COUNT(EMPNO) NUM_COUNT
                FROM EMP
                GROUP BY DEPTNO 
                ) as AVG_DEPT;

 
 -- Q3. HAVING 서브 쿼리 
  -- 부서별 사원들의  최고 급여가  각 부서별 최고 급여의 평균보다  부서를 찾아 부서번호, 최고급여를 출력 해보자
  -- 주 쿼리 EMP 테이블에서 부서별 그룹화하고 각 그룹의 최고 급여를 계산한 다음 비교한다.
  -- HAVING 절에서 사용된 서브쿼리는 먼저 모든 부서의 최고 급여를 계산하고 -> 평균값을 계산한다. 

USE MY_EMP;

  -- 1. 모든 부서의 최고 급여를 계산
     SELECT MAX(SAL) as max_salary 
     FROM EMP 
     GROUP BY DEPTNO
     HAVING COUNT(EMPNO) > ( SELECT AVG(NUM_COUNT)
								FROM (SELECT COUNT(EMPNO) NUM_COUNT
								FROM EMP
                                GROUP BY DEPNO) as AVG_DEPT);  -- 5000, 3000, 2850

  -- 2. 평균값을 계산한다. 
  SELECT AVG(max_salary) 
  FROM
     (SELECT MAX(SAL) as max_salary 
     FROM EMP GROUP BY DEPTNO) AS  DEPT_AVG_SAL ;  -- 3616

  -- 3. 병합
SELECT DEPTNO, MAX(SAL) as hi_sal  -- 10 , 5000 
FROM EMP
GROUP BY DEPTNO
HAVING MAX(SAL) > ( SELECT AVG(max_salary) 
                    FROM (SELECT MAX(SAL) as max_salary 
                         FROM EMP 
                         GROUP BY DEPTNO) AS  DEPT_AVG_SAL);
                         
					
SELECT D.DNAME, E.MAX_SAL
FROM DEPT D
JOIN
	(SELECT DEPTNO, MAX(SAL) AS MAX_SAL
		FROM EMP
        GROUP BY DEPTNO) E
ON D.DEPTNO = E.DEPTNO;

SELECT DEPTNO, MAX(SAL) AS MAX_SAL
		FROM EMP
		GROUP BY DEPTNO;
        
        
DROP TABLE T1;

CREATE TABLE t1(
		s1 INT,
        s2 CHAR(5)
        ,s3 FLOAT);
        
DESC T1;

INSERT INTO t1 VALUES(1,'1',1.0);
INSERT INTO t1 VALUES(2,'2',2.0);

-- 내용 확인
SELECT *
FROM T1;

SELECT sb1,sb2,sb3
FROM (SELECT s1 AS sb1, s2 AS sb2, s3*2 AS sb3
	From t1) AS sb
WHERE sb1 > 1;

SELECT *
FROM SB;

-- Q3. 각 부서별 평균 급여 구하고 =DEPT_AVG, 
-- 평균급여가 2000 이상인 부서의 번호와 평균 급여출력

SELECT DEPT_AVG.DEPTNO, DEPT_AVG.AVG_SAL
FROM ( SELECT DEPTNO, AVG(SAL) AS AVG_SAL
		FROM EMP
        GROUP BY DEPTNO
	) DEPT_AVG
    
WHERE DEPT_AVG.AVG_SAL >= 2000;

-- Q4. 인라인 뷰를 사용해서 사원의 이름 급여 EMP
-- 전체 사원의 평균 월급 출력해보자,

SELECT E.ENAME, E.SAL, AA.AVG_SAL
FROM EMP E
	JOIN (SELECT AVG(SAL) AS AVG_SAL
		FROM EMP) AA;