# PL/SQL IF Conditions

Allows conditional execution of statements based on boolean expressions.

## Basic Syntax
```plsql
IF condition THEN
    statements;
[ELSIF condition THEN
    statements;]
[ELSE
    statements;]
END IF;
```

## Example
```plsql
DECLARE
    v_salary NUMBER := 8000;
    v_bonus  NUMBER := 0;
BEGIN
    IF v_salary > 10000 THEN
        v_bonus := 500;
        DBMS_OUTPUT.PUT_LINE('Tier 1 Bonus');
        
    ELSIF v_salary > 5000 THEN
        v_bonus := 200;
        DBMS_OUTPUT.PUT_LINE('Tier 2 Bonus');
        
    ELSE
        v_bonus := 50;
        DBMS_OUTPUT.PUT_LINE('Tier 3 Bonus');
        
    END IF;
END;
/
```

> [!TIP]
> Notice the spelling is **`ELSIF`**, not `ELSEIF` or `ELSE IF`.
> Remember to always end with **`END IF;`**.

## Handling NULLs
If a condition evaluates to `NULL` (e.g., checking if a variable is `> 10` but the variable holds `NULL`), the condition is treated as **FALSE**, and execution moves to the `ELSE` block.

## Related
- [[014 - PLSQL Introduction and Block Structure]]
- [[018 - PLSQL Basic Loop]]
