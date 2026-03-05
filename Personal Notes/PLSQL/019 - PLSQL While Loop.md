# PL/SQL While Loop

The **While Loop** evaluates a condition *before* each iteration. The loop runs as long as the condition evaluates to `TRUE`.

## Syntax
```plsql
WHILE condition LOOP
    -- Statements to execute
END LOOP;
```

## Example
```plsql
DECLARE
    v_counter NUMBER := 1;
BEGIN
    -- Condition is checked at the start
    WHILE v_counter <= 5 LOOP
    
        DBMS_OUTPUT.PUT_LINE('Iteration: ' || v_counter);
        
        -- Must increment manually
        v_counter := v_counter + 1;
        
    END LOOP;
END;
/
```

> [!NOTE] Basic vs While
> - **Basic Loop**: Guaranteed to run at least once (because `EXIT` is checked inside).
> - **While Loop**: May not run at all if the initial condition is `FALSE`.

## Related
- [[018 - PLSQL Basic Loop]]
- [[020 - PLSQL For Loop]]
