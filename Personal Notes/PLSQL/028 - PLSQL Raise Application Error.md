# PL/SQL Raise Application Error

The `RAISE_APPLICATION_ERROR` procedure is used to throw a custom error directly to the user or calling application. 
Unlike a simple `RAISE`, this actually stops execution and returns an `ORA-` style error code and a string message to the client, effectively rolling back the current statement.

## Syntax
```plsql
RAISE_APPLICATION_ERROR (error_number, 'error_message');
```
- **error_number**: Must be between `-20000` and `-20999` (this range is reserved by Oracle specifically for users).
- **error_message**: A string up to 2048 characters.

## Example: Checking DML Effect
You can use `SQL%NOTFOUND` to check if the last DML statement (`UPDATE` or `DELETE`) actually modified any rows. If it didn't, we can abort the program.

```plsql
BEGIN
    UPDATE employees
    SET salary = salary + 1000      
    WHERE department_id = 999; -- A department that doesn't exist
    
    -- Check if the update caught any rows
    IF SQL%NOTFOUND THEN
        -- Halt execution and throw an error to the user
        RAISE_APPLICATION_ERROR(-20001, 'Update failed: Department not found.');
    END IF;
    
    -- This line will not print if the error above is raised
    DBMS_OUTPUT.PUT_LINE('App continued successfully');
END;
/
```
*Output if run from client:*
```text
ORA-20001: Update failed: Department not found.
ORA-06512: at line 7
```

## Related
- [[027 - PLSQL User-Defined Exceptions]]
- [[009 - Data Manipulation and Transactions]]
