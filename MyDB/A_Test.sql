use my_emp;
CREATE DATABASE TEST;
DROP DATABASE TEST;
/*
SELECT 컬럼명 ..
FROM 테이블명 ..
*/

#Q1. 사원 테이블 전체 인원 출력
SELECT *
FROM EMP;

#Q2 .사원테이블에서 사원 이름, 번호 출력
SELECT ENAME, EMPNO
FROM EMP;

#Q5 . 부서 테이블의 부서이름 부서 번호 출력하자
SELECT DNAME, DEPTNO
FROM DEPT;


#Q7. 사원의 이름과 부서 이름 부서의 위치 출력하자.
SELECT ENAME, DNAME, LOC
FROM EMP, DEPT;

# EMP DEPT 에 둘다 DEPTNO colmun이 존재할떄 에러! ( Error Code: 1052. Column 'DEPTNO' in field list is ambiguous	0.000 sec
SELECT DEPTNO
FROM EMP, DEPT;

/* 컬럼 별칭, 테이블 별칭 줘보자
	SELECT 칼럼  [as] 별칭
    FROM 테이블명 별칭;
    WHERE 조건식 ; 
    비교 연산의 결과 IN _ (DATA OR ,,,, 또는) NOT IN, IS NULL , IS NOT NULL
    AND, OR
    BETWEEN AND
    날짜비교
*/

#CASE 1
SELECT EMP.DEPTNO
FROM EMP, DEPT;

#CASE 2
SELECT E.DEPTNO
FROM EMP E, DEPT D;

#CASE 3
SELECT E.DEPTNO
FROM EMP AS E, DEPT AS D;

#Q9. 사원이름 부서번호 부서이름 출력

SELECT E.ENAME AS 사원이름, E.DEPTNO AS "부서 번호", D.DNAME AS "부서   이름1"
FROM EMP E, DEPT D;

SELECT E.ENAME AS "사원 이름" , E.DEPTNO AS "부서 번호", D.DNAME AS 부서이름2
FROM EMP E, DEPT D;

SELECT EMP.ENAME AS "사원 이름" , EMP.DEPTNO AS 부서번호, DEPT.DNAME AS 부서이름3
FROM EMP, DEPT;

/* 중복 데이터 제거
DISTINCT : 지정한 칼럼 값이 완전히 같을떄 중복제거
 1개일때는 해당 칼럼값 비교
 2개이상일때 컬럼의 조합이 같아야 중복
*/

#Q10 사원테이블에서 교유 직업명만 출력
SELECT DISTINCT JOB
FROM EMP;

#Q11
SELECT DISTINCT JOB, DEPTNO
FROM EMP;

#Q12 사원 이름 사원 봉금 사원 연봉을 연봉이라고 출력
SELECT ENAME, SAL, SAL * 12 AS 연봉
FROM EMP;

#Q13. 사원의 이름, 사원 봉급 출력하되, 봉급 = 봉급 + 커미션 계산해서 봉금 이라고출력
SELECT ENAME, SAL, COMM, IFNULL(COMM,0) + SAL AS 봉급
FROM EMP;

/*
연산시 NULL + 임의의값은 무조건 NULL 로 리턴됨!
 -IFNULL(널이있는컬럼, 초기값)
 -IS NULL -> WHERE 문과 같이 사용
 -COALESCE()
*/

#Q14 사원 테이블에서 사원의 봉급이 1000 이상인 사원 이름 봉급 커미션 출력
SELECT ENAME, SAL, COMM
FROM EMP
WHERE SAL >= 1000;

#Q14 사원 테이블에서 사원의 커미션이 500 이상인 사원 이름 봉급 커미션 출력
SELECT ENAME, SAL, COMM
FROM EMP
WHERE COM >+ 500;

#Q15 커미션이 NULL 이 아닌 사원의 이름 커미션 출력
SELECT ENAME, COMM
FROM EMP
WHERE COMM IS NOT NULL;

#Q16 부서 번호가 10 또는 20인 사원의 모든 정보 출력
SELECT *
FROM EMP
WHERE DEPTNO IN(10,20); ## 10 OR 20

#Q17 부서 번호가 10 또는 20인 사원의 제외하고 모든 정보 출력
SELECT *
FROM EMP
WHERE DEPTNO NOT IN(10,20); ## NOT 10 OR 20

#Q18 봉급이 2000 이상 5000 이하인 사원 이름과 직업 봉급 출력
SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL >= 2000 AND SAL <= 5000;

#Q19 봉급이 2000 이상 5000 이하인 사원 이름과 직업 봉급 출력
SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL BETWEEN 2000 AND 5000;  # BETWEEN AND 활용

#Q20 날짜 수치변환 가능하다. 날짜 데이트를 확인 해봅시다
# EMP 테이블 구조 확인.
DESC EMP;

# EMP 테이블의 모든 내용을 TEST테이블로 생성하자
CREATE TABLE TEST
AS
SELECT * FROM EMP;

# 확인
SELECT * FROM TEST;

DESC TEST; # 특이사항 -> 제약 조건은 복사되지 않는다.

# EMP 테이블의 사원이름과 입사일을 TEST02 테이블로alter
CREATE TABLE TEST02
AS
SELECT ENAME, HIREDATE
FROM EMP;

DESC TEST02;


# EMP 테이블의 사원의 이름과 입사일을 TEST03 테이블로 생성
/*CREATE TABLE TEST03(사원이름, 입사일) # MYSQL에서는 COLUMN명 직접지정 불가
AS
SELECT ENAME, HIREDATE
FROM EMP;

DESC TEST03;*/

# 데이터는 빼고 구조만 가져오겠다
create TABLE TEST03 LIKE EMP;

# TEST02 에 데이터 입력해봅시다. ( INSERT INTO 테이블이름(컬럼명,,,) VALUES(,,,) ) 
# 컬럼명 AB VALUESCD 일씨 A에 C, B에 D 들어가고 
# 컬럼명 안줄시 모든컬럼에 VALUES값 들어감
DESC TEST02;


INSERT INTO TEST02 
VALUES('ABC','1980-01-01');

SELECT *
FROM TEST02;

## TEST02의입사년도가 1981년도 이후인 목록!
#DATE + 년 월 일

SELECT *
FROM TEST02
WHERE HIREDATE > '81/01/01';


