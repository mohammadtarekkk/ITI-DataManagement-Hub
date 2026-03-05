# Snowflake Schema

The **Snowflake Schema** is an extension of the Star Schema where dimension tables are **normalized**.

## Structure
- Dimensions are split into sub-dimensions to remove redundancy.
- *Example*: Instead of a single `Product` dimension, you might have `Product` -> `SubCategory` -> `Category`.
- The diagram resembles a snowflake structure.

## Pros & Cons
- **Pros**:
    - **No Redundancy**: Saves storage space (less important now).
    - Easier to update (update "Category" name in one place).
- **Cons**:
    - **Complex Queries**: Requires more joins to get simple attributes.
    - Slower performance.
    - Harder for business users to navigate.

> **Rule of Thumb**: Prefer Star Schema for speed and simplicity. Use Snowflake only when dimensions are massive or for specific storage needs.

## Related
- [[009 - Star Schema]]
- [[011 - Galaxy Schema]]
