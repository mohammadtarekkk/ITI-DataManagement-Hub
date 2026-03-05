-- 3) Identify employees whose revenue falls below the average revenue for their department. 

with cte_table as (select emp_name, department, revenue_generated,
				   avg(revenue_generated) over(partition by department) as avg_dep_revenue
				   FROM employee_performance)
                   
select emp_name, department, revenue_generated, avg_dep_revenue,
case when avg_dep_revenue < revenue_generated then 'Good Performance' else 'Low Performance' end as Performance_flag
from cte_table;