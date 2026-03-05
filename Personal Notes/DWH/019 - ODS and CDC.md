# ODS and CDC

Two critical components/concepts in modern data pipelines.

## ODS (Operational Data Store)
- An intermediate database that integrates data from multiple sources but generally keeps **current** data (volatile) rather than deep history.
- **Purpose**: Operational reporting, real-time lookups.
- Sits between Sources and DWH. unlike DWH, it is optimized for simple queries on current data.

## CDC (Change Data Capture)
- A design pattern to identify and capture changes made to data in a database.
- **Methods**:
    - **Log-based**: Reading database transaction logs (most efficient, real-time).
    - **Query-based**: Polling based on `LastModifiedDate`.
- **Benefit**: Enables real-time replication and minimizes load on source systems compared to full dumps.

## Related
- [[005 - Staging Area]]
- [[018 - ETL vs ELT]]
