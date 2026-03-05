-- 8) Find the top contributor (employee) to each project based on revenue generated. 

select project_id, emp_name, revenue_generated,
rank() over(partition by project_id order by revenue_generated desc) as rank_within_project
from employee_performance
order by department desc;