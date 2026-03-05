# Partitioner

The Partitioner determines which **[[023 - Reducer]]** receives which intermediate key-value pair.

## Mechanism
- **Hash Partitioner**: The default. `hash(key) % num_reducers`.
- **Custom Partitioner**: Users can define logic to send specific keys to specific reducers (e.g., sort by Secondary Sort).

## Role in Shuffle
Partitioning happens in the **[[020 - Shuffle and Sort]]** phase, before the data is spilled to disk on the Map node.

## Related
- [[020 - Shuffle and Sort]]
- [[019 - Mapper]]
