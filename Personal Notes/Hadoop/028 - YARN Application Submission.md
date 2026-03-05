# YARN Application Submission

The lifecycle of a YARN application:

1. **Submit**: Client submits app to **[[025 - ResourceManager]]**.
2. **Start AM**: RM allocates a container and starts the **[[027 - ApplicationMaster]]**.
3. **Register**: AM registers with RM.
4. **Negotiate**: AM requests containers from RM (Scheduler).
5. **Launch**: AM contacts **[[026 - NodeManager]]s** to launch tasks in allocated containers.
6. **Monitor**: AM monitors task progress.
7. **Finish**: AM unregisters from RM and shuts down.

## Related
- [[024 - YARN Architecture]]
- [[029 - YARN Schedulers]]
