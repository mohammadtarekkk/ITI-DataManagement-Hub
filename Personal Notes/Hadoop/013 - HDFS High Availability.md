# HDFS High Availability

Prior to Hadoop 2.0, the **[[006 - NameNode]]** was a Single Point of Failure (SPOF). High Availability (HA) solves this by running two NameNodes: **Active** and **Standby**.

## Architecture
1. **Active NameNode**: Handles all client operations.
2. **Standby NameNode**: Maintains synchronized state to take over immediately if the Active fails.
3. **JournalNodes (JNs)**: A cluster of lightweight daemons. Active NN writes edits to JNs; Standby NN reads them.
4. **ZKFC (ZooKeeper Failover Controller)**: Monitors health of NameNodes and triggers automatic failover.
5. **[[ZooKeeper]]**: Coordination service used for leader election.

### Split-Brain Scenario
A situation where both NameNodes think they are Active. To prevent this, **Fencing** methods are used (e.g., killing the other node's process, revoking write access to JNs).

## Related
- [[006 - NameNode]]
- [[012 - HDFS Checkpointing]]
