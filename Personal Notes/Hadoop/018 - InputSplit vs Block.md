# InputSplit vs Block

It is crucial to distinguish between logical and physical data representation in MapReduce.

## HDFS Block (Physical)
- A physical chunk of data stored on the disk of a **[[007 - DataNode]]**.
- Fixed size (e.g., 128 MB).

## InputSplit (Logical)
- A logical reference to a chunk of data processed by a single **[[019 - Mapper]]**.
- Does not contain the data itself, just the location (file, start offset, length).
- Usually, **1 Input Split ≈ 1 HDFS Block** to ensure **Data Locality**.

## Related
- [[008 - HDFS Block]]
- [[019 - Mapper]]
