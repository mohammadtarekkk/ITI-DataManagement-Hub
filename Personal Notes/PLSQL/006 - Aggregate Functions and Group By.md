# Aggregate Functions and Group By

Aggregate (Multi-row) functions operate on sets of rows to give one result per group.

## Core Functions
- `SUM(col)` — Finds the total.
- `MAX(col)` — Finds the highest value.
- `MIN(col)` — Finds the lowest value.
- `AVG(col)` — Finds the average.
- `COUNT(*)` or `COUNT(col)` — Counts number of rows.

> [!WARNING]
> Aggregate functions **ignore NULL values** (except `COUNT(*)`). 
> Example: `AVG(commission_pct)` calculates average based ONLY on rows where commission is not null. To force inclusion, use `AVG(NVL(commission_pct, 0))`.

## `GROUP BY` Clause
Divides rows in a table into smaller groups before aggregating.
```sql
SELECT department_id, SUM(salary), COUNT(*)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY department_id ASC;
```

### Nesting (Drilling down)
You can group by multiple columns.
```sql
SELECT department_id, job_id, SUM(salary)
FROM employees
GROUP BY department_id, job_id;
```

## `HAVING` Clause
Filters the results **after** aggregation (you cannot use aggregate functions directly in a `WHERE` clause).
```sql
SELECT department_id, count(*)
FROM employees
GROUP BY department_id
HAVING count(*) > 5;
```

### Rule of Select Lists with Grouping
Any column in the `SELECT` list that is **not** inside an aggregate function **must** appear in the `GROUP BY` clause.

## Related
- [[002 - Retrieving and Restricting Data]]
- [[013 - Window Functions and Fetch First]]
