USE world;

-- Q1. 모든 도시(city)의 이름과 해당 국가(country)의 이름을 출력하되, 각각 City와 Country라는 별칭으로 표시하자.

-- ANSI
SELECT CITY.name as 'City', COUNTRY.NAME as 'Country'
FROM CITY 
JOIN COUNTRY ON CITY.CountryCode = COUNTRY.Code;
-- MYSQL
SELECT CITY.name as 'City', COUNTRY.NAME as 'Country'
FROM CITY , COUNTRY
WHERE CITY.CountryCode = COUNTRY.Code;

-- Q2. 인구 수가 100만 이상인 도시 이름, 인구, 해당 국가 이름을 출력하되, 도시의 인구가 기준이다.
-- ANSI
SELECT CITY.name as '도시 이름', CITY.Population as '인구', COUNTRY.NAME as '국가 이름'
FROM CITY
JOIN COUNTRY ON CITY.CountryCode = COUNTRY.code 
WHERE CITY.population >= 1000000
ORDER BY CITY.population DESC;
-- MYSQL
SELECT CITY.name as '도시 이름', CITY.Population as '인구', COUNTRY.NAME as '국가 이름'
FROM CITY, COUNTRY
WHERE CITY.population >= 1000000 AND CITY.Countrycode= Country.code
ORDER BY CITY.population DESC;
-- Q3. 도시 이름, 국가 코드, 해당 도시가 속한 국가에서 사용되는 언어를 출력하자.
-- ANSI
SELECT CITY.name as '도시', CITY.CountryCode as '코드', Countrylanguage.language as '언어'
FROM CITY
JOIN COUNTRYLANGUAGE ON CITY.CountryCode = COUNTRYLANGUAGE.CountryCode;

-- MYSQL
SELECT CITY.name as '도시', CITY.CountryCode as '코드', Countrylanguage.language as '언어'
FROM CITY, COUNTRYLANGUAGE
WHERE CITY.CountryCode = COUNTRYLANGUAGE.CountryCode;

-- Q4. 공용 언어(IsOfficial='T')만 골라 언어 이름과 해당 국가 이름을 출력하자.
-- ANSI
SELECT COUNTRYLANGUAGE.LANGUAGE AS '이름', COUNTRY.NAME as '국가 이름'
FROM COUNTRYLANGUAGE
JOIN COUNTRY ON COUNTRYLANGUAGE.CountryCode = Country.code
WHERE COUNTRYLANGUAGE.ISOFFICIAL = 'T';
-- MYSQL
SELECT COUNTRYLANGUAGE.LANGUAGE AS '이름', COUNTRY.NAME as '국가 이름'
FROM COUNTRYLANGUAGE, COUNTRY
WHERE COUNTRYLANGUAGE.ISOFFICIAL = 'T' AND COUNTRYLANGUAGE.CountryCode = Country.code;

-- Q5. 아시아 대륙에 속한 국가에 있는 도시의 이름과 인구를 출력하자.
-- ANSI
SELECT CITY.NAME as '도시이름', CITY.POPULATION as '인구'
FROM CITY
JOIN COUNTRY ON CITY.COUNTRYCODE = COUNTRY.code
WHERE COUNTRY.continent = 'ASIA';
-- MYSQL
SELECT CITY.NAME as '도시이름', CITY.POPULATION as '인구'
FROM CITY, COUNTRY
WHERE COUNTRY.continent = 'ASIA' AND CITY.COUNTRYCODE = COUNTRY.code;

-- Q6. 기대 수명(LifeExpectancy)이 80 이상인 국가의 이름과 대륙을 출력하자.
-- ANSI
SELECT COUNTRY.NAME as '이름', COUNTRY.Continent as '대륙'
FROM COUNTRY
WHERE COUNTRY.LifeExpectancy >= 80;
-- MYSQL

-- Q7. 공용어가 영어인 국가의 이름만 출력하자.
-- ANSI
SELECT country.name as '영어권 국가'
FROM country
JOIN countrylanguage ON countrylanguage.countryCode = country.Code
WHERE countrylanguage.language = 'English' AND countrylanguage.isofficial = 'T';
-- MYSQL
SELECT country.name as '영어권 국가'
FROM country, countrylanguage
WHERE countrylanguage.language = 'English' 
	AND countrylanguage.isofficial = 'T'
	AND countrylanguage.countryCode = country.Code;
    
