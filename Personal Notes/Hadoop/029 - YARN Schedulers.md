# YARN Schedulers

The **[[025 - ResourceManager]]** uses a scheduler to allocate resources.

## Types
1. **FIFO Scheduler**: First In, First Out. Simple but bad for shared clusters (small jobs get stuck behind large ones).
2. **Capacity Scheduler** (Default): Queues with guaranteed capacity. "Cluster within a cluster". Allows sharing while guaranteeing resources for organizations.
3. **Fair Scheduler**: Dynamically balances resources so all jobs get an equal share over time.

## Related
- [[025 - ResourceManager]]
- [[024 - YARN Architecture]]
