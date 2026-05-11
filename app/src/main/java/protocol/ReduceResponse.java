package protocol;
import java.io.Serializable;

public class ReduceResponse implements Serializable {
    private final String jobId;
    private final Object result; // Final aggregated data

    public ReduceResponse(String jobId, Object result) {
        this.jobId = jobId;
        this.result = result;
    }

    public String getJobId() { return jobId; }
    public Object getResult() { return result; }
}