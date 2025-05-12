use mywork;
-- 1. 게시판에서 사용자 ID, 등록 날짜, 게시판 제목, 내용을 조회하세요. 

SELECT USER_ID, REG_DATE, TITLE, CONTENT
FROM board;

-- 2. 사용자 ID, 등급, 게시판 제목, 내용을 조회하되, 삭제되지 않은 게시글만 조회하세요. 

SELECT USER_ID, GRADE, TITLE, CONTENT
FROM BOARD JOIN MEMBER USING(USER_ID)
WHERE BOARD.IS_DEL = 0;

-- 3. 사용자 ID, 역할, 게시판 제목, 내용을 조회하되, Socrates가 작성한 게시글만 조회하세요.  

SELECT USER_ID, GRADE, TITLE, CONTENT
FROM BOARD JOIN MEMBER USING(USER_ID)
WHERE USER_ID = 'Socrates';

-- 4. 2023년 12월에 탈퇴한 회원들의 회원 아이디(User ID), 이메일(Email), 그리고 회원 등급
-- (Grade)을 조회하세요.  

SELECT USER_ID, EMAIL, GRADE
FROM MEMBER_INFO JOIN MEMBER USING(USER_ID)
WHERE MEMBER_INFO.LEAVE_DATE BETWEEN '2023-12-01' AND '2023-12-31';

SELECT USER_ID, EMAIL, grade
FROM member
JOIN member_info USING(USER_ID)
WHERE member_info.LEAVE_DATE BETWEEN '2023-12-01' AND '2023-12-31';

-- 5. 회원들 중에서 '디디의 우산 :황정은 연작소설'를 대출한 이력이 있는 회원의 회원 아이디
-- (User ID),대출 도서 수를 조회하세요. 

SELECT USER_ID, rent_book_cnt
FROM rent_master 
WHERE title like '%디디의 우산%';

SELECT USER_ID, COUNT(BK_IDX) AS 대출횟수
FROM member
JOIN rent_master USING(USER_ID)
JOIN rent_book USING(RM_IDX)
JOIN book USING(BK_IDX)
WHERE book.TITLE = '디디의 우산 :황정은 연작소설'
GROUP BY member.USER_ID;

-- 6. 대출 도서 중에서 등록일이 2023년 6월 10일 이후인 도서의 대출 번호(Rent Master Index), 
-- 대출자 이름(User ID), 대출자 가입일자, 대출건 제목(Title)을 조회하세요. 

SELECT RM_IDX, USER_ID, MEMBER_INFO.REG_DATE, TITLE
FROM MEMBER_INFO 
JOIN RENT_MASTER USING (USER_ID)
WHERE RENT_MASTER.REG_DATE > '2023-06-10';

SELECT DISTINCT RM.RM_IDX, RM.USER_ID, MI.REG_DATE, RM.TITLE
FROM rent_master RM
JOIN member_info MI USING(USER_ID)
WHERE RM.REG_DATE >= '2023-06-10';


-- 7. 대출 번호, 대출자 이름, 대출건 제목, 그리고 대출일자를 조회하세요. 단, 대출 도서가 모두 
-- 반납되지 않았고, 회원 등급이 'ROLE_USER'인 회원만 포함시켜주세요. 

SELECT RM_IDX, USER_ID, TITLE, REG_DATE
FROM MEMBER JOIN RENT_MASTER USING (USER_ID)
WHERE MEMBER.GRADE = 'ROLE_USER' AND IS_RETURN = 0;


SELECT RM.RM_IDX, M.USER_ID, RM.TITLE, RM.REG_DATE 
FROM rent_master RM JOIN member M USING(USER_ID)
WHERE RM.IS_RETURN = 0 AND M.GRADE = 'ROLE_USER';
-- 8. 도서를 2권 이상 대출한 회원들의 회원 아이디, 이메일, 그리고 대출도서 수를 조회하세요. 

SELECT member.USER_ID, EMAIL, rent_Master.RENT_BOOK_CNT
FROM rent_master join member using (user_id)
where rent_master.RENT_BOOK_CNT >= 2
ORDER BY rent_master.rent_book_cnt DESC;

SELECT M.USER_ID, M.EMAIL, COUNT(RB.BK_IDX) AS 대출도서수
FROM member M
JOIN rent_master RM USING(USER_ID)
JOIN rent_book RB USING(RM_IDX)
GROUP BY M.USER_ID
HAVING COUNT(RB.BK_IDX) >= 2;


