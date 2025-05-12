-- 1) CREATE TABLE로 새 테이블 만들기
-- 2) CREATE TABLE에서 기본 키 (PRIMARY KEY) 제약 조건 지정
-- 3) CREATE TABLE에서 고유 키(UNIQUE KEY) 제약 조건 지정
-- 4) CREATE TABLE에서 검사 (CHECK) 제약 조건 지정
-- 5) CREATE TABLE에서 열에 기본값 지정  DEFAULT 
-- 6) CREATE TABLE에서 외래 키 (FOREIGN KEY) 제약 조건 지정

--  << 학생 정보를 유지하기 위한 students 테이블 생성 >>- 

CREATE DATABASE  STUDENTS;
USE STUDENTS;
DROP TABLE STUDENTS;
-- 1) CREATE TABLE로 새 테이블 만들기

CREATE TABLE students(
	student_id Int,
    student_number VARCHAR(10),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    middle_name VARCHAR(50),
    birthday DATE,
    gender ENUM('M','F'),
    paid_flag BOOL,
    PRIMARY KEY (student_id)
);

DESC Students;

INSERT INTO students
VALUES 
	(1, '1', '1', '1', '1', NOW(), 'M', TRUE),
	(2, '1', '1', '1', '1', NOW(), 'F', 0),
	(3, '1', '1', '1', '1', NOW(), 'F', FALSE),
	(4, '1', '1', '1', '1', NOW(), 'M', TRUE);
    
SELECT *
FROM STUDENTS;

-- Q2 - 1 데이터 입력
-- 중복데이터 X + NOT NULL = pk

CREATE TABLE students02(
	student_id Int,
    student_number VARCHAR(10),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    middle_name VARCHAR(50),
    birthday DATE,
    gender ENUM('M','F'),
    paid_flag BOOL,
    PRIMARY KEY (student_id)
);
USE students;

INSERT INTO students02
VALUES (NULL, '1', '1', '1', '1', NOW(), 'M', TRUE);


SHOW CREATE TABLE STUDENTS; 

 SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE 
 FROM information_schema.TABLE_CONSTRAINTS  
WHERE TABLE_SCHEMA = 'STUDENTS'  AND TABLE_NAME = 'STUDENTS02';

CREATE TABLE students03(
	student_id INT,
    student_number VARCHAR(10),
    PRIMARY KEY (student_id, student_number));
    
INSERT INTO students03
VALUES (1, 1),(1, 2),(1, 3),(1, 4);

INSERT INTO students03
VALUES (2, 1),(2, 2),(2, 3),(2, 4);

SELECT *
FROM STUDENTS03;

-- Q3-2 제약조건 확읺 하자.

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, CONSTRAINT_CATALOG
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABE_SCHEMA = 'STUDENTS' AND TABLE_NAME = 'STUDENTS03';

DESC information_schema.TABLE_CONSTRAINTS;

-- Q4 자동증가 구현하는 제약조건 확인
CREATE TABLE students04(
	student_id INT AUTO_INCREMENT,
    student_number VARCHAR(10),
    PRIMARY KEY (student_id)
    );
DESC STUDENTS04;

INSERT INTO students04(student_number) VALUES (10), (20), (30), (40);

SELECT * FROM STUDENTS04;

-- Q4-1) 테이블 수정하자 자동증가 초기값 100으로

ALTER TABLE Students04 AUTO_INCREMENT = 100;

INSERT INTO students04(student_number) VALUES (10), (20), (30), (40);

SELECT * FROM students04;

----- 번외편

CREATE TABLE t1(
	c1 INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    c2 CHAR(1)
    ) ENGINE = INNODB;
    
DESC T1;

INSERT INTO t1 (c1, c2) VALUES (1,'a'), (NULL, 'b'), (5,'c'), (NULL, 'd');

INSERT INTO t1 (c1, c2) VALUES (11,'a'), (NULL, 'b'), (15,'c'), (NULL, 'd');
SELECT *
FROM T1;

SHOW TABLE STATUS LIKE 't1';
SHOW TABLE STATUS LIKE 'students04';

ALTER TABLE T1 MODIFY COLUMN c1 INT;
ALTER TABLE T1 DROP PRIMARY KEY;    


-- Q5. 자동증가 구현하는 제약조건을 확인 해보자 . PK도 걸고 자동증가도 걸고. 기본값도 지정하세요.

