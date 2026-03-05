-- 7) Flag Overloaded Employees 
-- Identify employees whose hours worked exceed the average hours worked for their 
-- department by more than 25%. 

with cte_table as (select emp_name, department, hours_worked,
				   avg(hours_worked) over(partition by department) as avg_hours_worked
				   FROM employee_performance)
                   
select emp_name, department, hours_worked, avg_hours_worked,
case when avg_hours_worked + avg_hours_worked * 20 / 100 < hours_worked then 'Not Normal' else 'Normal' end as workload_flag
from cte_table
order by department, hours_worked;