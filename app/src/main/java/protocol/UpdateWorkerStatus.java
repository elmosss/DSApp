package protocol;

public class UpdateWorkerStatus {
    private int port;
    private String status;
    public UpdateWorkerStatus(int port, String status) {
        this.port = port;
        this.status = status;
    }

    public int getPort() {
        return port;
    }

    public String getStatus() {
        return status;
    }
}
