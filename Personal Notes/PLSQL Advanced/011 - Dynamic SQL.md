# Dynamic SQL

Normally, PL/SQL blocks cannot contain DDL statements directly. The database engine needs to parse and compile the SQL within the PL/SQL block before running it, and it cannot compile a statement like `CREATE TABLE` inside a block.

**Dynamic SQL** uses the `EXECUTE IMMEDIATE` command to build and run SQL statements entirely as text strings at runtime, bypassing the compiler's strict check.

## Use Cases
- Executing DDL (`CREATE`, `ALTER`, `DROP`) inside a PL/SQL block.
- Building unpredictable `SELECT`, `UPDATE`, or `DELETE` statements on the fly (e.g., dynamically changing the `WHERE` clause based on user input for reports).

## Example: Creating a Table dynamically
```plsql
DECLARE
    -- Build the SQL command as a raw string
    v_sql_stmt VARCHAR2(200);
BEGIN
    v_sql_stmt := 'CREATE TABLE temp_log (log_id NUMBER, log_msg VARCHAR2(100))';
    
    -- Execute it at runtime
    EXECUTE IMMEDIATE v_sql_stmt;
    DBMS_OUTPUT.PUT_LINE('Table created successfully.');
END;
/
```

## Example: Executing Dynamic DDL in a Loop
Suppose you need to drop hundreds of tables sequentially. Rather than writing 100 `DROP` statements manually, you can query the data dictionary and use Dynamic SQL to drop them automatically.

```plsql
DECLARE
    -- Cursor to find all tables starting with 'TEMP_'
    CURSOR c_tables IS 
        SELECT table_name FROM user_tables WHERE table_name LIKE 'TEMP_%';
        
    v_sql VARCHAR2(200);
BEGIN
    FOR t IN c_tables LOOP
        v_sql := 'DROP TABLE ' || t.table_name || ' PURGE';
        EXECUTE IMMEDIATE v_sql;
        DBMS_OUTPUT.PUT_LINE('Dropped: ' || t.table_name);
    END LOOP;
END;
/
```

## Security Warning
Building SQL as strings from user input opens you to **SQL Injection** attacks. Be incredibly careful when concatenating user-provided variables into Dynamic SQL strings.

## Related
- [[014 - PLSQL Introduction and Block Structure]]
