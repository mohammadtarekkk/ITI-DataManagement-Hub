# PLSQL Labs

## Description
This directory contains the completed lab assignments for the PL/SQL module. The exercises span across multiple foundational aspects of Oracle SQL manipulating databases, managing constraints, and introducting PL/SQL blocks.

## Implemented Logic
- **Lab 1 & 2**: Showcases basic data retrieval paired with scalar functions (e.g., string slicing with `SUBSTR`/`LENGTH`, mathematical operations like `MOD`, and formatting dates via `to_char(sysdate)` and `NVL`). Also includes logic to perform `CASE` statement classifications (e.g., job grade translations) dynamically on queried data.
- **Lab 3**: Focuses heavily on Data Definition Language (DDL). Scripts evaluate creating new tables from `SELECT` subqueries, altering schema constraints (`PRIMARY KEY`, `UNIQUE`), dynamically modifying attributes, and creating sequences, views, and system-level synonyms natively natively.
- **Lab 5**: Steps directly into imperative PL/SQL execution blocks. Demonstrates defining and opening an **explicit cursor** to iterate over a result set (filtering specific `hire_date` logic for IT employees) and executing targeted iterative `UPDATE` locks automatically.

## Files
- Accompanied PDFs (`Lab1.pdf` to `Lab5.pdf`) containing the raw coursework deliverables.
- Local `lab1.sql`, `lab2.sql`, `lab3.sql`, `lab4.sql`, and `lab5.sql` files encoding the functional solutions constraint logic.
