# PL/SQL User-Defined Exceptions

A **User-Defined Exception** is not an Oracle error. It is a business logic error. For example, Oracle has no problem updating a salary to a negative number, but your business rules might forbid it.

## The 3 Steps
1. **Declare**: Define the exception name in the `DECLARE` section.
2. **Raise**: Explicitly trigger the exception in the `BEGIN` section using `RAISE`.
3. **Handle**: Catch it in the `EXCEPTION` section.

## Example
```plsql
DECLARE
    v_salary          NUMBER := -500;
    
    -- 1. Declare
    e_invalid_salary  EXCEPTION;
BEGIN
    -- 2. Raise based on business logic
    IF v_salary < 0 THEN
        RAISE e_invalid_salary;
    END IF;
    
    -- This code won't run if the exception was raised
    UPDATE employees SET salary = v_salary WHERE employee_id = 100;

EXCEPTION
    -- 3. Handle
    WHEN e_invalid_salary THEN
        DBMS_OUTPUT.PUT_LINE('Business Error: Salary cannot be negative!');
END;
/
```

## Related
- [[025 - PLSQL Predefined Exceptions]]
- [[028 - PLSQL Raise Application Error]]
