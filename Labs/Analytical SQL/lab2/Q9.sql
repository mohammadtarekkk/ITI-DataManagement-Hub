select 
    customer_id, 
    purchase_date, 
    purchase_amount,
    lag(purchase_amount) over (partition by customer_id order by purchase_date) as previous_purchase,
    lead(purchase_amount) over (partition by customer_id order by purchase_date) as next_purchase,
    lag(purchase_date) over (partition by customer_id order by purchase_date) as previous_purchase_date,
    lead(purchase_date) over (partition by customer_id order by purchase_date) as next_purchase_date,
    purchase_date - lag(purchase_date) over (partition by customer_id order by purchase_date) as days_since_last_purchase,
    lead(purchase_date) over (partition by customer_id order by purchase_date) - purchase_date as days_until_next_purchase
from customer_purchases;