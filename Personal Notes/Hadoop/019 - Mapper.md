# Mapper

The Mapper is the first phase of a [[016 - MapReduce Concepts|MapReduce]] job.

## Responsibilities
1. **Read Input**: Reads input splits (usually from [[008 - HDFS Block|HDFS blocks]]).
2. **Parse**: Converts raw data into key-value pairs (Input Key, Input Value).
3. **Map Function**: Application logic processes each pair and emits zero or more intermediate pairs (Output Key, Output Value).

## Input Splits
- The number of Mappers is determined by the number of **Input Splits**.

## Related
- [[020 - Shuffle and Sort]]
- [[018 - InputSplit vs Block]]
