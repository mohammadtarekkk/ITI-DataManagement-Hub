-- 9) The Sales Performance Department requires a regional performance report to evaluate 
-- salesperson effectiveness while accounting for product returns. 
-- • For each region, management wants to measure the adjusted net revenue 
-- contribution of every salesperson during the reporting period. The calculation 
-- rules are defined as follows: 
-- • Gross Sales: Total sales amount generated from completed (non-returned) 
-- transactions. 
-- • Returned Sales: Total sales amount associated with returned transactions. 
-- • Adjusted Net Revenue: 
-- Gross Sales minus 30% of Returned Sales 
-- (The 30% deduction represents estimated operational and restocking costs.) 
-- After computing the adjusted net revenue per salesperson, the system must: 
-- Rank salespeople within each region based on their adjusted net revenue. 
-- Assign rank 1 to the highest performer in each region.

with cte_table as (select region, salesperson,
		sum(case when returned_fg = 'N' then amount else 0 end) as gross_sales,
        sum(case when returned_fg = 'Y' then amount else 0 end) as returned_sales
	from sales_txn
    group by region, salesperson),
cte_table2 as (
    select *, (gross_sales - (returned_sales + returned_sales * 30 / 100)) as net_revenue
    from cte_table)
select region, salesperson, gross_sales, returned_sales, net_revenue,
rank() over (partition by region order by net_revenue desc) as region_rank
from cte_table2
order by region, region_rank;