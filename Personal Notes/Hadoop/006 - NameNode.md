# NameNode

The NameNode is the **Master** of the HDFS architecture. It maintains the file system tree and the metadata for all the files and directories in the tree.

## Responsibilities
1. **Manage Metadata**: Stores information about files (name, permissions, etc.) and the file system structure.
2. **Block Management**: Keeps track of which blocks belong to which file and where they are located (Block Map).
3. **Client Requests**: Handles file opening, closing, and renaming.

## Metadata Storage
- **FsImage**: A point-in-time snapshot of the file system metadata stored on disk that contains list of files, files attributes, list of blocks of each file. (RAM and Disk)
- **EditLog**: A transaction log that records every change (create, delete, write) that occurs to the file system metadata. (Disk only)
- **Block Map**: Stored in **RAM only**. Stores list of DataNodes for each block. It is rebuilt at startup based on block reports from DataNodes.

## Related
- [[005 - HDFS Architecture]]
- [[012 - HDFS Checkpointing]]
- [[013 - HDFS High Availability]]