-- 9. 대출 도서 중에서 대출일로부터 3일 이내에 반납을 완료한 도서의 대출도서번호, 대출자 이름, 
-- 도서 제목, 반납일자를 조회하세요

SELECT RB_IDX, USER_ID, TITLE, RENT_BOOK.RETURN_DATE
FROM RenT_BOOK join rent_master using (rm_Idx)
where DATEDIFF(rent_book.return_date,rent_book.reg_date) <= 3;

SELECT DISTINCT RB.RB_IDX, M.USER_ID, B.TITLE, RB.RETURN_DATE FROM rent_master RM
JOIN rent_book RB USING(RM_IDX)
JOIN member M USING(USER_ID)
JOIN BOOK B USING(BK_IDX)
WHERE DATEDIFF(RB.RETURN_DATE, RB.REG_DATE) <= 3;

-- 10. 탈퇴하지 않은 회원 중에서 도서를 가장 많이 대출한 회원의 아이디, 이메일, 대출도서 수

SELECT USER_ID, EMAIL, rent_master.RENT_BOOK_CNT
from rent_master join member using (user_id)
where RENT_BOOK_CNT = (SELECT MAX(RENT_BOOK_CNT)
					from rent_master
					where is_leave = 0);
                    
SELECT M.USER_ID, M.EMAIL, COUNT(RB.BK_IDX) AS 대출도서수 FROM member M
JOIN rent_master RM USING(USER_ID)
JOIN rent_book RB USING(RM_IDX)
WHERE M.IS_LEAVE = 0 
GROUP BY M.USER_ID
ORDER BY COUNT(RB.BK_IDX) DESC LIMIT 1;                    
                    
-- 11. 대출 도서 중에서 ‘연체’ 상태인 도서의 대출 번호, 대출자 아이디, 대출건 제목, 대출일 대출
-- 도서 상태를 조회하세요. 

SELECT DISTINCT rent_book.RM_IDX, rent_master.USER_ID, TITLE, rent_book.REG_DATE, CODE.INFO
from rent_book 
join code on rent_book.state = code.code 				
join rent_master on rent_book.RM_IDX = rent_master.rm_Idx
WHERE code.info = '연체';

SELECT DISTINCT RM.RM_IDX, M.USER_ID, RM.TITLE, RM.REG_DATE, C.INFO 
FROM rent_master RM
JOIN rent_book RB USING(RM_IDX)
JOIN member M USING(USER_ID)
JOIN CODE C ON C.CODE = RB.STATE
WHERE C.INFO = '연체';

-- 12. 대출 도서 중에서 ‘반납' 상태이면서 반납일자가 ‘2023-06-15’ 이전인 도서의 대출 도서 번호, 
-- 대출자 이름, 대출 도서 제목, 그리고 반납일자를 조회하세요. 

SELECT rb.RB_IDX, rm.USER_ID, rm.TITLE, rb.RETURN_DATE
FROM rent_book rb
join rent_master rm on rb.rm_idx = rm.rm_idx
join code c on rb.state = c.info
WHERE c.info = '반납' AND  rb.return_date < '2023-06-15';

SELECT RB.RB_IDX, M.USER_ID, B.TITLE, RB.RETURN_DATE
FROM rent_master RM
JOIN rent_book RB USING(RM_IDX)
JOIN member M USING(USER_ID)
JOIN book B USING(BK_IDX)
JOIN code C ON C.CODE = RB.STATE
WHERE C.INFO = '반납'
  AND RB.RETURN_DATE <= '2023-06-15';


-- 13. 회원 등급이 'ROLE_USER'이면서 대출을 한 이력이 남아있고, 대출도서를 연체한 이력이 없
-- 는 회원들의 회원 아이디(User ID), 이메일(Email)을 조회하세요. 

SELECT m.USER_ID, m.EMAIL
FROM MEMBER m
JOIN rent_master rm on m.user_id = rm.user_id
JOIN rent_book rb on rm.rm_idx = rb.rm_idx 
WHERE m.GRADE = 'ROLE_USER' AND rm.IS_RETURN = 0 AND rb.state != 'RE02';

