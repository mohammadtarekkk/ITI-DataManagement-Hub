# HDFS Architecture

HDFS (Hadoop Distributed File System) follows a **Master/Slave** architecture.

## Components
1. **[[006 - NameNode]]** (Master): Manages the file system namespace and metadata.
2. **[[007 - DataNode]]** (Slave): Stores the actual data blocks.

The architecture handles large files by splitting them into **[[008 - HDFS Block|blocks]]** and distributing them across the cluster.

## Key Features
- **Fault Tolerance**: Detection of faults and quick, automatic recovery.
- **High Throughput**: Designed for batch processing rather than interactive user access.
- **Large Datasets**: Tuned to support files of GBs to TBs in size.
- **Commodity Hardware**: designed to run on clusters of commodity hardware.

## Related
- [[003 - Hadoop Ecosystem]]
- [[006 - NameNode]]
- [[007 - DataNode]]
