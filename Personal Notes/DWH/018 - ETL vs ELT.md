# ETL vs ELT

Data integration strategies differ based on *where* the transformation happens.

## ETL (Extract, Transform, Load)
- **Process**: Extract from source -> Transform in separate engine -> Load to DWH.
- **Era**: Prerequisite when storage/compute in DWH was expensive.
- **Pros**: Only clean data enters DWH.
- **Cons**: Rigid, harder to change requirements later.

## ELT (Extract, Load, Transform)
- **Process**: Extract from source -> Load raw into DWH/Lake -> Transform inside the DWH using SQL.
- **Era**: Modern Cloud DWH (BigQuery, Snowflake) where storage/compute is cheap and scalable.
- **Pros**:
    - Faster ingestion (no bottleneck).
    - Agility (Raw data is always there if you need to re-transform).
    - Separation of concerns (Engineers load, Analysts transform).

## Related
- [[005 - Staging Area]]
- [[004 - DWH Architectures]]
