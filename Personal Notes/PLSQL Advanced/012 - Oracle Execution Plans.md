# Oracle Execution Plans

When you send a SQL statement to the database, the **Oracle Optimizer** parses it and determines the absolute fastest way to grab the requested data. It outputs its strategy as an **Execution Plan**. Every developer should know how to read these to tune their queries.

## 1. Table Access: `TABLE ACCESS FULL`
A Full Table Scan reads every single row in the table from disk to memory, checking each row sequentially against your `WHERE` condition. 
- Fast for reading the entire table or a large percentage of it.
- Terrible for finding a single specific record in a multimillion-row table.

## 2. Table Access: `INDEX UNIQUE SCAN`
When you search for a specific value using a Primary Key or Unique constraint (e.g., `WHERE employee_id = 100`). The database uses the B-Tree index structure to jump straight to the exact row instantly. Extremely fast.

## 3. Table Access: `INDEX RANGE SCAN`
When you query a non-unique indexed column, or you use range operators like `<`, `>`, or `BETWEEN` on an indexed column. The database jumps to the starting point in the index and scans through the range leaf nodes.

## What is an Index?
An index is a separate data structure (like the index at the back of a book) stored on disk alongside the table to speed up retrieval.
```sql
-- Creating a simple non-unique index
CREATE INDEX idx_emp_last_name ON employees(last_name);
```

### 1. Clustered Index (SQL Server equivalent: IOT in Oracle)
The physical rows in the database table are actually stored ordered on disk exactly according to the index tree structure. A table can only have **one** clustered index because physical data can only be sorted one way on disk.

### 2. Non-Clustered Index (Standard Oracle Index)
The index tree structure is totally separate from the physical table data. The leaf nodes contain pointers (RowIDs) directing the database to exactly where the random physical row is stored on disk. A table can have many non-clustered indexes.

## Viewing a Plan in SQL Developer
To see how Oracle intends to execute a query, press **F10** (Explain Plan) instead of F9. It will show you the exact steps (Scans, Joins, Sorts) and the estimated cost for each.

## Related
- [[002 - Retrieving and Restricting Data]]
