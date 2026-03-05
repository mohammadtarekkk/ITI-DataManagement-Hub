# PL/SQL Records

A **Record** is a composite data type that allows you to treat related but dissimilar data (like a row in a table) as a single logical unit. It is similar to a `struct` in C.

## Defining and Using a Record

1. **Define the TYPE**: Create the structure of the record.
2. **Declare the Variable**: Instantiate the record based on the type.
3. **Usage**: Access fields using dot notation (`record_name.field_name`).

### Example
```plsql
DECLARE
    -- 1. Define the record type
    TYPE t_emp_record IS RECORD (
        emp_id     NUMBER(8),
        emp_name   VARCHAR2(50),
        emp_salary NUMBER(8, 2)
    );
    
    -- 2. Declare a variable of this type
    v_employee t_emp_record;
BEGIN
    -- 3. Populate using SELECT INTO
    SELECT employee_id, first_name, salary
    INTO v_employee.emp_id, v_employee.emp_name, v_employee.emp_salary
    FROM employees
    WHERE employee_id = 100;
    
    -- Print
    DBMS_OUTPUT.PUT_LINE(v_employee.emp_name || ' earns ' || v_employee.emp_salary);
END;
/
```

## Related
- [[022 - PLSQL Records with %ROWTYPE]]
- [[015 - PLSQL Variables and Data Types]]
