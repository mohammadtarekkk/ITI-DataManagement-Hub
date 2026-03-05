# Staging Area

The **Staging Area** is a temporary holding zone where data is landed from source systems before being processed into the Data Warehouse.

## Purpose
1. **Decoupling**: Extracts data without slowing down source systems (OLTP) during heavy processing.
2. **Raw Dump**: Allows "Extract first, Transform later".
3. **Restartability**: If the load fails, you can re-run from staging without querying the source again.

## Types
1. **Transient Staging**:
   - Data is deleted after successful load.
   - Saves storage but loses history of raw data.
2. **Persistent Staging (PSA)**:
   - Retains history of raw data.
   - Useful for auditing and reprocessing if logic changes.

## Related
- [[004 - DWH Architectures]]
- [[018 - ETL vs ELT]]
