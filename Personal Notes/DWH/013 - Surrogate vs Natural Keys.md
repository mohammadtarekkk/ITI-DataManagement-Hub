# Surrogate vs Natural Keys

## Natural Keys
- **Definition**: Business identifiers from the source system (e.g., `Social Security Number`, `Email Address`, `ISBN`).
- **Pros**: Easy to trace back to source.
- **Cons**: Can change (e.g., person changes email), might be duplicated across systems.

## Surrogate Keys
- **Definition**: System-generated, purely technical keys (usually integers) with no business meaning.
- **Purpose**:
    - **Performance**: Integers join faster than strings/GUIDs.
    - **Independence**: Buffer the DWH from source system changes (e.g., if source reuses IDs).
    - **History**: Essential for handling **SCD Type 2** (tracking history requires multiple rows for the same "Natural Key", so each row needs a unique Surrogate Key).

## Related
- [[014 - Slowly Changing Dimensions]]
- [[008 - Facts and Dimensions]]
