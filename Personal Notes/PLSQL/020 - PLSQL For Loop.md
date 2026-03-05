# PL/SQL For Loop

The **For Loop** is ideal when the number of iterations is known in advance. It automatically declares, initializes, increments, and cleans up the counter variable.

## Syntax
```plsql
FOR counter IN [REVERSE] lower_bound .. upper_bound LOOP
    -- Statements to execute
END LOOP;
```

## Example (Standard)
```plsql
BEGIN
    -- 'i' is automatically declared as an integer
    FOR i IN 1 .. 5 LOOP
        DBMS_OUTPUT.PUT_LINE('Iteration: ' || i);
    END LOOP;
END;
/
```

## Example (Reverse)
Counts backward from the upper bound to the lower bound.
```plsql
BEGIN
    -- Must still write as lower_bound .. upper_bound
    FOR i IN REVERSE 1 .. 5 LOOP
        DBMS_OUTPUT.PUT_LINE('Countdown: ' || i);
    END LOOP;
END;
/
```
*Output: 5, 4, 3, 2, 1*

> [!IMPORTANT]
> The counter variable (`i`) scope is limited to the loop. You **cannot** reference it outside the loop, and you **cannot** assign a new value to it inside the loop.

## Related
- [[018 - PLSQL Basic Loop]]
- [[024 - PLSQL Cursors with For Loop]]
