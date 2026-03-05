# Fact Table Types

Different business processes require different types of Fact Tables.

## 1. Transaction Fact Table
- Records individual events (e.g., Every single sale).
- One row per transaction line item.
- **Grain**: Lowest level (Atomic).
- **Pros**: Detailed history. **Cons**: Huge volume.

## 2. Periodic Snapshot Fact Table
- Records the state at a regular interval (e.g., Daily inventory level, Monthly account balance).
- One row per period.
- **Pros**: Easy trend analysis. **Cons**: Doesn't show what happened *between* snapshots.

## 3. Accumulating Snapshot Fact Table
- Tracks a process with multiple milestones (e.g., Order: Placed -> Shipped -> Delivered).
- One row per item (Order).
- Columns updated as milestones occur (`Order_Date`, `Ship_Date`, `Delivery_Date`).
- Used to calculate lag/duration.

## 4. Factless Fact Table
- "Fact" table with no numeric measures.
- Captures relationships between dimensions or event occurrences (e.g., Student attendance: Student + Class + Date).
- Used for **Coverage** (tracking what *didn't* happen, like products on promotion that didn't sell).

## Related
- [[016 - Fact Types]]
- [[008 - Facts and Dimensions]]
