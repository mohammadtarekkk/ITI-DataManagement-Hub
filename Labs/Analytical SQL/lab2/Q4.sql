-- select * from employee_performance;

-- 4) Calculate the moving Average working hours  for Emp Quinn for last 5 rows. 

select
	emp_name,
    evaluation_date,
    hours_worked,
	avg(hours_worked) over(order by evaluation_date rows between 4 preceding and current row) as moving_avg_hours
from employee_performance
where emp_name = 'quinn'
    