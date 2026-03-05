-- 4) Flag employees whose revenue differs significantly (e.g., >20%) from the average revenue in their department. 

with cte_table as (select emp_name, department, revenue_generated,
				   avg(revenue_generated) over(partition by department) as avg_dep_revenue
				   FROM employee_performance)

select emp_name, department, revenue_generated, avg_dep_revenue,
case when avg_dep_revenue * 1.2 < revenue_generated or avg_dep_revenue * 0.8 > revenue_generated then 'Inconsistent Revenue' else 'Consistent Revenue' end as Performance_flag
from cte_table;