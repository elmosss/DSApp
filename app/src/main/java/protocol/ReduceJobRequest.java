package protocol;
import java.io.Serializable;

public class ReduceJobRequest implements Serializable {
    private final String jobId;
    private final int expectedWorkers;
    private final String jobType;

    public ReduceJobRequest(String jobId, int expectedWorkers, String jobType) {
        this.jobId = jobId;
        this.expectedWorkers = expectedWorkers;
        this.jobType = jobType;
    }

    public String getJobId() { return jobId; }
    public int getExpectedWorkers() { return expectedWorkers; }
    public String getJobType() { return jobType; }
}