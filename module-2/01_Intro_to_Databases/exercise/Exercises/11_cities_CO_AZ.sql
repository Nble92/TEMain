-- 11. The name, state, and population of all cities in Colorado (CO) or Arizona (AZ) (22 rows)

Select city_name,state_abbreviation, population from city where state_abbreviation = 'CO' OR state_abbreviation = 'AZ';