# Data Manipulation and Transactions

DML (Data Manipulation Language) statements modify data inside tables. They are not saved permanently until you issue a **COMMIT**.

## `INSERT`
Adds new rows to a table.
```sql
-- Explicit columns
INSERT INTO employees (employee_id, first_name, last_name, email)
VALUES (300, 'Ali', 'Omar', 'ali@test.com');

-- Using a subquery (bulk insert)
INSERT INTO employees_backup
SELECT * FROM employees WHERE department_id = 30;
```

## `UPDATE`
Modifies existing rows. Without a `WHERE` clause, it updates **every row in the table**.
```sql
UPDATE employees
SET salary = salary + 1000
WHERE department_id = 13;
```

## `DELETE`
Removes rows from a table. Without a `WHERE` clause, it deletes **all rows**.
```sql
DELETE FROM employees
WHERE employee_id = 300;
```

## Transactions (TCL)
A transaction is a logical unit of work. Oracle starts a transaction implicitly with the first DML statement.

| Command | Action |
|---------|--------|
| `COMMIT;` | Saves all changes to disk permanently. End transaction. |
| `ROLLBACK;` | Discards all changes made since the last commit. |
| `SAVEPOINT A;`| Sets a marker. You can `ROLLBACK TO SAVEPOINT A;` without discarding the entire transaction. |

> [!CAUTION]
> DDL statements (like `CREATE`, `ALTER`) automatically issue a `COMMIT` before and after execution.

## Related
- [[001 - SQL Statements Overview]]
- [[010 - Data Definition Language]]
