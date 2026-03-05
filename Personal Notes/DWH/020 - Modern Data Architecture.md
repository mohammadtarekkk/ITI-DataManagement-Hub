# Modern Data Architecture

Evolution of data systems beyond traditional warehousing.

## Data Lake
- A repository that stores massive amounts of **Raw Data** in its native format (Structured, Unstructured, JSON, Images).
- **Cost**: Cheap (Blob storage/S3).
- **Cons**: Can become a "Data Swamp" without governance.

## Data Lakehouse
- Combines the **low cost/flexibility** of a Data Lake with the **management/schema** of a Data Warehouse.
- Supports ACID transactions, schema enforcement, and BI tools directly on lake data (e.g., Delta Lake).

## Medallion Architecture
A layered approach common in Lakehouses:
1. **Bronze Layer**: Raw ingestion (immutable).
2. **Silver Layer**: Cleaned, filtered, validated data.
3. **Gold Layer**: Aggregated, business-level data (Data Marts) ready for reporting.

## Data Vault
- A modeling methodology optimized for **agility**, **auditability**, and **flexibility**.
- **Components**:
    - **Hubs**: Business keys (e.g., Customer ID).
    - **Links**: Relationships (Customer X bought Product Y).
    - **Satellites**: Descriptive attributes and history (Context).
- Allows adding new sources without breaking the model.

## Related
- [[004 - DWH Architectures]]
- [[001 - What is Data Warehouse]]