SELECT m.USER_ID, m.EMAIL
FROM member m
JOIN rent_master rm ON m.USER_ID = rm.USER_ID
WHERE m.GRADE = 'ROLE_USER' 
  AND m.IS_LEAVE = 0
  AND NOT EXISTS (
      SELECT 1
      FROM rent_master rm2
      JOIN rent_book rb2 ON rm2.RM_IDX = rb2.RM_IDX
      WHERE rm2.USER_ID = m.USER_ID
        AND rb2.STATE = 'RE02'  -- 연체 상태 코드
);


-- 14. 대출 도서 중에서 'RE01' 상태인 도서 중에 가장 빨리 대출된 도서의 대출 번호, 대출자 아이
-- 디, 대출 도서 제목 그리고 대출일자를 조회하세요.

SELECT rb.rm_idx, rm.user_id, rm.title, rb.reg_date
FROM rent_book rb
JOIN code c on rb.state = c.code
JOIN rent_master rm on rb.rm_idx = rm.rm_idx
WHERE c.code = 'RE01'
ORDER BY rb.reg_Date ASC
LIMIT 1;

SELECT RM.RM_IDX, M.USER_ID, RM.TITLE, RM.REG_DATE
FROM rent_master RM
JOIN rent_book RB USING(RM_IDX)
JOIN member M USING(USER_ID)
WHERE RB.STATE = 'RE01'
ORDER BY RB.REG_DATE ASC
LIMIT 1;

-- 15. 도서가 존재하는 도서 카테고리별 도서 재고의 합을 조회 하시오.  

SELECT CATEGORY, CODE.INFO, SUM(book_amt) as '도서재고량'
FROM book JOIN CODE on book.category = code.code
GROUP BY CATEGORY;

SELECT CATEGORY, C.INFO, SUM(BOOK_AMT) AS '도서재고량'
FROM BOOK B
JOIN CODE C ON B.CATEGORY = C.CODE 
GROUP BY B.CATEGORY;
-- 16. 도서카테고리의 하위 카테고리인 문학카테고리에 속하는 모든 카테고리를 조회 하시오. 

SELECT c.CODE, c.UPPER_CODE, c.INFO, d.CODE, d.UPPER_CODE, d.INFO
FROM CODE c 
join code d on d.code = c.upper_code
where c.upper_code = 'B0';

SELECT * FROM CODE C 
JOIN CODE C2 ON C.UPPER_CODE = C2.CODE
WHERE C2.INFO = '문학';

-- 17. 회원 중에서 마지막 로그인 일자가 2023년 12월인 가진 회원이 대출한 대출도서건수를 조회

SELECT mi.USER_ID, rm.RENT_BOOK_CNT as ADMIN_RENT_COUNT
FROM member_info mi 
join rent_master rm on rm.user_id = mi.user_id
where mi.login_date between '2023-12-01' AND '2023-12-31';

SELECT MI.USER_ID, COUNT(RB.RB_IDX) AS RENT_BOOK_CNT
FROM MEMBER_INFO MI
JOIN RENT_MASTER RM USING(USER_ID)
JOIN RENT_BOOK RB USING(RM_IDX)
WHERE MI.LOGIN_DATE BETWEEN '2023-12-01' AND '2023-12-31'
GROUP BY MI.USER_ID;


-- 18. 대출죽인 책중에서 연체상태인 책 조회
SELECT COUNT(*) as 'OVERDUE_COUNT'
FROM code c join rent_book rb on rb.state = c.code
WHERE c.info = '연체';

-- 19. 모든 도서카테고리의 도서 재고 합을 구하시오.
SELECT IFNULL(SUM(book_amt),0) as 도서재고, c.info
FROM code c 
LEFT join book b on c.code = b.category
WHERE c.upper_code = 'B0' OR c.upper_code = 'B1'
GROUP BY c.info;

SELECT IFNULL(SUM(BOOK_AMT),0) AS 도서재고, C.INFO
FROM BOOK B
RIGHT JOIN CODE C ON B.CATEGORY = C.CODE
WHERE C.UPPER_CODE IN(SELECT CODE FROM CODE WHERE UPPER_CODE = 'B')
GROUP BY C.INFO;

-- 20. 모든 도서의 제목과 카테고리, 상위카테고리를 조회 하시오. 

SELECT b.TITLE, c.info , d.info FROM book b 
join code c on c.code = b.category
join code d on c.upper_code = d.code;
    
SELECT TITLE, C.INFO, C2.INFO FROM BOOK B
JOIN CODE C ON B.CATEGORY = C.CODE
JOIN CODE C2 ON C.UPPER_CODE = C2.CODE;


 
