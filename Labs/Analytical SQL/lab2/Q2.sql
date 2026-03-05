-- select * from employee_performance;


-- 2) Calculate Year to Date Revenue for Employee Quinn only, Year to date is the sum of the 
-- revenue starting from the start of current year, till the date of calculation. 

select emp_name,
	extract(year from evaluation_date) as year,
    revenue_generated,
    sum(revenue_generated) over(partition by year(evaluation_date) order by evaluation_date) as year_to_date_revenue
from employee_performance
where emp_name = 'quinn'