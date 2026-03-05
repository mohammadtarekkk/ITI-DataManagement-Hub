# DML Triggers

A **DML Trigger** executes automatically before or after an `INSERT`, `UPDATE`, or `DELETE` on a table.

## 1. Statement-Level vs. Row-Level Focus
- **Statement-Level (Default)**: Fires exactly **once** for the triggering SQL statement, regardless of how many rows the statement affects. Useful for enforcing security on the action itself (e.g., "Nobody can delete from this table on Sunday").
- **Row-Level (`FOR EACH ROW`)**: Fires **once for every row** affected by the triggering SQL statement. Useful for validating or auditing individual data changes.

## 2. Timing: `BEFORE` vs. `AFTER`
- **BEFORE**: Executes the PL/SQL block before the DML changes the database. Mostly used for validation or to modify the incoming data.
- **AFTER**: Executes the PL/SQL block after the DML changes the database. Mostly used for auditing or keeping summary tables synchronized.

## Syntax & Example
```plsql
CREATE OR REPLACE TRIGGER secure_employees
    -- Timing and Event
    BEFORE INSERT OR UPDATE ON employees
    -- Focus
    FOR EACH ROW
BEGIN
    -- Business logic
    IF (TO_CHAR(SYSDATE, 'DY') IN ('SAT', 'SUN')) THEN
        RAISE_APPLICATION_ERROR(-20005, 'You may only change data during normal business hours.');
    END IF;
END secure_employees;
/
```

## The `:OLD` and `:NEW` Pseudorecords
Available **only** in Row-Level (`FOR EACH ROW`) triggers. They allow you to inspect the data as it was before the DML, and as it will be after.

- `:OLD.column_name`: The value before the change (NULL for an INSERT).
- `:NEW.column_name`: The value after the change (NULL for a DELETE).

```plsql
CREATE OR REPLACE TRIGGER audit_salary_changes
    AFTER UPDATE OF salary ON employees
    FOR EACH ROW
BEGIN
    -- Log the change to a separate audit table
    INSERT INTO audit_log (emp_id, old_sal, new_sal, changed_by, change_date)
    VALUES (:OLD.employee_id, :OLD.salary, :NEW.salary, USER, SYSDATE);
END;
/
```

## Related
- [[008 - Database Triggers Overview]]
- [[010 - Sequence and Trigger Pairing]]
