-- 5) Flag Employees Who Are Falling Behind Department’s Rolling Average 
-- Identify employees whose revenue is consistently below their department's rolling average 
-- over the last 3 rows.

with RollingAvgData as (select emp_name, department, evaluation_date, revenue_generated,
	round(avg(revenue_generated) over (partition by department order by evaluation_date rows between 2 preceding and current row), 2) as rolling_avg_department_revenue
    from employee_performance
)
select 
    emp_name,
    department,
    evaluation_date,
    revenue_generated,
    rolling_avg_department_revenue,
    case when revenue_generated < rolling_avg_department_revenue then 'Below Rolling Avg'
        else 'Above Rolling Avg' end as performance_flag
from RollingAvgData
order by department, evaluation_date