-- Q8. 모든 국가의 이름과 수도 도시의 이름을 각각 Country, Capital로 별칭을 주어 출력하자.
-- ANSI
SELECT country.name as 'Country', city.name as 'Capital'
FROM country
JOIN city on city.id = country.capital;
-- MYSQL
SELECT country.name as 'Country', city.name as 'Capital'
FROM country, city
WHERE city.id = country.capital;

-- Q9. 도시 이름, 도시 인구, 해당 국가의 지역(region)을 출력하자.
-- ANSI
SELECT city.name, city.population, country.region
FROM city
JOIN country on country.code = city.countrycode;
-- MYSQL
SELECT city.name, city.population, country.region
FROM city, country
WHERE country.code = city.countrycode;

-- Q10. 인구가 500만 이상인 국가에서 사용되는 언어를 해당 국가 이름과 함께 출력하자.
-- ANSI
SELECT country.name, countrylanguage.language
FROM country
JOIN countrylanguage on countrylanguage.countrycode = country.code
WHERE country.population >= 5000000;
-- MYSQL
SELECT country.name, countrylanguage.language
FROM country, countrylanguage  
WHERE countrylanguage.countrycode = country.code  AND country.population >= 5000000;

-- Q11. 도시 이름과 해당 국가의 정부 형태(GovernmentForm)를 출력하자.
-- ANSI
SELECT City.name, Country.governmentform
FROM city
JOIN country on city.countrycode = country.code;
-- MYSQL
SELECT City.name, Country.governmentform
FROM city,country
WHERE city.countrycode = country.code;

-- Q12. 공용어가 영어인 국가에 속한 도시 이름을 중복 없이 출력하자.
-- ANSI
select DISTINCT city.name
from city
join countrylanguage on city.countrycode = countrylanguage.countrycode 
AND countrylanguage.language = 'English';

-- MYSQL
select DISTINCT city.name
from city, countrylanguage
WHERE countrylanguage.language = 'English' AND city.countrycode = countrylanguage.countrycode ;

-- Q13. 국가 이름과 그 국가에서 사용되는 언어 이름을 출력하자.
-- ANSI
select country.name, countrylanguage.language
from country
join countrylanguage on country.code = countrylanguage.countrycode;
-- MYSQL
select country.name, countrylanguage.language
from country, countrylanguage
where country.code = countrylanguage.countrycode;

-- Q14. 모든 국가의 이름과 수도 도시의 인구를 출력하자.
-- ANSI
select country.name, city.population
from country
join city on country.capital = city.id;
-- MYSQL
select country.name, city.population
from country, city
where country.capital = city.id;

-- Q15. 도시 이름과 해당 국가의 독립 연도(IndepYear)를 출력하자.
-- ANSI
select city.name, country.indepyear
from city
join country on city.countrycode = country.code;
-- MYSQL

-- Q16. 사용 언어 수가 5개 이상인 국가의 이름을 출력하자.
-- ANSI
select country.name
from country
join countrylanguage on countrylanguage.countrycode = country.code 
GROUP BY country.name
HAVING COUNT(countrylanguage.language) >= 5;
-- MYSQL

-- Q17. 도시 이름과 그 도시가 속한 국가의 국토 면적(SurfaceArea)을 출력하자.
-- ANSI
select city.name, country.surfacearea
from city
join country on city.countrycode = country.code;
-- MYSQL

-- Q18. 아프리카 대륙에 속한 국가의 이름과 수도 도시 이름을 출력하자.
-- ANSI
select country.name, city.name
from country
join city on country.capital = city.id AND country.continent ='Africa';
-- MYSQL

-- Q19. 전 세계에서 인구가 가장 많은 도시의 이름과 그 도시가 속한 국가 이름을 출력하자.
-- ANSI
select city.name, country.name
from city
join country on city.countrycode = country.code
ORDER BY city.population DESC
LIMIT 1;

-- MYSQL

-- Q20. 도시 인구의 평균이 100만 이상인 국가의 이름을 출력하자.
-- ANSI
select country.name
from country
join city on city.countrycode = country.code
GROUP BY country.Name
HAVING AVG(city.Population) >= 1000000;
-- MYSQL

-- Q21. 도시 정보가 없는 국가를 출력하자  -> 나라에는 등록되어 있지만 도시 정보가 없는 경우 
select country.name
from country
left join city on country.code = city.countrycode
WHERE city.id IS NULL;
