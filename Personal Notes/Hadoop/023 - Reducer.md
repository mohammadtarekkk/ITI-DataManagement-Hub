# Reducer

The Reducer is the final phase of a [[016 - MapReduce Concepts|MapReduce]] job.

## Responsibilities
1. **Reduce Function**: Takes the grouped key-value pairs from the [[020 - Shuffle and Sort]] phase and aggregates them.
2. **Output**: Writes the final result to HDFS (usually).

## Phases
1. **Copy (Shuffle)**: Fetches sorted partition data from Mappers.
2. **Sort (Merge)**: Merges the incoming data groups by key.
3. **Reduce**: Iterates over the values for each key and produces the output.

## Related
- [[020 - Shuffle and Sort]]
- [[022 - Combiner]]
