-- select * from employee_performance;

-- 1) Identify The Top 3 employees in Each Department and their revenue based on their 
-- revenue_generated from employee_performance

select distinct
	department,
	nth_value(emp_name, 1) over(partition by department order by revenue_generated desc rows between unbounded preceding and unbounded following) as top_1_emp,
	nth_value(revenue_generated, 1) over(partition by department order by revenue_generated desc rows between unbounded preceding and unbounded following) as top_1_rev,
	nth_value(emp_name, 2) over(partition by department order by revenue_generated desc rows between unbounded preceding and unbounded following) as top_2_emp,
    nth_value(revenue_generated, 2) over(partition by department order by revenue_generated desc rows between unbounded preceding and unbounded following) as top_2_rev,
    nth_value(emp_name, 3) over(partition by department order by revenue_generated desc rows between unbounded preceding and unbounded following) as top_3_emp,
    nth_value(revenue_generated, 3) over(partition by department order by revenue_generated desc rows between unbounded preceding and unbounded following) as top_3_rev
from employee_performance