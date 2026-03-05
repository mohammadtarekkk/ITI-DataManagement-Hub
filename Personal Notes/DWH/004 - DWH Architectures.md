# DWH Architectures

There are two dominant philosophies in Data Warehousing:

## 1. Inmon Approach (Top-Down / CIF)
**Corporate Information Factory (CIF) - Three-Layer Architecture**
1. **Staging Area**: Raw data ingestion.
2. **Enterprise Data Warehouse (EDW)**: Normalized (3NF) central repository. **Single Source of Truth**.
3. **Data Marts**: Departmental views created *from* the EDW (usually dimensional).

- **Pros**: Consistent enterprise view, easy to create new marts.
- **Cons**: High upfront cost and time, complex to build.

## 2. Kimball Approach (Bottom-Up / Bus)
**Dimensional Modeling - Two-Layer Architecture**
1. **Staging Area**: Raw data ingestion.
2. **Data Marts**: Dimensional models (Star Schemas) built directly from staging.
- **Bus Architecture**: Marts are linked via **Conformed Dimensions** (e.g., shared Customer or Date dimension).

- **Pros**: Faster ROI, easier for business users, agile.
- **Cons**: Potential redundancy if dimensions aren't strictly conformed.

## Related
- [[005 - Staging Area]]
- [[006 - Data Marts]]
- [[007 - Relational vs Dimensional Modeling]]
