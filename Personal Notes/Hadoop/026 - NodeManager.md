# NodeManager

The NodeManager (NM) is the per-node worker of YARN.

## Responsibilities
1. **Container Management**: Launches containers as requested by the **[[027 - ApplicationMaster]]**.
2. **Monitoring**: Monitors resource usage (CPU, Memory) of containers.
3. **Reporting**: Reports node health and status to the **[[025 - ResourceManager]]**.

## Related
- [[024 - YARN Architecture]]
- [[027 - ApplicationMaster]]
