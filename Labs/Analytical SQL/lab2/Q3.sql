-- select * from employee_performance;

-- 3) Identify Departments with the Most Evenly Distributed Revenue , comment on your 
-- answer. 

select distinct
	department,
    round(stddev(revenue_generated) over(partition by department), 2) as rev_stddev
from employee_performance
order by rev_stddev