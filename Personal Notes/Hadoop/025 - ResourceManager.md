# ResourceManager

The ResourceManager (RM) is the master daemon of YARN.

## Components
1. **Scheduler**: Allocates resources to running applications subject to capacity and queues. It is pluggable (FIFO, Capacity, Fair).
2. **ApplicationsManager**: 
   - Accepts job submissions.
   - Negotiates the first container for the **[[027 - ApplicationMaster]]**.
   - Restarts the AM container on failure.

## Related
- [[029 - YARN Schedulers]]
- [[028 - YARN Application Submission]]
