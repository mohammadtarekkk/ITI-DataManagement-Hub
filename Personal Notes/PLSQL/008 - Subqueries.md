# Subqueries

A subquery is a query nested inside another query.

## 1. Single Row Subquery
Returns only **one row**. Uses standard operators (`=`, `>`, `<`, `!=`).

*Example: Find employees who work in the same department as employee 115.*
```sql
SELECT * FROM employees
WHERE department_id = (SELECT department_id FROM employees WHERE employee_id = 115)
  AND employee_id != 115;
```

*Example: Employees with the maximum salary.*
```sql
SELECT * FROM employees
WHERE salary = (SELECT MAX(salary) FROM employees);
```

## 2. Multi-Row Subquery
Returns **multiple rows**. Must use `IN`, `ANY`, or `ALL`.

*Example: Departments that have employees.*
```sql
SELECT * FROM departments
WHERE department_id IN (SELECT department_id FROM employees);
```

*Example: Departments with NO employees.*
> [!WARNING]
> Using `NOT IN` with a subquery that returns a `NULL` value will yield 0 results. Use `NVL` to handle it safely.
```sql
SELECT * FROM departments
WHERE department_id NOT IN (SELECT NVL(department_id, -1) FROM employees);
```

## 3. Correlated Subquery
A subquery that evaluates once for **each row processed by the outer query**. Because it references columns from the outer query, it cannot be run independently.

*Example: Employees earning more than their specific department's average salary.*
```sql
SELECT employee_id, last_name, salary, department_id
FROM employees outer_emps
WHERE salary > ( 
    SELECT AVG(salary) 
    FROM employees 
    WHERE department_id = outer_emps.department_id 
);
```

## Related
- [[007 - SQL Joins]]
- [[016 - PLSQL Select Into]]
