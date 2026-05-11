package protocol;

import shared.Game; //New
import java.io.Serializable;
import java.util.List; //New

public class SearchGamesResponse implements Serializable {
    private boolean success;
    private String message;
    private List<Game> games;

    public SearchGamesResponse(boolean success, String message, List<Game> games) {
        this.success = success;
        this.message = message;
        this.games = games;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public List<Game> getGames() { return games; }
}
