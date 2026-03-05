# PL/SQL Non-Predefined Exceptions

Oracle has thousands of error codes (e.g., `ORA-02292` for violating an integrity constraint). Only the ~20 most common ones have predefined names like `NO_DATA_FOUND`. 

To catch an unnamed Oracle error cleanly (without relying on `WHEN OTHERS`), you must create a **Non-Predefined Exception**.

## The 3 Steps
1. **Declare**: Define an exception name in the `DECLARE` section.
2. **Associate (PRAGMA)**: Link your custom name to a specific Oracle error code using `PRAGMA EXCEPTION_INIT`.
3. **Handle**: Catch it in the `EXCEPTION` section.

## Example: Handling a Constraint Violation
Assume we want to delete a department that still has employees attached to it, triggering `ORA-02292`.

```plsql
DECLARE
    -- 1. Declare name
    e_child_record_exists EXCEPTION;
    
    -- 2. Associate name with specific ORA- error
    PRAGMA EXCEPTION_INIT(e_child_record_exists, -02292);
BEGIN
    -- This will fail if department 10 has employees
    DELETE FROM departments WHERE department_id = 10;
    
EXCEPTION
    -- 3. Handle it cleanly
    WHEN e_child_record_exists THEN
        DBMS_OUTPUT.PUT_LINE('Cannot delete: This department still has employees.');
END;
/
```

## Related
- [[025 - PLSQL Predefined Exceptions]]
- [[027 - PLSQL User-Defined Exceptions]]
