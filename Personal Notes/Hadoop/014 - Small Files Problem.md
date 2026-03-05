# Small Files Problem

HDFS is designed for large files. Storing millions of small files degrades performance.

## The Problem
- **NameNode Memory**: Every file, directory, and block takes up ~150 bytes in NameNode memory.
- **Example**: 100 million files would require ~15 GB of RAM just for metadata.
- **Throughput**: Reading many small files causes excessive disk seeks on DataNodes.

## Solutions
1. **Hadoop Archives (HAR)**: Packs small files into larger files.
2. **SequenceFiles**: Uses a container format to store small files as key-value pairs.
3. **Application Logic**: Merging files before uploading to HDFS.
4. **[[015 - HDFS Federation]]**: Splitting the namespace across multiple NameNodes.

## Related
- [[006 - NameNode]]
- [[008 - HDFS Block]]
