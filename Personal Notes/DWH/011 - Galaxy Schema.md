# Galaxy Schema

The **Galaxy Schema** (Fact Constellation) is a dimensional model that contains **multiple Fact tables** sharing **common Dimension tables**.

## Structure
- Instead of a single star, it looks like a collection of stars (a galaxy).
- **Conformed Dimensions**: Bridges the gap between facts.
- *Example*: A `Sales Fact` table and an `Inventory Fact` table both share the `Product` and `Date` dimensions.

## Use Case
- Complex businesses with multiple processes seeking integration.
- Allows cross-process analysis (e.g., "Compare Sales vs Inventory levels for Product X").

## Related
- [[009 - Star Schema]]
- [[012 - Dimension Types]]
