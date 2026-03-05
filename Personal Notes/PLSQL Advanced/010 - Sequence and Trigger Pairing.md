# Sequence and Trigger Pairing

Before Oracle 12c introduced **Identity Columns** (auto-increment fields), generating sequential numbering automatically on `INSERT` required pairing a DB Sequence with a `BEFORE INSERT` trigger.

This guarantees that every new row gets a unique identifier, even if the user forgets to include the sequence in their SQL `INSERT` statement.

## 1. Create the Sequence
First, create an independent database sequence.
```sql
CREATE SEQUENCE emp_id_seq
START WITH 1000
INCREMENT BY 1;
```

## 2. Create the Trigger
Create a row-level trigger that fires **before** every insert. It intercepts the new row data (via `:NEW`) and injects the sequence value.

```plsql
CREATE OR REPLACE TRIGGER trg_auto_emp_id
    BEFORE INSERT ON employees
    FOR EACH ROW
BEGIN
    -- Prevent users from manually assigning an ID
    -- If they pass NULL, or even if they pass a specific value, override it
    :NEW.employee_id := emp_id_seq.NEXTVAL;
END trg_auto_emp_id;
/
```

## 3. Testing It
Now you can insert a row completely omitting the primary key.
```sql
-- The trigger will automatically assign the NEXTVAL to the employee_id
INSERT INTO employees (first_name, last_name, email)
VALUES ('Ali', 'Ahmed', 'ali@example.com');
```

## Modern Alternative
In modern Oracle (12c+), use Identity Columns instead:
```sql
CREATE TABLE employees (
    employee_id NUMBER GENERATED ALWAYS AS IDENTITY,
    -- ...
);
```

## Related
- [[009 - DML Triggers]]
- [[011 - Schema Objects]] (from the SQL Fundamentals module)
