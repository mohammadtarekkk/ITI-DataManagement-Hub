# PL/SQL Package Body

The **Package Body** contains the actual implementation (the code) for all the subprograms declared in the [[005 - PLSQL Packages Overview and Specification|Package Specification]]. It can also contain private variables and subprograms not listed in the specification.

> [!WARNING] Prerequisite
> You **cannot** create a package body unless the package specification has already been successfully compiled.

## Features of the Package Body
- **Implementation Rules**: Every procedure and function promised in the specification must be implemented in the body with the exact same signature (name, parameter names, modes, data types).
- **Private Subprograms**: Any subprogram or variable created in the body that was **not** declared in the specification is considered **private**. It can only be called by other subprograms within the same package. It is completely hidden from the outside world.

## Syntax
```plsql
CREATE OR REPLACE PACKAGE BODY package_name IS | AS
    -- Private variable declarations
    v_private_var NUMBER := 10;
    
    -- Private subprogram implementation (must be declared BEFORE use)
    PROCEDURE private_procedure IS
    BEGIN
        NULL;
    END private_procedure;
    
    -- Public subprogram implementation (promised in spec)
    PROCEDURE my_procedure(p_param1 NUMBER) IS
    BEGIN
        -- Actual executable code
        DBMS_OUTPUT.PUT_LINE('Param: ' || p_param1);
    END my_procedure;
    
    FUNCTION my_function RETURN DATE IS
    BEGIN
        RETURN SYSDATE;
    END my_function;
END package_name;
/
```

## Example (Continuing `retired_pkg`)
```plsql
CREATE OR REPLACE PACKAGE BODY retired_pkg IS
    
    -- Implementing the function from the spec
    FUNCTION check_retired (v_emp_id NUMBER, v_max_hire_year NUMBER) RETURN BOOLEAN
    IS
        v_hire_date DATE;
        v_years NUMBER;
    BEGIN
        SELECT hire_date INTO v_hire_date FROM employees WHERE employee_id = v_emp_id;
        v_years := TRUNC(MONTHS_BETWEEN(SYSDATE, v_hire_date) / 12);
        
        IF v_years >= v_max_hire_year THEN 
            RETURN TRUE;
        ELSE
            RETURN FALSE;
        END IF;
    END check_retired;

    -- Implementing the procedure from the spec
    PROCEDURE move_emp (v_emp_id NUMBER) IS
    BEGIN
        IF check_retired(v_emp_id, 10) THEN
            -- ... Insert logic into retired table ...
            UPDATE employees SET retired = 1 WHERE employee_id = v_emp_id;
        END IF;
    END move_emp;

END retired_pkg;
/
```

## Related
- [[005 - PLSQL Packages Overview and Specification]]
- [[007 - Calling Packaged Subprograms]]
