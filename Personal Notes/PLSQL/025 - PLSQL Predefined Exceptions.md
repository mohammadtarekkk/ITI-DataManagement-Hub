# PL/SQL Predefined Exceptions

Exceptions in PL/SQL handle runtime errors gracefully so the program doesn't crash abruptly. **Predefined Exceptions** are common errors that Oracle has already named automatically.

## Common Predefined Exceptions
| Exception Name | Triggered When... |
|----------------|-------------------|
| `NO_DATA_FOUND` | A `SELECT INTO` query returns 0 rows. |
| `TOO_MANY_ROWS` | A `SELECT INTO` query returns more than 1 row. |
| `ZERO_DIVIDE` | Attempting to divide a number by zero. |
| `DUP_VAL_ON_INDEX` | Attempting to insert a duplicate value into a column with a UNIQUE constraint. |

## Example Handling
```plsql
DECLARE
    v_name VARCHAR2(50);
BEGIN
    SELECT first_name INTO v_name FROM employees WHERE employee_id = 9999;
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: No employee found with that ID.');
        
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ID is not unique, multiple returned.');
        
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END;
/
```
> [!NOTE] `WHEN OTHERS`
> Acts as a catch-all. `SQLERRM` returns the exact Oracle error message. Always place it at the **very bottom** of the exception block.

## Related
- [[026 - PLSQL Non-Predefined Exceptions]]
- [[027 - PLSQL User-Defined Exceptions]]
