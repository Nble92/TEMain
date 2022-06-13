-- 22. The name and sales tax for states and territories with sales tax greater than or equal to 2% and less than or equal to 5% (15 rows)

Select State_name, sales_tax from state where sales_tax between 2 AND 5;