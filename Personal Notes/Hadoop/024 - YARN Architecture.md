# YARN Architecture

YARN (Yet Another Resource Negotiator) is the resource management layer of Hadoop 2.0+. It decouples resource management from processing.

## Components
1. **[[025 - ResourceManager]]** (Master): One per cluster. Arbitrates resources among all applications.
2. **[[026 - NodeManager]]** (Slave): One per node. Launches and monitors containers.
3. **[[027 - ApplicationMaster]]**: One per application. Negotiates resources from the RM and works with the NM to execute and monitor tasks.
4. **Container**: An abstract notion of resources (CPU, Memory) on a single node.

## Related
- [[003 - Hadoop Ecosystem]]
- [[016 - MapReduce Concepts]]


