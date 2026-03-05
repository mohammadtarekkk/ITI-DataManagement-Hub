# PLSQL Advanced Labs

## Description
This directory houses all advanced programming scripts written for the PL/SQL Advanced course, extending imperative operations dynamically natively on the database server.

## Implemented Logic
- **Advanced Exceptions & Procedures (Lab 1)**: Covers creating custom stored procedures (e.g., `ADD_LOC`) inserting location data, wrapping execution within discrete exception handlers mapping directly to system constraints (using `pragma exception_init`).
- **PL/SQL Packages (Lab 2)**: Introduces modularizing logic effectively by bundling procedural logic natively native Database Package specifications natively (e.g., `DEPT_PKG`, `LOC_PKG`). Features explicit function/procedure signatures for robust schema manipulation.
- **Database Triggers (Lab 3)**:
  - Demonstrates a `BEFORE UPDATE` row-level trigger validating logic bounds by dynamically pulling reference boundaries from auxiliary tables and raising application errors bounds are broken.
  - Implements an automated native Audit logging workflow where an `AFTER UPDATE` row-level trigger captures previous values securely natively triggering autonomous stored procedures (`emp_audit_proc`) to capture log traces perfectly.

## Files
- Execution logic distributed over specific components: `Lab1.sql`, `DEPT_PKG.sql`, `DEPT_PKG_body.sql`, `LOC_PKG.sql`, `LOC_PKG_body.sql`, `lab3_q1.sql`, `lab3_q2.sql`, and `exec.sql`. 
- Reference PDFs assigned natively to their respective labs.
