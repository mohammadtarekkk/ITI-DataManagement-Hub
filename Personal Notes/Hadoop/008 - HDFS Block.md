# HDFS Block

HDFS breaks large files into smaller chunks known as **blocks**.

## Characteristics
- **Size**: Default size is **128 MB** (previously 64 MB).
- **Replication**: Each block is replicated to ensure fault tolerance. Default replication factor is **3**.

## Why 128 MB?
- **Minimize Seek Time**: Large blocks minimize the cost of disk seeks compared to transfer time.
- **Metadata Management**: Fewer blocks mean less metadata for the NameNode to manage in RAM (addressing the [[014 - Small Files Problem]]).

## Related
- [[007 - DataNode]]
- [[009 - Rack Awareness]]
