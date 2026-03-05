with customer_history as (
    select 
        `Customer ID` as customer_id,
        `Customer Name` as customer_name,
        Region,
        `Order Date` as order_date,        
        Sales as sales_amount,             
        Discount as discount_applied,
        -- Look at previous row to find last visit
        lag(`Order Date`) over (
            partition by `Customer ID` 
            order by `Order Date`
        ) as prev_order_date
    from `superstore sales dataset`
),


   -- Calculate moving averages and lifetime values.
customer_analytics as (
    select 
        customer_id,
        customer_name,
        region,
        order_date,
        sales_amount,
        -- Average spend of current + previous 2 orders
        avg(sales_amount) over (
            partition by customer_id 
            order by order_date 
            rows between 2 preceding and current row
        ) as moving_avg_last_3_orders,
        -- Total Lifetime Value so far
        sum(sales_amount) over (
            partition by customer_id 
            order by order_date 
            rows between unbounded preceding and current row
        ) as lifetime_value,
        -- Average discount ratio
        avg(discount_applied) over (partition by customer_id) as discount_reliance_ratio
    from customer_history
),
 
  -- Calculate the Ranking HERE because MySQL cannot filter Window Functions in the final clause.
customer_segmentation as (
    select 
        customer_id,
        customer_name,
        region,
        order_date,
        sales_amount,
        moving_avg_last_3_orders,
        lifetime_value,
        discount_reliance_ratio,
        -- Rank customers 1-4 based on wealth
        ntile(4) over (order by lifetime_value desc) as customer_tier,
        
        -- Calculate the row number here. 
        -- 1 = The most recent order, 2 = The order before that, etc.
        row_number() over (
            partition by customer_id 
            order by order_date desc
        ) as latest_order_rank
    from customer_analytics
)

   -- Apply labels and filter using the rank we calculated above.
select 
    customer_id,
    customer_name,
    region,
    order_date as last_purchase_date,
    lifetime_value,
    -- Labeling the Wealth Tiers
    case 
        when customer_tier = 1 then 'vip'
        when customer_tier = 2 then 'loyal'
        else 'standard' 
    end as spending_tier,
    -- Labeling the Discount Psychology
    case 
        when discount_reliance_ratio >= 0.8 then 'discount hunter'
        when discount_reliance_ratio >= 0.2 then 'smart shopper'
        else 'premium'
    end as marketing_persona,
    -- Early Warning System
    case 
        when sales_amount < (moving_avg_last_3_orders * 0.8) then 'spending dropping'
        else 'stable'
    end as trend_warning
from customer_segmentation
-- Standard WHERE clause instead of QUALIFY
where latest_order_rank = 1
order by lifetime_value desc;