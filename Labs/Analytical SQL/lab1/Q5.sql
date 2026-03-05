-- 5) Rank employees by revenue generated per hour worked in their department. 

with cte_table as (select emp_name, department, revenue_generated, hours_worked,
				   round(revenue_generated / sum(hours_worked) over(partition by emp_name), 2) as revenue_per_hour
				   from employee_performance
)
                   
select emp_name, department, revenue_generated, hours_worked, revenue_per_hour,
rank() over(partition by department order by revenue_per_hour desc) as efficiency_rank
from cte_table
order by department, revenue_per_hour desc;