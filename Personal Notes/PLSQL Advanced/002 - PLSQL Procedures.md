# PL/SQL Procedures

A Procedure is a subprogram used to execute a specific action (like inserting records, updating salaries, or complex business workflows).

## Syntax
```plsql
CREATE OR REPLACE PROCEDURE procedure_name
    (parameter_name [mode] datatype, ...)
IS | AS
    -- Declarations go here (No DECLARE keyword needed)
    v_local_var NUMBER;
BEGIN
    -- Executable statements
    
EXCEPTION
    -- Exception handling
END;
/
```

## Example: Create a Procedure
This procedure updates an employee's salary based on a given percentage.
```plsql
CREATE OR REPLACE PROCEDURE update_emp_salary(
    v_emp_id NUMBER, 
    v_bonus_perc NUMBER
)
IS
    v_current_salary NUMBER(8, 2);      
    v_new_salary NUMBER(8, 2);
BEGIN
    SELECT salary INTO v_current_salary
    FROM employees
    WHERE employee_id = v_emp_id;
    
    v_new_salary := v_current_salary + (v_current_salary * (v_bonus_perc / 100));
    
    UPDATE employees
    SET salary = v_new_salary
    WHERE employee_id = v_emp_id; 
END;
/
```

## Calling a Procedure
Because a procedure operates as a standalone action, it must be called **from within another PL/SQL block** (either an anonymous block, another procedure, or a trigger). It **cannot** be called from a standard SQL `SELECT` statement.

### Calling from an Anonymous Block
```plsql
BEGIN
    update_emp_salary(107, 10);
    update_emp_salary(108, 20);
END;
/
```

### Calling within a Cursor Loop
```plsql
DECLARE
    CURSOR emp_cursor IS 
        SELECT employee_id FROM employees WHERE department_id = 60;
BEGIN
    FOR v_emp_record IN emp_cursor LOOP
        update_emp_salary(v_emp_record.employee_id, 10);
    END LOOP;
END;
/
```

## Related
- [[001 - PLSQL Subprograms Overview]]
- [[004 - PLSQL Parameter Modes]]
