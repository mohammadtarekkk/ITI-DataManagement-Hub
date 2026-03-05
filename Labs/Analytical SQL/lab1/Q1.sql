-- 1) Evaluate Team Productivity 
-- For each department, calculate: - - - 
-- The cumulative hours worked over time. 
-- The cumulative revenue generated over time. 
-- Rank the employees by their contribution to revenue in their department.

select emp_name, department, evaluation_date,
sum(hours_worked) over(partition by department order by evaluation_date) as cumulative_hours,
sum(revenue_generated) over(partition by department order by evaluation_date) as cumulative_revenue,
rank() over(partition by department order by revenue_generated desc) as revenue_rank
from employee_performance
order by department, evaluation_date;