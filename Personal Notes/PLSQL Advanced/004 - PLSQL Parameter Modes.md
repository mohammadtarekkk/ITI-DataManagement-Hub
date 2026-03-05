# PL/SQL Parameter Modes

When defining subprograms (Procedures or Functions), you can specify how parameters pass values between the caller and the subprogram.

There are three parameter modes:

## 1. `IN` (Default)
- Passes a value **INTO** the subprogram.
- Inside the subprogram, the parameter acts as a **constant** (it cannot be changed or assigned a new value).
- You can pass a literal (e.g., `100`), an expression (`v_salary * 2`), or a variable.
```plsql
PROCEDURE calc_bonus(v_emp_id IN NUMBER) IS...
```

## 2. `OUT`
- Returns a value **OUT TO** the caller.
- Inside the subprogram, the parameter acts as an uninitialized variable. You **must** assign a value to it before the subprogram finishes.
- When calling the subprogram, you **must** pass a variable to receive the value (you cannot pass a literal like `100`).
```plsql
PROCEDURE get_emp_name(v_emp_id IN NUMBER, v_emp_name OUT VARCHAR2) 
IS
BEGIN
    SELECT last_name INTO v_emp_name FROM employees WHERE employee_id = v_emp_id;
END;
```

## 3. `IN OUT`
- Passes an initial value **INTO** the subprogram and returns an updated value **OUT TO** the caller.
- When calling, you **must** pass a variable.
```plsql
PROCEDURE format_phone_number(v_phone_no IN OUT VARCHAR2) 
IS
BEGIN
    v_phone_no := '(' || SUBSTR(v_phone_no, 1, 3) || ') ' || SUBSTR(v_phone_no, 4);
END;
```

## Calling Subprograms

### 1. Positional Notation
You supply arguments in the exact order they are defined.
```plsql
update_emp_salary(107, 10);
```

### 2. Named Notation (=>)
You explicitly pair the parameter name with the value, so order doesn't matter. Very useful when a subprogram has many parameters, some of which have defaults.
```plsql
update_emp_salary(v_bonus_perc => 10, v_emp_id => 107);
```

## Default Parameters
You can provide a default value to an `IN` parameter. If the caller omits that parameter, the default is used.
```plsql
CREATE OR REPLACE PROCEDURE update_emp_salary(
    v_emp_id NUMBER, 
    v_bonus_perc NUMBER DEFAULT 10
) IS ...

-- Call omitting the second param
BEGIN
    update_emp_salary(107); -- Uses 10% automatically
END;
```

## Related
- [[002 - PLSQL Procedures]]
- [[003 - PLSQL Functions]]
