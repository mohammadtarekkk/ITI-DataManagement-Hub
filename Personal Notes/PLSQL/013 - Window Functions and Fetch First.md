# Window Functions and Fetch First

## Fetch First / Limit (Oracle 12c+)
Before 12c, bounding row returns required `ROWNUM` subqueries.

```sql
-- Get top 5 employees regardless of salary
SELECT * FROM employees
ORDER BY employee_id
FETCH FIRST 5 ROWS ONLY;

-- Get the 3rd highest paid employee (Skip first 2)
SELECT * FROM employees
ORDER BY salary DESC
OFFSET 2 ROWS
FETCH FIRST 1 ROWS ONLY;
```

## Analytic (Window) Functions
Perform aggregate calculations over a "window" of rows without collapsing the results (unlike `GROUP BY`).

### Ranking Functions
All of these require the `OVER (ORDER BY col)` clause.
- **`ROW_NUMBER()`**: Sequential integer (1, 2, 3, 4, 5). No ties allowed.
- **`RANK()`**: Skips numbers on ties (1, 2, 2, 4, 5).
- **`DENSE_RANK()`**: Never skips numbers on ties (1, 2, 2, 3, 4).

```sql
SELECT last_name, salary, 
       DENSE_RANK() OVER (ORDER BY salary DESC) AS sal_rank
FROM employees;
```

### Partitioning
You can restart the count for specific groups using `PARTITION BY`.

```sql
-- Ranks employees by salary within each department specifically
SELECT last_name, department_id, salary,
       RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) AS dept_rank
FROM employees;
```

## Related
- [[002 - Retrieving and Restricting Data]]
- [[006 - Aggregate Functions and Group By]]
