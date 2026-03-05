# HDFS Checkpointing

Checkpointing is the process of merging the **FsImage** and **EditLog** to create a new, up-to-date FsImage. This prevents the EditLog from growing indefinitely and speeds up [[006 - NameNode]] startup.

## Secondary NameNode (Phase 2)
Despite its name, it is **NOT** a backup NameNode. Its job is to perform periodic checkpoints.

### Process
1. Asks NameNode to roll the EditLog (start a new one).
2. Downloads the old EditLog and current FsImage.
3. Merges them locally in memory.
4. Uploads the new FsImage back to the NameNode.

### Evolution
- **Phase 3**: Checkpoint Node & Backup Node (deprecated).
- **Phase 4**: **[[013 - HDFS High Availability]]** (Standby NameNode does the checkpointing now).

## Related
- [[006 - NameNode]]
