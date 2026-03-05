-- 6) Find Revenue Peaks Within a Dynamic Date Range 
-- Business Need: 
-- For each employee, calculate the maximum revenue achieved within a rolling 60-day 
-- window (current row and preceding 60 days).

select
	emp_name,
    evaluation_date,
    revenue_generated,
	max(revenue_generated) over(order by evaluation_date range between interval '60' day preceding and current row) as max_rev_in_60_days
from employee_performance
where emp_name = 'quinn'