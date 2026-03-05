# Slowly Changing Dimensions (SCD)

Dimensions change over time (e.g., customer moves address). How we handle this change defines the SCD type.

## Type 0: Retain Original
- Ignore changes. Keep the original value forever.

## Type 1: Overwrite
- Overwrite the old value with the new one.
- **No history kept**.
- Used for error corrections.

## Type 2: Add New Row
- Insert a new record for the new value with a new Surrogate Key.
- Track effective dates (`Start_Date`, `End_Date`) and `Is_Current` flag.
- **Full history kept**. Most common for DWH.

## Type 3: Add New Column
- Add a column for the previous value (e.g., `Current_Region`, `Previous_Region`).
- **Limited history** (usually just the last change).

## Type 4: Mini-Dimension (History Table)
- Split rapidly changing attributes into a separate "History" dimension referenced by the Fact table.

## Related
- [[013 - Surrogate vs Natural Keys]]
- [[012 - Dimension Types]]
