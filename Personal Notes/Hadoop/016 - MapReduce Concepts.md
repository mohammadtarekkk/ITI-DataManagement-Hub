# MapReduce Concepts

MapReduce is a programming model for processing large data sets with a parallel, distributed algorithm on a cluster.

## Key Principles
1. **Move Compute to Data**: Processing happens on the node where data resides.
2. **Key-Value Pairs**: The primary data structure used for input and output.
3. **Shared Nothing Architecture**: Tasks run independently and do not share state.

## Core Phases
1. **Map**: Filters and sorts data.
2. **Shuffle and Sort**: Redistributes data based on keys.
3. **Reduce**: Summarizes the data.

## Terminology
- **Job**: The entire process (Mapper + Reducer + Driver).
- **Task**: A single instance of a Map or Reduce operation.
- **Input Split**: A logical chunk of data processed by a single Mapper.

## Related
- [[017 - MapReduce Driver]]
- [[019 - Mapper]]
- [[023 - Reducer]]
- [[020 - Shuffle and Sort]]
