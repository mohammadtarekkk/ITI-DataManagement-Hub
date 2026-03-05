# ApplicationMaster

The ApplicationMaster (AM) is a framework-specific library that runs *inside* a container.

## Responsibilities
1. **Negotiation**: Asks the **[[025 - ResourceManager]]** for resource containers.
2. **Execution**: Contacts **[[026 - NodeManager]]s** to launch tasks in those containers.
3. **Monitoring**: Tracks the status and progress of the application's tasks.

> [!NOTE] One per App
> Unlike the RM (one per cluster) or NM (one per node), there is one AM for **each running application**.

## Related
- [[028 - YARN Application Submission]]
- [[016 - MapReduce Concepts]]
