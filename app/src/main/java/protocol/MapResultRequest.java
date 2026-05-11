package protocol;
import java.io.Serializable;

public class MapResultRequest implements Serializable {
    private final String jobId;
    private final Object result; // Partial data from one worker

    public MapResultRequest(String jobId, Object result) {
        this.jobId = jobId;
        this.result = result;
    }

    public String getJobId() { return jobId; }
    public Object getResult() { return result; }
}