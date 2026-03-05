# MapReduce Driver

The Driver is the entry point of a MapReduce application. It runs on the client machine and orchestrates the job submission.

## Responsibilities
1. **Configuration**: Sets up the job configuration (Job Name, Jar file).
2. **Class Definition**: Specifies which classes to use for the **[[019 - Mapper]]**, **[[023 - Reducer]]**, and optional **[[022 - Combiner]]**.
3. **Paths**: Defines the Input path (where data is in HDFS) and Output path (where results should go).
4. **Submission**: Submits the job to the cluster components (via **[[024 - YARN Architecture]]**) and monitors its progress.

## Related
- [[016 - MapReduce Concepts]]
- [[028 - YARN Application Submission]]
