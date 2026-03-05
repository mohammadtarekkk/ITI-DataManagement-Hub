# SQL Statements Overview

SQL (Structured Query Language) is the standard language to communicate with relational databases. Oracle classifies SQL commands into five main categories:

## 1. DQL (Data Query Language)
Used to retrieve data.
- `SELECT`

## 2. DML (Data Manipulation Language)
Used to modify data within tables. **Requires COMMIT** to save permanently.
- `INSERT` — add new rows
- `UPDATE` — modify existing rows
- `DELETE` — remove rows

## 3. TCL (Transaction Control Language)
Used to manage DML changes.
- `COMMIT` — save changes permanently
- `ROLLBACK` — undo changes since last commit
- `SAVEPOINT` — create a rollback point within a transaction

## 4. DDL (Data Definition Language)
Used to define or modify database structure (tables, views). **Auto-commits** immediately.
- `CREATE` — create an object
- `ALTER` — modify an object structure
- `DROP` — delete an object
- `TRUNCATE` — empty all rows (cannot be rolled back normally)
- `RENAME` — change object name

## 5. DCL (Data Control Language)
Used to manage permissions.
- `GRANT` — give privileges
- `REVOKE` — remove privileges

## Related
- [[002 - Retrieving and Restricting Data]]
- [[010 - Data Definition Language]]
