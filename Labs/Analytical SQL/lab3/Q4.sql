-- 4) Compare Revenue with a 2-Month Range 
-- For each evaluation, calculate the total revenue for evaluations that occurred within 1 
-- month (60 days) before and including the current date.

select
	emp_name,
    evaluation_date,
    revenue_generated,
	sum(revenue_generated) over(order by evaluation_date range between interval '1' month preceding and current row) as moving_range_rev
from employee_performance
where emp_name = 'quinn'