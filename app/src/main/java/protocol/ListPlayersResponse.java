package protocol;

import java.io.Serializable;
import java.util.List;

public class ListPlayersResponse implements Serializable {

    private List<String> playerIds;

    public ListPlayersResponse(List<String> playerIds) {
        this.playerIds = playerIds;
    }

    public List<String> getPlayerIds() {
        return playerIds;
    }
}

