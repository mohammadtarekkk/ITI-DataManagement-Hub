# PL/SQL Select Into

The `SELECT ... INTO` statement retrieves data from a database table and assigns it to PL/SQL variables.

> [!IMPORTANT] Rules
> 1. A `SELECT INTO` statement must return **exactly one row**.
> 2. If it returns 0 rows, it throws `NO_DATA_FOUND`.
> 3. If it returns >1 row, it throws `TOO_MANY_ROWS`.
> 4. The number and type of columns selected must match the variables listed in the `INTO` clause.

## Example: Retrieving a Single Row
```plsql
DECLARE
    v_last_name   employees.last_name%TYPE;
    v_salary      employees.salary%TYPE;
    v_hire_date   employees.hire_date%TYPE;
BEGIN
    -- Retrieve data for a specific employee
    SELECT last_name, salary, hire_date
    INTO v_last_name, v_salary, v_hire_date
    FROM employees
    WHERE employee_id = 107; -- Must guarantee exactly 1 row

    DBMS_OUTPUT.PUT_LINE('Employee: ' || v_last_name);
    DBMS_OUTPUT.PUT_LINE('Salary: ' || v_salary);
END;
/
```

To handle multiple rows, you must use [[023 - PLSQL Explicit Cursors Basics|Cursors]] or Bulking.

## Related
- [[015 - PLSQL Variables and Data Types]]
- [[025 - PLSQL Predefined Exceptions]]
