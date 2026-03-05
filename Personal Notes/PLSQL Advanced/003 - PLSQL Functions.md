# PL/SQL Functions

A Function is a subprogram specifically designed to compute and return exactly one value.

## Syntax
```plsql
CREATE OR REPLACE FUNCTION function_name
    (parameter_name [mode] datatype, ...)
RETURN return_datatype    -- Must specify what type comes back
IS | AS
    -- Declarations
BEGIN
    -- Executable statements
    
    RETURN variable_to_return; -- Must explicitly return a value
EXCEPTION
    -- Error handling
END;
/
```

## Example: Create a Function
Calculates tax based on salary.
```plsql
CREATE OR REPLACE FUNCTION calc_tax_value(
    v_emp_id NUMBER, 
    v_tax_perc NUMBER
)
RETURN NUMBER
IS
    v_salary NUMBER(8, 2);      
    v_tax_value NUMBER(8, 2);
BEGIN
    SELECT salary INTO v_salary
    FROM employees 
    WHERE employee_id = v_emp_id;

    v_tax_value := v_salary * (v_tax_perc / 100);
    
    RETURN v_tax_value;
END;
/
```

## Calling a Function
Because a function returns a value, it behaves like a standard SQL function (like `UPPER()` or `ROUND()`). It can be called from **both PL/SQL blocks and standard SQL statements**.

### Calling from PL/SQL
You must assign the returned value to a variable.
```plsql
DECLARE
    v_result NUMBER(8, 2);
BEGIN
    v_result := calc_tax_value(107, 20);
    DBMS_OUTPUT.PUT_LINE('Tax is: ' || v_result);
END;
/
```

### Calling from standard SQL
```sql
SELECT employee_id, last_name, salary, 
       calc_tax_value(employee_id, 10) AS tax_function
FROM employees;
```

> [!WARNING] Rule for SLQ calls
> To call a PL/SQL function from a SELECT statement, the function **cannot contain any DML statements** (no logic that does an `INSERT`, `UPDATE`, or `DELETE`).

## Related
- [[001 - PLSQL Subprograms Overview]]
