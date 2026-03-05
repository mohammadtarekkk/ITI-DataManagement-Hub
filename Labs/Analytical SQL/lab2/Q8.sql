select * from employee_performance;

-- 8) For each row for Quinn employee, make a flag to show that this revenue_generated is more 
-- or less than the last revenue made by Quinn

select 
    emp_name,
    project_id,
    evaluation_date,
    revenue_generated,
	case when revenue_generated > lag(revenue_generated) over (order by evaluation_date) then 'Increasing'
		 else 'Not Increasing' end as trend_flag
from employee_performance
where emp_name = 'Quinn'
order by evaluation_date;