-- calculate the profit margin for each sub-category per month
with monthly_margin as (
    select
        category,
        `sub-category`,
        year(str_to_date(`order date`, '%m/%d/%Y'))  as yr,
        month(str_to_date(`order date`, '%m/%d/%Y')) as mn,
        round(sum(profit) / nullif(sum(sales), 0) * 100, 2) as profit_margin_pct
    from `superstore sales dataset`
    group by
        category,
        `sub-category`,
        year(str_to_date(`order date`, '%m/%d/%Y')),
        month(str_to_date(`order date`, '%m/%d/%Y'))
),

-- pull in the previous month's margin to compare
with_previous_month as (
    select
        category,
        `sub-category`,
        yr,
        mn,
        profit_margin_pct,
        lag(profit_margin_pct) over (partition by `sub-category`order by yr, mn) as prev_margin_pct
    from monthly_margin
),

-- count how many months each sub-category had a declining margin
decline_summary as (
    select distinct
    category,
    `sub-category`,
    sum(case when profit_margin_pct < prev_margin_pct then 1 else 0 end) over (partition by `sub-category`) as months_declining,
    round(avg(profit_margin_pct) over (partition by `sub-category`), 2) as avg_margin_pct
	from with_previous_month
	where prev_margin_pct is not null
)

-- return the top 3 worst sub-categories by how often their margin declined
select
    category,
    `sub-category`,
    months_declining,
    avg_margin_pct
from decline_summary
order by months_declining desc, avg_margin_pct asc
limit 3;