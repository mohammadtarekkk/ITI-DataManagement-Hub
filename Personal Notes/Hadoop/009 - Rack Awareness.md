# Rack Awareness

Rack Awareness represents the **Block Placement Policy** in HDFS to ensure fault tolerance and data locality.

## Default Placement Policy (Replication Factor = 3)
1. **1st Replica**: On the local node (writer) or a random node if the writer is outside the cluster.
2. **2nd Replica**: On a node in a **different rack**.
3. **3rd Replica**: On a **different node** in the **same remote rack** as the 2nd replica.

This policy protects against:
- **Node Failure**: Data exists on other nodes.
- **Rack Failure**: Data exists on a different rack.
- **Performance**: Writes only cross one network switch (to the remote rack).

## Related
- [[008 - HDFS Block]]
- [[007 - DataNode]]
