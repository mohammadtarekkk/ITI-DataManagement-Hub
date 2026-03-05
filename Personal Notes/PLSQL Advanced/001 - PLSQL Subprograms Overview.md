# PL/SQL Subprograms Overview

A **Subprogram** is a named PL/SQL block that can be stored in the database and invoked repeatedly. This is in contrast to an **Anonymous Block**, which is unnamed, compiled every time it is run, and not saved in the database.

## Types of Subprograms
1. **Procedures**: Perform an action. They do not have to return a value, but they can return multiple values via `OUT` parameters.
2. **Functions**: Compute a value. They **must** return exactly one value directly via the `RETURN` keyword.

## Advantages of Subprograms
- **Reusability**: Write once, call anytime from anywhere (SQL*Plus, Oracle Forms, Java apps, etc.).
- **Performance**: Pre-compiled in the database.
- **Security**: You can grant execution rights to a subprogram without granting direct access to the underlying tables.
- **Maintainability**: Centralized business logic.

## Creating a Subprogram
Both use the `CREATE OR REPLACE` syntax so you don't have to `DROP` them first before modifying the code.
```plsql
CREATE OR REPLACE PROCEDURE ...
CREATE OR REPLACE FUNCTION ...
```
> [!TIP]
> After compiling a procedure or function, if you see "Compiled with warnings" or "Compiled with errors", you can type `show errors;` in your SQL client to see exactly which line broke.

## Related
- [[002 - PLSQL Procedures]]
- [[003 - PLSQL Functions]]
