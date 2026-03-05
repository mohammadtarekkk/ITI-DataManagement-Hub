# Star Schema

The **Star Schema** is the simplest and most common style of dimensional modeling.

## Structure
- **Fact Table**: A central table containing keys to dimensions and numeric measures.
- **Dimension Tables**: Surrounding tables containing descriptive attributes.
- **Relationship**: 1-to-Maybe-Many from Dimension to Fact.

## Diagrams
It looks like a star, with the Fact table in the center and Dimensions radiating outwards.

## Pros & Cons
- **Pros**:
    - Simplest for business users to understand.
    - Best query performance (fewer joins, usually just 1 join per dimension).
    - Supported by most BI tools.
- **Cons**:
    - Data redundancy (denormalized dimensions).
    - e.g., "Cairo" is repeated for every customer in Cairo.

## Related
- [[010 - Snowflake Schema]]
- [[007 - Relational vs Dimensional Modeling]]
