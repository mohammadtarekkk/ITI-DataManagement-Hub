# DataNode

DataNodes are the **Slaves** in the HDFS architecture. They are the workhorses of the file system.

## Responsibilities
1. **Store Data**: They store the actual data blocks on local disk.
2. **Handle Requests**: Serve read and write requests from clients.
3. **Block Operations**: Perform block creation, deletion, and replication upon instruction from the NameNode.
4. **Heartbeats**: Periodically send heartbeats and Block Reports to the NameNode to confirm availability.

## Related
- [[005 - HDFS Architecture]]
- [[008 - HDFS Block]]
