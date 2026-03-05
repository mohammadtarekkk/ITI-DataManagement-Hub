# Conditional Expressions and General Functions

## General Functions (Handling NULLs)
Nulls interfere with arithmetic (e.g., `5000 + NULL = NULL`). General functions help handle this safely.

- **`NVL(expr1, expr2)`**: If `expr1` is null, return `expr2`. Else return `expr1`. Types must match.
  ```sql
  SELECT salary + salary * NVL(commission_pct, 0) FROM employees;
  ```
- **`NVL2(expr1, expr2, expr3)`**: If `expr1` is NOT null, return `expr2`. If null, return `expr3`.
- **`NULLIF(expr1, expr2)`**: If `expr1 = expr2`, return NULL. Else return `expr1`.
- **`COALESCE(expr1, expr2, ...)`**: Returns the **first** non-null expression in the list.

## Conditional Expressions (IF-THEN-ELSE in SQL)
Allows logical conditioning directly inside a `SELECT` statement.

### 1. CASE Expression (ANSI Standard)
Flexible and highly readable.
```sql
SELECT employee_id, gender,
       CASE gender 
           WHEN 'M' THEN 'Male'
           WHEN 'F' THEN 'Female'
           ELSE 'Not valid'
       END AS gender_desc
FROM employees;
```
*Note: You can also use `CASE WHEN condition THEN ...` for complex logic.*

### 2. DECODE Function (Oracle Specific)
Shorter syntax but specific to Oracle. Works like a switch statement.
`DECODE(column, search1, result1, search2, result2, ..., default)`
```sql
SELECT employee_id, gender,
       DECODE(gender, 'M', 'Male', 'F', 'Female', 'Not valid') AS gender_desc
FROM employees;
```

## Related
- [[003 - Single Row Functions - Character and Number]]
- [[017 - PLSQL IF Conditions]]
