# Combiner

The Combiner is an optional optimization in MapReduce, often called a "**Mini-Reducer**".

## Purpose
It runs on the **Map node** (after the map function, before the shuffle) to aggregate data locally. This significantly reduces the amount of data transferred over the network to the Reducer.

## Usage
- Not all functions are associative and commutative (e.g., Average is not, Sum/Max is).
- Combiners *must* have the same input/output key-value types as the Reducer.

## Related
- [[020 - Shuffle and Sort]]
- [[023 - Reducer]]
