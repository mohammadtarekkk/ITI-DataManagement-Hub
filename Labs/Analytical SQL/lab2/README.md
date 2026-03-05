# Analytical SQL - Lab 2

## Description
This lab focuses on using advanced Window Functions (e.g., `NTH_VALUE`, `LAG`, `LEAD`, and moving aggregates) to extract complex business insights from employee performance and customer purchase data.

## Questions Addressed & Implemented Logic
- **Q1**: Identifies the Top 3 employees in each department based on the revenue they generated using `NTH_VALUE`.
- **Q2**: Calculates the Year-to-Date (YTD) Revenue for specific employees (e.g., Quinn) by summing revenue partitioned by the extracted year.
- **Q6**: Flags employees whose revenue is consistently falling behind their department's rolling average over the window of the last 3 evaluations.
- **Q9**: Analyzes customer purchase behavior by fetching the previous/next purchase amounts and dates using `LAG` and `LEAD`, and calculating the days since the last purchase and days until the next purchase.

*Note: Scripts Q3, Q4, Q5, Q7, and Q8 also address related analytical queries based on the assignment document.*

## Files
- `Mohammad Tarek Omar - Asql lab2.pdf` - Assignment document
- `Q1.sql` to `Q9.sql` - SQL scripts with the query solutions
