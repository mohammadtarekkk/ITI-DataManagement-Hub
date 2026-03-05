# Retrieving and Restricting Data

## Basic Retrieval
The `SELECT` statement retrieves columns, while the `FROM` clause identifies the table.
```sql
SELECT employee_id, first_name, salary 
FROM employees;
```
- Select all columns: `SELECT * FROM employees;`
- Arithmetic: `SELECT salary, salary + 500 FROM employees;`
- Concatenation (`||`): `SELECT first_name || ' ' || last_name AS full_name FROM employees;`

## Restricting Data (`WHERE` Clause)
Filters rows based on a condition before they are returned.
```sql
SELECT * FROM employees WHERE department_id = 90;
```

### Comparison Operators
| Operator | Meaning | Example |
|----------|---------|---------|
| `=`, `!=`, `<>` | Equal, Not Equal | `salary != 5000` |
| `>`, `<`, `>=`, `<=` | Inequalities | `salary > 10000` |
| `BETWEEN .. AND ..` | Inclusive range | `salary BETWEEN 5000 AND 10000` |
| `IN (list)` | Matches any in list | `department_id IN (10, 20, 30)` |
| `LIKE` | Pattern matching | `last_name LIKE 'A%'` |
| `IS NULL` / `IS NOT NULL` | Null check | `commission_pct IS NULL` |

### Logical Operators
- `AND`: Both conditions must be true.
- `OR`: At least one condition must be true.
- `NOT`: Reverses the condition.

## Sorting Data (`ORDER BY`)
Sorts the final result set. Always place it at the **end** of the query.
```sql
SELECT last_name, salary 
FROM employees 
ORDER BY salary DESC, last_name ASC;
```

## Related
- [[003 - Single Row Functions - Character and Number]]
- [[006 - Aggregate Functions and Group By]]
