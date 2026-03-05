# Data Definition Language (DDL)

DDL commands create, modify, and destroy database structures. **DDL commands automatically commit transactions.**

## 1. `CREATE` Table
```sql
CREATE TABLE emps (
    employee_id NUMBER(8) CONSTRAINT emp_id_pk PRIMARY KEY,
    employee_name VARCHAR2(100),
    employee_salary NUMBER(8, 2) CONSTRAINT emp_sal_chk CHECK (employee_salary > 500),
    employee_email VARCHAR2(100) CONSTRAINT emp_email_u UNIQUE,
    department_id NUMBER(8) CONSTRAINT dept_id_fk REFERENCES depts(department_id) 
);
```

### Create Table using Subquery (CTAS)
Copies structure and data. Does **not** copy constraints (except NOT NULL).
```sql
-- With Data
CREATE TABLE employees_backup AS 
SELECT * FROM employees;

-- Schema only (No data)
CREATE TABLE dummy_table AS 
SELECT * FROM employees WHERE 1=2;
```

## 2. `ALTER` Table
Modify an existing table structure without dropping it.
```sql
-- Add column
ALTER TABLE emps ADD employee_mobile VARCHAR2(14);
-- Modify data type
ALTER TABLE emps MODIFY employee_mobile VARCHAR2(20);
-- Rename column
ALTER TABLE emps RENAME COLUMN retired TO employee_retired;
-- Drop column
ALTER TABLE emps DROP COLUMN employee_mobile;
-- Add constraint
ALTER TABLE emps ADD CONSTRAINT mobile_u UNIQUE(employee_mobile);
```

## 3. Table Operations
- **`TRUNCATE TABLE`**: Empties the table extremely fast. It is DDL, so it **cannot be rolled back**.
- **`RENAME`**: `RENAME old_table TO new_table;`
- **`COMMENT`**: `COMMENT ON TABLE emps IS 'Employee lookup table';`

## 4. `DROP` Table
Deletes the table and all its data.
```sql
DROP TABLE employees_backup CASCADE CONSTRAINTS;
```

### Recycle Bin
When dropped, tables go to the Recycle Bin (in modern Oracle).
- View: `SELECT * FROM recyclebin;`
- Restore: `FLASHBACK TABLE tab_name TO BEFORE DROP;`
- Permanent Drop: `DROP TABLE name PURGE;` or `PURGE RECYCLEBIN;`

## Related
- [[001 - SQL Statements Overview]]
- [[011 - Schema Objects]]
