# HDFS Read Anatomy

Reading large files efficiently in HDFS relies on **Data Locality**.

## Steps
1. **Open**: Client opens the file on the [[006 - NameNode]].
2. **Get Locations**: NameNode returns the locations (DataNodes) of the blocks for the file.
   - It sorts the DataNodes by proximity to the client.
3. **Read**: Client connects to the closest **[[007 - DataNode]]** for the first block and streams data.
4. **Next Block**: When the block is finished, the client closes the connection and finds the best DataNode for the next block.

## Failure Handling
If a DataNode fails during a read, the client will:
- Remember the failed node to avoid it.
- Switch to another DataNode that has a replica of that block.
- Verify checksums to ensure data integrity.

## Related
- [[011 - HDFS Write Anatomy]]
- [[009 - Rack Awareness]]
