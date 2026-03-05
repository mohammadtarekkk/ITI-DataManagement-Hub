# PL/SQL Variables and Data Types

Variables allow you to store and manipulate data temporarily during the execution of a PL/SQL block.

## Declaration Syntax
```plsql
identifier [CONSTANT] datatype [NOT NULL] [:= | DEFAULT initial_value];
```

### Examples
```plsql
DECLARE
    v_name       VARCHAR2(50);
    v_salary     NUMBER(8, 2) := 5000;
    v_hire_date  DATE DEFAULT SYSDATE;
    c_pi         CONSTANT NUMBER := 3.14159;
BEGIN
    -- Assignment using :=
    v_name := 'Ahmed';
    DBMS_OUTPUT.PUT_LINE('Name: ' || v_name || ', Salary: ' || v_salary);
END;
```

## The `%TYPE` Attribute
Instead of hardcoding a data type, you can tell PL/SQL to inherit the exact data type and size of a column in a database table.
- **Advantage**: If the table structure changes (e.g., `last_name` goes from `VARCHAR2(50)` to `VARCHAR2(100)`), the PL/SQL code adapts automatically without needing to be rewritten.

```plsql
DECLARE
    v_emp_name   employees.last_name%TYPE;  -- Takes the type from the table
    v_emp_salary employees.salary%TYPE;
BEGIN
    -- v_emp_name is safely the exact size as the DB column
    NULL; 
END;
```

## Related
- [[014 - PLSQL Introduction and Block Structure]]
- [[016 - PLSQL Select Into]]