CREATE TABLE students05(
	student_id INT AUTO_INCREMENT,
    student_number VARCHAR(10) DEFAULT 'ABC',
    PRIMARY KEY (student_id, student_number)
    );

DESC STUDENTS05;

INSERT INTO students05
		VALUES (1, 10), (2, 20), (3, 30), (4, 40);
        
INSERT INTO students05(student_id) VALUES(1);

SELECT * FROM students05;


CREATE TABLE students06 (
	student_id INT AUTO_INCREMENT,
    student_number VARCHAR(10) DEFAULT 'ABC',
    student_name varchar(50),
    PRIMARY KEY (student_id, student_number)
    );
DESC STUDENTS06;
insert into students06 (student_name)
		values(1);
        
SELECT * FROM STUDENTS06;

ALTER TABLE students06 MODIFY COLUMN student_id INT;

-- Q6--1 기본키 삭제

ALTER TABLE students06
DROP PRIMARY KEY;

-- Q6-2 DEFAULT 삭제

ALTER TABLE students06
ALTER student_number DROP DEFAULT;


-- Q6-3 삭제된 DEFAULT 추가alter

ALTER TABLE Students06
ALTER student_number SET DEFAULT 'ABC';


-- Q7. 
-- 3) CREATE TABLE에서 고유 키(UNIQUE KEY) 제약 조건 지정 -> 중복데이터 X +  NULL 허용
-- 4) CREATE TABLE에서 검사 (CHECK) 제약 조건 지정 : 범위 지정


CREATE TABLE students07(
	student_id INT,
    student_nubmer VARCHAR(10),
    birthday DATE,
    UNIQUE KEY (student_id),
    CHECK (birthday >= '2001-01-01'),
    CHECK (student_number >= 10)
    );
    
DESC students07;

INSERT INTO students07(student_id) VALUES(NULL);
INSERT INTO students07(student_id, birthday) VALUES(1,NOW());
INSERT INTO students07(student_id, birthday) VALUES(2,NOW());
INSERT INTO students07(student_id, birthday) VALUES(3,NOW());
INSERT INTO students07(student_id, birthday) VALUES(3,'1999-01-01'); -- STUDENT07_CHK_1 에러

select *
from students07;


CREATE TABLE students071(
	student_id INT,
    student_number VARCHAR(10),
    birthday DATE,
    UNIQUE KEY (student_id),
    CHECK (birthday >= '2001-01-01'),
    CHECK (student_number >= 10)
    );
-- 체크 제약조건 확인한는법

SELECT CONSTRAINT_NAME, CHECK_CLAUSE
FROM information_schema.CHECK_CONSTRAINTS;

ALTER TABLE students071
DROP CHECK students071_CHK_2;

-- Q7-2 테이블의 제약조건을 확인후 남아있는 키값 삭제하자
-- DROP INDEX 이다.
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_NAME = 'students071';

ALTER TABLE students071
DROP INDEX student_id;    

SHOW KEYS FROM students071;

-- Q8 참조형 테이블 생성해보자
-- CREATE TABLE에서 외래키 제약조건지정
DROP TABLE STUDENTS05;
	CREATE TABLE students05(
		student_id INT AUTO_INCREMENT,
        student_Number VARCHAR(10) DEFAULT 'ABC',
        PRIMARY KEY (student_id)
        );
        
DESC STUDENTS05;

INSERT INTO STUDENTS05 VALUES(1,1);
INSERT INTO STUDENTS05 VALUES(2,2);

SELECT * FROM STUDENTS05;

--  현재 STUDENTS_MY 테이블의 student_id를 students05의 student_id로 참조 시키자.

CREATE TABLE students_My(
	Student_id INT,
    FOREIGN KEY(student_id) REFERENCES STUDENTS05(student_id)
    );
    
    DESC students_my;
SHOW KEYS FROM students_MY;    
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema._CONSTRAINTS
WHERE TABLE_NAME = 'students_MY';

    
SELECT CONSTRAINT_NAME, UPDATE_RULE, DELETE_RULE, REFERENCED_TABLE_NAME
FROM information_schema.REFERENTIAL_CONSTRAINTS
WHERE TABLE_NAME = 'students_MY';
    
desc information_schema.REFERENTIAL_CONSTRAINTS;

-- 데이터 입력 후 확인!!
INSERT INTO STUDENTS_MY VALUES(1);
INSERT INTO STUDENTS_MY VALUES(NULL);
INSERT INTO STUDENTS_MY VALUES(3); -- Error
SELECT * FROM STUDENTS_MY;