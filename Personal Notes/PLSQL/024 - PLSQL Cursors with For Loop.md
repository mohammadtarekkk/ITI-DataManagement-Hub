# PL/SQL Cursors with For Loop

The **Cursor For Loop** simplifies cursor management drastically. It automatically:
1. Opens the cursor.
2. Reads every row (fetching it into an implicitly declared record).
3. Exits when there are no more rows.
4. Closes the cursor.

## Syntax Comparison

### The Long Way (Basic Loop)
```plsql
OPEN c_emp;
LOOP
    FETCH c_emp INTO v_record;
    EXIT WHEN c_emp%NOTFOUND;
    -- do work
END LOOP;
CLOSE c_emp;
```

### The Short Way (For Loop)
```plsql
DECLARE
    CURSOR c_emps IS
        SELECT employee_id, last_name, salary 
        FROM employees 
        WHERE department_id = 30;
BEGIN
    -- 'v_emp_record' is strictly scoped to this loop.
    -- It implicitly has the type c_emps%ROWTYPE.
    FOR v_emp_record IN c_emps LOOP
        IF v_emp_record.salary <= 9000 THEN
            DBMS_OUTPUT.PUT_LINE(v_emp_record.last_name || ': Low Salary');
        ELSE
            DBMS_OUTPUT.PUT_LINE(v_emp_record.last_name || ': High Salary');
        END IF;
    END LOOP; -- Automatically closes here
END;
/
```

> [!TIP]
> This is the preferred way to write cursors in modern PL/SQL because it is cleaner and prevents resource leaks (forgetting to `CLOSE`).

## Related
- [[023 - PLSQL Explicit Cursors Basics]]
- [[020 - PLSQL For Loop]]
