# Shuffle and Sort

The **Shuffle and Sort** phase is the "heart" of MapReduce. It guarantees that input to the [[023 - Reducer]] is sorted by key.

## Process
1. **Buffer**: Mapper output is written to a circular memory buffer (100 MB default).
2. **Spill**: When the buffer reaches a threshold (80%), data is **partitioned**, **sorted**, and **spilled** to local disk.
3. **Merge**: Multiple spill files are merged into a single sorted output file.
4. **Fetch**: Reducers fetch their respective partitions over the network.

## Critical Components
- **[[021 - Partitioner]]**: Decides which Reducer gets which key.
- **[[022 - Combiner]]**: Optional "mini-reducer" run on the map side to reduce network traffic.

## Related
- [[019 - Mapper]]
- [[023 - Reducer]]
