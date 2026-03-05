-- 2) Identify Departments with the Most Evenly Distributed Revenue , comment on your 
-- answer. ( Using STDDEV , get the top 4 departments with STDDEV on revenue )


select distinct
	department,
    round(stddev(revenue_generated) over(partition by department), 2) as rev_stddev
from employee_performance
order by rev_stddev