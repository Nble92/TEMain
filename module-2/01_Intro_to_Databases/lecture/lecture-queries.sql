-- SELECT
-- Use a SELECT statement to return a literal string
--This is a comment
/* This is a
multiline comment */

SELECT 'We use single quotes for strings here';

-- Use a SELECT statement to add two numbers together (and label the result "sum")
SELECT 3 + 5 AS "Withdrawls";
--AS is a label for your columns
--AS is optional but should be used...for readability.
--SQL is case insensitive by default
--It's convention but changes by environment


-- SELECT ... FROM
-- Write queries to retrieve...
--using US DB to find the the state table and going in to state name

-- The names from all the records in the state table
Select state_name FROM state;


-- The names and populations of all cities
Select city_name, population From city;


-- All columns from the park table
Select * FROM park;
-- Select * gives everything from a specified table


-- SELECT __ FROM __ WHERE
-- Write queries to retrieve...

-- The names of cities in California (CA)
SELECT city_name FROM city WHERE state_abbreviation = 'CA';

-- The names and state abbreviations of cities NOT in California

SELECT city_name,  state_abbreviation FROM city Where state_abbreviation != 'CA';

-- The names and areas of cities smaller than 25 square kilometers 
SELECT city_name, area FROM city WHERE area < 25;

-- The names from all records in the state table that have no assigned census region
Select * FROM state where census_region IS NULL;

--SELECT state abbreviation FROM state where census = false;
Select state_name, census_region FROM state where census_region IS NOT NULL;


-- The names and census regions from all records in the state table that have an assigned census region



-- WHERE with AND/OR
-- Write queries to retrieve...

-- The names, areas, and populations of cities smaller than 25 sq. km. with more than 100,000 people
SELECT city_name, population, area FROM city where area < 25 AND population > 100000;

-- The names and census regions of all states (and territories and districts) not in the Midwest region (including those that don't have any census region)
-- SELECT state_name, census_region FROM state WHERE;

-- The names, areas, and populations of cities in California (CA) or Florida (FL)


-- The names, areas, and populations of cities in New England -- Connecticut (CT), Maine (ME), Massachusetts (MA), New Hampshire (NH), Rhode Island (RI) and Vermont (VT)



-- SELECT statements involving math
-- Write a query to retrieve the names and areas of all parks in square METERS
-- (the values in the database are stored in square kilometers)
-- Label the second column "area_in_square_meters"

SELECT park_name, (area * 1000) AS area_in_square_meters
FROM park;


-- All values vs. distinct values

-- Write a query to retrieve the names of all cities and notice repeats (like Springfield and Columbus)
SELECT city_name FROM city;


-- Do it again, but without the repeats (note the difference in row count)
SELECT DISTINCT city_name FROM city ORDER BY city_name;



-- LIKE
-- Write queries to retrieve...

-- The names of all cities that begin with the letter "A"
SELECT city_name FROM city WHERE city_name like 'A%';
--% wildcard - any thing
-- The names of all cities that end with "Falls"
SELECT city_name FROM city WHERE city_name like '%Falls';


-- The names of all cities that contain a space
SELECT city_name FROM city WHERE city_name like '% %';



-- BETWEEN
-- Write a query to retrieve the names and areas of parks of at least 100 sq. kilometers but no more than 200 sq. kilometers
Select park_name, area From park Where area Between 100 and 200;


-- DATES
-- Write a query to retrieve the names and dates established of parks established before 1900
Select park_name, date_established from park where date_established < '1900-01-01';
