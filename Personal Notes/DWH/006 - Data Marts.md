# Data Marts

A **Data Mart** is a subset of a Data Warehouse focused on a specific business line or department (e.g., Sales, Marketing, Finance).

## Types
1. **Dependent Data Mart**
   - Sourced from the Enterprise Data Warehouse (EDW).
   - "Top-down" approach (Inmon).
   - **Advantage**: Consistent data (Single Source of Truth).

2. **Independent Data Mart**
   - Sourced directly from operational systems.
   - "Bottom-up" approach (often ad-hoc).
   - **Disadvantage**: Can lead to "Data Silos" if not managed with a Bus Architecture.

## Related
- [[004 - DWH Architectures]]
- [[001 - What is Data Warehouse]]
