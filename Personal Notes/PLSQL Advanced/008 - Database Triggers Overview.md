# Database Triggers Overview

A **Trigger** is a stored PL/SQL program unit associated with a specific database table, view, or system event. Unlike procedures mapping to manual processes, triggers execute (fire) **implicitly and automatically** when the triggering event occurs.

## Types of Triggers
1. **DML Triggers**: Fire automatically whenever an `INSERT`, `UPDATE`, or `DELETE` statement is issued against a specific table.
2. **DDL Triggers**: Fire when structural changes occur (`CREATE`, `ALTER`, `DROP`). Useful for auditing structural modifications.
3. **Database Event Triggers**: Fire on system events like user `LOGON`, `LOGOFF`, database `STARTUP`, or `SHUTDOWN`. Useful for enforcing logon restrictions or security policies.

## Use Cases for DML Triggers
- Enforcing complex security authorizations (e.g., stopping an `UPDATE` outside business hours).
- Enforcing complex business rules that constraints cannot handle.
- Maintaining derived data or summary tables.
- Auditing user modifications (logging exactly who changed what row and when).
- Generating sequential values automatically (essential in pre-12c Oracle without Identity columns).

## Considerations
- **Excessive Use**: Triggers can slow down DML performance significantly because they fire implicitly in the background. If you do a bulk insert of 10,000 rows, a row-level trigger will execute 10,000 times.
- **Hidden Logic**: Because triggers are automatic, it can be confusing to debug why an `INSERT` statement is failing or taking too long.

## Related
- [[009 - DML Triggers]]
- [[010 - Sequence and Trigger Pairing]]
