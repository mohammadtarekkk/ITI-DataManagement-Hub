# DWH Characteristics

According to Bill Inmon, a Data Warehouse has four core characteristics:

## 1. Subject-Oriented
- Organized around key business **subjects** (e.g., Customer, Product, Sales) rather than applications (e.g., Billing System, Order App).
- Focuses on the analysis of a specific subject area.

## 2. Integrated
- Combines data from multiple heterogeneous sources.
- **Consistency**: Enforces standard naming conventions, formats, and units (e.g., all dates in `YYYY-MM-DD`, currency in `USD`).
- Resolves conflicts (e.g., deduplicating customer records).

## 3. Time-Variant
- Stores **historical data** (snapshots) over time (months, years).
- Allows for trend analysis (e.g., "Sales this year vs last year").
- Every record typically has a time element (timestamp or date key).

## 4. Non-Volatile
- Data is **stable** once loaded.
- **Read-only** for users (mostly selected/queried, not updated).
- Changes are handled by adding new records (snapshots) rather than overwriting existing ones, preserving history.

## Related
- [[001 - What is Data Warehouse]]
- [[014 - Slowly Changing Dimensions]]
