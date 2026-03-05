# SQL Joins

Joins combine rows from two or more tables based on a related column.

## 1. Inner Join
Returns only the records that have matching values in **both** tables.

### ANSI Syntax (Recommended)
```sql
SELECT employee_id, department_name, city
FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id
INNER JOIN locations ON departments.location_id = locations.location_id;
```

### Oracle Syntax (Older)
```sql
SELECT employee_id, department_name
FROM employees, departments
WHERE employees.department_id = departments.department_id;
```

## 2. Outer Join
Returns all records from the "Left" or "Right" table, even if there is no match (fills with NULLs).

- **Left Outer Join**: Returns all employees, plus department name if applicable.
  ```sql
  SELECT employee_id, last_name, department_name
  FROM employees 
  LEFT OUTER JOIN departments ON employees.department_id = departments.department_id;
  ```
- **Right Outer Join**: Returns all departments, even empty ones.
- **Full Outer Join**: Returns everything from both tables (combines Left and Right).

## 3. Self Join (Recursive)
Joining a table to itself (Unary Relationship). Useful for hierarchies (e.g., Employees and Managers).
```sql
SELECT emps.first_name AS emp_name, mgrs.first_name AS mgr_name
FROM employees emps 
LEFT OUTER JOIN employees mgrs ON emps.manager_id = mgrs.employee_id;
```

## Related
- [[008 - Subqueries]]
- [[002 - Retrieving and Restricting Data]]
