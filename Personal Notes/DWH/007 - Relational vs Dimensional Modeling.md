# Relational vs Dimensional Modeling

## Relational Modeling (OLTP)
- **Goal**: Efficiency in transaction processing (Insert/Update/Delete).
- **Technique**: **Normalization (3NF)**.
- **Characteristics**:
    - Eliminates redundancy.
    - Many tables, many joins.
    - Optimized for writing data.
    - Poor performance for conflicting analytical queries.

## Dimensional Modeling (OLAP)
- **Goal**: Understandability and query performance.
- **Technique**: **Denormalization (Star Schema)**.
- **Characteristics**:
    - Intentional redundancy for speed.
    - Fewer tables (Facts & Dimensions).
    - Optimized for reading/retrieving data.

> "Dimensional modeling packages data in a format that delivers user understandability and query performance."

## Related
- [[008 - Facts and Dimensions]]
- [[009 - Star Schema]]
