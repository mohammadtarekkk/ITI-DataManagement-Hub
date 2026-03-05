# Dimension Types

## 1. Conformed Dimension
- A dimension shared across multiple Data Marts or Fact tables.
- Ensures consistency (e.g. `Customer` means the same thing to Sales and Marketing).

## 2. Role-Playing Dimension
- A single physical dimension table referenced multiple times by a fact table, each playing a different "role".
- *Example*: `Date` dimension used for `Order Date`, `Ship Date`, and `Due Date`.

## 3. Junk Dimension
- A collection of low-cardinality flags and indicators (e.g., specific combinations of "Is_Active", "Gender", "Status") grouped into one table to avoid cluttering the model with many tiny dimensions.

## 4. Degenerate Dimension
- A dimension key without a corresponding dimension table.
- Usually transaction numbers (e.g., `Order ID`, `Invoice Number`) stored directly in the Fact table.

## 5. Mini-Dimension
- A subset of attributes from a large dimension that are frequently analyzed or change often, split off for performance.

## Related
- [[008 - Facts and Dimensions]]
- [[013 - Surrogate vs Natural Keys]]
