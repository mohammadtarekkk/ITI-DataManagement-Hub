# Analytical SQL - Lab 3

## Description
This lab reinforces advanced SQL techniques like Recursive Common Table Expressions (CTE) and moving boundaries using window functions.

## Questions Addressed & Implemented Logic
- **Q1**: Uses a recursive CTE to traverse a family hierarchy and calculate how many ancestors (fathers) each person has.
- **Q2**: Identifies departments with the most evenly distributed revenue using standard deviation (`STDDEV`).
- **Q4**: Calculates moving aggregate revenue using a 1-month (`interval '1' month`) range boundary window for localized time-series analysis.
- **Q5**: Flags employees who are consistently falling behind their department's rolling average over specific row-based windows limit (`rows between 2 preceding and current row`).
- **Q7**: Implements trend analysis by comparing an employee's current revenue generation to their immediate previous evaluation using the `LAG` function over an ordered evaluation date.

## Files
- `Q1.sql` to `Q7.sql` - SQL scripts with the query solutions
