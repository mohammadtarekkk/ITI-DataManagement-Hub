class DataJob:
    job_type = "Batch"
    _job_count = 0

    def __init__(self, job_name, source, destination):
        self.job_name = job_name
        self.source = source
        self.__destination = destination
        DataJob._job_count += 1

    def describe_job(self):
        print(f"Job Name: {self.job_name}")
        print(f"Job Type: {DataJob.job_type}")
        print(f"Source: {self.source}")
        print(f"Destination: {self.__destination}")

    def get_destination(self):
        return self.__destination

    def change_destination(self, new_destination):
        if new_destination:
            self.__destination = new_destination
        else:
            print("Destination cannot be an empty.")

    @staticmethod
    def get_job_count():
        return DataJob._job_count


job1 = DataJob("Job1", "SourceA", "DestinationA")
job2 = DataJob("Job2", "SourceB", "DestinationB")
job3 = DataJob("Job3", "SourceC", "DestinationC")
print(DataJob.get_job_count())
job1.change_destination("")
job1.change_destination("NewWarehouse")
print(job1.get_destination())
