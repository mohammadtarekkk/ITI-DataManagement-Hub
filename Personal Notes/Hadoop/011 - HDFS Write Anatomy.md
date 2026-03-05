# HDFS Write Anatomy

The process of writing a file to HDFS involves a coordinated pipeline between the Client, [[006 - NameNode]], and [[007 - DataNode]]s.

## Steps
1. **Create Request**: Client asks NameNode to create a new file in the filesystem namespace.
2. **Checks**: NameNode checks for file existence and user permissions.
3. **Block Allocation**: NameNode returns the list of DataNodes to host replicas for the first [[008 - HDFS Block|block]].
4. **Data Pipelining**:
   - Client pushes data to the first DataNode.
   - First DataNode pushes to the second.
   - Second to the third (forming a pipeline).
5. **Packets**: Data is sent in small packets (64KB).
6. **Ack Queue**: DataNodes send acknowledgments back up the pipeline.
7. **Complete**: When the block is finished, the client requests a new block from the NameNode.

## Related
- [[010 - HDFS Read Anatomy]]
- [[005 - HDFS Architecture]]
- [[009 - Rack Awareness]]
