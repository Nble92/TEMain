-- ORDERING RESULTS
Select state_name from state order by state_name;
-- Populations of all states from largest to smallest.
Select population from state order by population desc;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
Select state_name, census_region  from state order by state_name asc, census_region desc;

-- The biggest park by area
Select park_name, area from park order by area desc limit 1;


-- LIMITING RESULTS

-- The 10 largest cities by populations
Select city_name, population from city order by population desc limit 10;


-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
Select park_name, date_part('year',date_established) from park order by date_established asc limit 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
Select city_name || ', ' || state_abbreviation from city;

-- The all parks by name and date established.
Select park_name || ', ' || date_established from park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT census_region || ', ' || state_name from state where census_region IN ('West', 'Midwest') order by state asc;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) from state;

-- Total population in the West and South census regions
Select SUM(population) FROM state where census_region = 'West' OR census_region = 'South';

-- The number of cities with populations greater than 1 million

Select city_name, population from city where population > 1000000;

-- The number of state nicknames.
Select count(state_nickname) from state;

-- The area of the smallest and largest parks.
Select min(area) , max(area)from park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
Select COUNT(city_name), state_abbreviation from city group by state_abbreviation; 

-- Determine the average park area depending upon whether parks allow camping or not.
Select AVG(area), has_camping from park group by has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
Select SUM(population), state_abbreviation from city group by state_abbreviation order by state_abbreviation;

-- The smallest city population in each state ordered by city population.
Select MIN(population), state_abbreviation from city group by state_abbreviation order by state_abbreviation;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT 
 	COUNT(city_name) AS cities 
	,(
	Select state_name 
		From state 
		WHERE state_abbreviation IN (SELECT state)
	) AS state_name
FROM 
	city AS c
	ORDER BY cities DESC;
-- Include the names of the smallest and largest parks
SELECT park_name
		,area
FROM 
	park AS p,
	(
		SELECT MIN(area) AS smallest,
				MAX(area) AS largest
		FROM park
		WHERE area > 0
	) AS s1
	
WHERE 
	p.area = s1.smallest OR p.area = s1.largest;
-- List the capital cities for the states in the Northeast census region.
SELECT 
	state_abbreviation
	,city_name
FROM
	city
WHERE 
	city_id IN 
	(
	SELECT capital 
	FROM state
	WHERE census_region = 'Northeast'
		
		
	)
ORDER BY state_abbreviation;
