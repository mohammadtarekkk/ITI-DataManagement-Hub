# PL/SQL Introduction and Block Structure

PL/SQL (Procedural Language extension to SQL) is Oracle's proprietary language that adds control structures (loops, ifs, variables) to standard SQL.

## Benefits of PL/SQL
1. **Performance**: Sends blocks of code to the database at once instead of one single SQL statement at a time, reducing network traffic.
2. **Procedural logic**: Variables, loops, and conditions.
3. **Error Handling**: Custom exception handling.

## Anonymous Block Structure
A PL/SQL program is organized into blocks. Variables and constants are defined first, followed by the execution code, and finally exception handling.

```plsql
-- 1. Declaration Section (Optional)
DECLARE
    -- Variables, cursors, user-defined exceptions go here
    v_message VARCHAR2(50) := 'Hello World';
    
-- 2. Executable Section (Mandatory)
BEGIN
    -- SQL and PL/SQL statements go here
    DBMS_OUTPUT.PUT_LINE(v_message);
    
-- 3. Exception Handling Section (Optional)
EXCEPTION
    -- Error handling goes here
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred.');
        
END;
/
```

> [!TIP]
> To see output from `DBMS_OUTPUT` in SQL*Plus or SQL Developer, you must run `SET SERVEROUTPUT ON;` first.

## Related
- [[015 - PLSQL Variables and Data Types]]
- [[020 - PLSQL Exceptions Basics]]
