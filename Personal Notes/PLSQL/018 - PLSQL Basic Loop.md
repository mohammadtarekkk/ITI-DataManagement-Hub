# PL/SQL Basic Loop

The **Basic Loop** is an unconditional loop. It will execute continuously until explicitly stopped with an `EXIT` or `EXIT WHEN` statement.

## Syntax
```plsql
LOOP
    -- Statements to execute
    EXIT [WHEN condition];
END LOOP;
```

## Example
```plsql
DECLARE
    v_counter NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE('Iteration: ' || v_counter);
        
        -- Increment to avoid an infinite loop
        v_counter := v_counter + 1;
        
        -- Exit condition
        EXIT WHEN v_counter > 5;
    END LOOP;
END;
/
```
*Output:*
```text
Iteration: 1
Iteration: 2
Iteration: 3
Iteration: 4
Iteration: 5
```

> [!WARNING] Infinite Loops
> If you forget to increment the counter and include an `EXIT WHEN` condition, the loop will run forever.

## Related
- [[019 - PLSQL While Loop]]
- [[020 - PLSQL For Loop]]
