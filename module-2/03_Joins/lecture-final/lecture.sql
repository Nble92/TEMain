-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT 
	city_name
	,state_abbreviation
FROM city
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT 
	  city_name
	 ,state_name
	 --,area
FROM
	city
JOIN
	state
ON
	city.state_abbreviation = state.state_abbreviation
WHERE city_name = 'Columbus';


-- full table name
SELECT 
	  city.city_name
	 ,state.state_name
FROM
	city
JOIN
	state
ON
	city.state_abbreviation = state.state_abbreviation
WHERE city.city_name = 'Columbus';


--table alias
SELECT 
	  ci.city_name
	 ,st.state_name
	 ,ci.area AS city_area
	 ,st.area AS state_area
FROM
	city AS ci
JOIN
	state AS st
ON
	ci.state_abbreviation = st.state_abbreviation
WHERE ci.city_name = 'Columbus';



-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT 
	 p.park_name
	,ps.state_abbreviation
FROM
	park AS p
JOIN
	park_state AS ps
ON 
	p.park_id = ps.park_id;




-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT 
	 p.park_name
	,s.state_name
FROM 
	park p
JOIN
	park_state ps
ON
	p.park_id = ps.park_id
JOIN
	state s
ON
	s.state_abbreviation = ps.state_abbreviation;

-- Modify the previous query to include the name of the state's capital city.

SELECT 
	 p.park_name
	,s.state_name
	,c.city_name AS capital_name
FROM 
	park p
JOIN
	park_state ps
ON
	p.park_id = ps.park_id
JOIN
	state s
ON
	s.state_abbreviation = ps.state_abbreviation
JOIN
	city c
ON
	s.capital = c.city_id
ORDER BY
	p.park_name;

--question why not state_abbreviation? unintential results
SELECT 
	 p.park_name
	,s.state_name
	,c.city_name AS capital_name
FROM 
	park p
JOIN
	park_state ps
ON
	p.park_id = ps.park_id
JOIN
	state s
ON
	s.state_abbreviation = ps.state_abbreviation
JOIN
	city c
ON
	s.state_abbreviation = c.state_abbreviation
ORDER BY
	p.park_name;

-- Modify the previous query to include the area of each park.
SELECT 
	 p.park_name
	,s.state_name
	,c.city_name AS capital_name
	,p.area AS park_area
FROM 
	park p
JOIN
	park_state ps
ON
	p.park_id = ps.park_id
JOIN
	state s
ON
	s.state_abbreviation = ps.state_abbreviation
JOIN
	city c
ON
	s.capital = c.city_id;

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT 
	 c.city_name
	,c.population
FROM city c
JOIN state s ON s.state_abbreviation = c.state_abbreviation
WHERE s.census_region = 'Midwest';

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT 
	  s.state_name
	 ,COUNT(*) AS number_of_cities
FROM city c
JOIN state s ON s.state_abbreviation = c.state_abbreviation
WHERE s.census_region = 'Midwest'
GROUP BY s.state_name;

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT 
	  s.state_name
	 ,COUNT(*) AS number_of_cities
FROM city c
JOIN state s ON s.state_abbreviation = c.state_abbreviation
WHERE s.census_region = 'Midwest'
GROUP BY s.state_name
ORDER BY number_of_cities DESC;


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
SELECT 
	  s.state_name
	, MIN(p.date_established) AS earliest_park
FROM
	state s
JOIN park_state ps ON s.state_abbreviation = ps.state_abbreviation
JOIN park p ON ps.park_id = p.park_id
GROUP BY s.state_name;
	


-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT 
	  s.state_name
	, MIN(p.date_established) AS earliest_park
FROM
	state s
LEFT JOIN park_state ps ON s.state_abbreviation = ps.state_abbreviation
LEFT JOIN park p ON ps.park_id = p.park_id
GROUP BY s.state_name;


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)
SELECT city_name AS place_name
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name AS place_name
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;

-- Modify the previous query to include a column that indicates whether the place is a city or state.

SELECT city_name AS place_name
	   ,'City' AS kind_of_place
FROM city
WHERE city_name LIKE 'W%'
UNION 
SELECT state_name AS place_name
	   ,'State' AS kind_of_place
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;

-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres
SELECT genre_name
FROM genre;

-- The titles of all the Comedy movies
SELECT 
	m.title
FROM movie m
JOIN movie_genre mg ON m.movie_id = mg.movie_id
JOIN genre g ON mg.genre_id = g.genre_id
WHERE g.genre_name = 'Comedy';



SELECT * FROM person;

SELECT 
	 m.title
	,m.release_date
FROM movie m
JOIN movie_actor ma ON m.movie_id = ma.movie_id
JOIN person p ON ma.actor_id = p.person_id
WHERE person_name = 'Tom Hanks';
