# HDFS Federation

HDFS Federation is a scalability feature that allows HDFS to support larger clusters and namespace isolation.

## Concept
- **Multiple NameNodes**: Instead of a single NameNode managing the entire namespace, multiple NameNodes manage different parts (volumes) of the filesystem.
- **Namespace Isolation**: Each NameNode manages its own namespace (e.g., `/user` managed by NN1, `/data` managed by NN2).
- **Shared Block Pool**: **[[007 - DataNode]]s** store blocks for ALL NameNodes. A Block Pool is a set of blocks that belong to a single Namespace.

## Benefits
- **Scalability**: Overcomes the memory limits of a single NameNode (solving the [[014 - Small Files Problem]]).
- **Isolation**: prevents a single application from hogging all namespace resources.
- **Performance**: Distributes metadata load across multiple servers.

## Related
- [[005 - HDFS Architecture]]
- [[014 - Small Files Problem]]
