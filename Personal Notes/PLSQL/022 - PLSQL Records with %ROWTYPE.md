# PL/SQL Records with %ROWTYPE

Instead of manually defining a record's fields one by one, `%ROWTYPE` automatically creates a record that exactly matches the structure of a database table or a cursor.

## Advantages
- **Robustness**: If the database table changes (columns added or data types modified), your PL/SQL code adapts automatically.
- **Simplicity**: No need to explicitly write out a `TYPE ... IS RECORD` definition.

## Example
```plsql
DECLARE
    -- Automatically matches the entire 'employees' table row structure
    v_emp_record employees%ROWTYPE;
BEGIN
    -- Select an entire row directly into the record
    SELECT *
    INTO v_emp_record
    FROM employees
    WHERE employee_id = 100;
    
    -- Access specific fields
    DBMS_OUTPUT.PUT_LINE('Name: ' || v_emp_record.last_name);
    DBMS_OUTPUT.PUT_LINE('Salary: ' || v_emp_record.salary);
    DBMS_OUTPUT.PUT_LINE('Hired: ' || v_emp_record.hire_date);
END;
/
```

## Related
- [[021 - PLSQL Records]]
- [[015 - PLSQL Variables and Data Types]]
- [[016 - PLSQL Select Into]]
