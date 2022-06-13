-- 3. The name, population, and sales tax of the states in the "West" census region (13 rows)
--  || are for concants 
SELECT state_name, population, sales_tax FROM state WHERE census_region = 'West';