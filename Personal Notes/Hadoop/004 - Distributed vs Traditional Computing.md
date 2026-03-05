# Distributed vs Traditional Computing

## Traditional Computing (Vertical Scaling)
- **Serial Computation**: Instructions executed one by one on a single processor.
- **Data Movement**: Data is brought to the logic (code) to be processed.
- **Scaling Up**: Adding more power (RAM, CPU) to a single machine.
- **Bottleneck**: Network bandwidth limits data transfer speeds for huge datasets.

## Distributed Computing (Horizontal Scaling)
- **Parallel Computation**: Problem broken into parts solved concurrently on multiple machines.
- **Data Locality**: **Move Compute to Data**. Code is sent to where data resides to minimize network traffic.
- **Scaling Out**: Adding more commodity machines to the cluster.
- **Fault Tolerance**: System handles hardware failures gracefully.

> [!QUOTE]
> "Moving Computation is Cheaper than Moving Data"

## Related
- [[002 - What is Hadoop]]
- [[005 - HDFS Architecture]]
