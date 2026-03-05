# Data Dictionary and Privileges

## Data Dictionary
Read-only tables and views populated by the Oracle Server containing metadata (data about your data).

### Prefixes
1. `USER_`: Objects owned by you.
2. `ALL_`: Objects you have access to (yours + granted).
3. `DBA_`: All objects in the database (requires admin).

### Common Views
```sql
SELECT * FROM USER_TABLES; 
SELECT * FROM USER_TAB_COLUMNS WHERE table_name = 'COUNTRIES';
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_CONS_COLUMNS; -- Constraints on column level
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_SYNONYMS;
SELECT * FROM USER_OBJECTS;      -- All your objects (Tables, Views, Seq...)
```

## System Privileges
Permissions to perform a specific action (e.g., creating a table, creating a session to log in).
- **Grant**: `GRANT CREATE SESSION, CREATE TABLE TO omar;`
- **Revoke**: `REVOKE CREATE TABLE FROM omar;`

## Object Privileges
Permissions to perform actions on a specific object (e.g., Selecting from HR's table).
- **Grant**: `GRANT SELECT, INSERT ON hr.employees TO omar;`

## Roles
A group of privileges clustered together for easier assignment.
```sql
-- Create role
CREATE ROLE app_developer;

-- Add privileges to role
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW TO app_developer;

-- Assign role to user
GRANT app_developer TO omar;
```

## Related
- [[011 - Schema Objects]]
- [[001 - SQL Statements Overview]]
