# PL/SQL Packages Overview and Specification

A **Package** is a schema object that groups logically related PL/SQL types, variables, cursors, and subprograms (procedures and functions). Packages consist of two separate parts: the **Specification** (or header) and the **Body**.

## Why use Packages?
- **Modularity**: Organizes related code (e.g., an `HR_PKG` for all employee-related procedures).
- **Information Hiding**: You can hide the complex implementation details in the package body while only exposing necessary functions in the specification.
- **Performance**: When a package is called for the first time, Oracle loads the entire package into memory. Subsequent calls to any subprogram in that package run much faster.
- **Persistent State**: Public variables defined in a package remain in memory and keep their values for the duration of the user's session.

## The Package Specification
The specification declares the **public interface** of the package. It contains prototypes (headers/signatures) of procedures and functions, as well as publicly accessible variables and constants. It **does not contain any executable code**.

### Syntax
```plsql
CREATE OR REPLACE PACKAGE package_name IS | AS
    -- Public type and variable declarations
    v_public_var VARCHAR2(50);
    c_constant CONSTANT NUMBER := 3.14159;
    
    -- Subprogram Prototypes
    PROCEDURE my_procedure(p_param1 NUMBER);
    FUNCTION my_function RETURN DATE;
END package_name;
/
```

### Example
```plsql
CREATE OR REPLACE PACKAGE retired_pkg IS
    -- Constant variable
    pi CONSTANT NUMBER(4, 3) := 3.145; 
    
    -- Function prototype
    FUNCTION check_retired (v_emp_id NUMBER, v_max_hire_year NUMBER) RETURN BOOLEAN;

    -- Procedure prototype
    PROCEDURE move_emp (v_emp_id NUMBER);
END retired_pkg;
/
```
> [!NOTE]
> Compiling the specification means the package is declared to the database, allowing other objects to start referencing its subprograms, even if the body hasn't been written yet.

## Related
- [[006 - PLSQL Package Body]]
- [[007 - Calling Packaged Subprograms]]
