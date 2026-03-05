# Date Dimension

The **Date Dimension** is a special dimension guaranteed to exist in almost every Data Warehouse.

## Why not just use SQL Date functions?
- SQL functions can't handle business-specific logic like:
    - **Fiscal Year** (starts in July? October?).
    - **Holidays** (Is it a bank holiday?).
    - **Seasons** (Marketing seasons).
    - **Weekends vs Weekdays**.

## Structure
A Date Dimension table typically contains one row per day for 10-20 years.
- `Date_Key` (e.g., 20231027)
- `Full_Date` (2023-10-27)
- `Day_Of_Week` (Friday)
- `Is_Holiday` (No)
- `Fiscal_Quarter` (Q4)

## Related
- [[012 - Dimension Types]]
- [[008 - Facts and Dimensions]]
