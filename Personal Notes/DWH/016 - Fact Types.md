# Fact Types

Facts can be classified by how they interact with dimensions (aggregation behavior).

## 1. Additive Facts
- Can be summed across **all** dimensions.
- *Example*: `Sales_Amount` (sum by date, by product, by store).

## 2. Semi-Additive Facts
- Can be summed across **some** dimensions, but not all (usually not Time).
- *Example*: `Account_Balance` associated with a Date.
    - Adding balances from different customers is valid.
    - Adding balances from different *days* for the same customer is meaningless.

## 3. Non-Additive Facts
- Cannot be summed across **any** dimension.
- Usually ratios or percentages.
- *Example*: `Profit_Margin_Percentage`.
- **Solution**: Store `Profit` and `Revenue` separately, then calculate the percentage after aggregation.

## 4. Derived Facts
- Calculated from other facts.
- *Example*: `Total_Price = Quantity * Unit_Price`.
- Stored for performance or calculated on the fly.

## Related
- [[017 - Fact Table Types]]
- [[008 - Facts and Dimensions]]
