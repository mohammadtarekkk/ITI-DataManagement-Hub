# Calling Packaged Subprograms

Once a package is created, its public elements (variables, procedures, and functions) can be invoked from outside the package. To access them, use dot notation: `package_name.element_name`.

## Calling Public Methods
To invoke a public procedure from a PL/SQL block:
```plsql
BEGIN
    -- 'retired_pkg' is the package, 'move_emp' is the procedure
    retired_pkg.move_emp(105);
END;
/
```

To call a public function from SQL (if the function contains no DML):
```sql
SELECT employee_id, last_name, retired_pkg.calc_retired_bonus(employee_id, 10) As bonus
FROM employees;
```

## Accessing Public Variables
Variables and constants declared in the package specification can be referenced similarly.
```plsql
DECLARE
    v_pi NUMBER;
BEGIN
    -- Accessing public constant from another PL/SQL block
    v_pi := retired_pkg.pi;
    DBMS_OUTPUT.PUT_LINE('Pi is ' || v_pi);
END;
/
```

## Persistent State of Public Variables
A public variable in a package specification acts as a global session variable. Its value persists for the entire duration of the user's database session.

1. **Initialization**: The first time you call a package, its public variables are initialized (or set to NULL if no default is provided).
2. **Persistence**: If you modify a public variable using a PL/SQL block, the new value remains in memory. Subsequent calls to the package in the same session will "see" the updated value.
3. **Session Bound**: Another user connected in a different session will have their own distinct copy of the package variables in memory.

## Related
- [[005 - PLSQL Packages Overview and Specification]]
- [[006 - PLSQL Package Body]]
