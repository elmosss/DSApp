package protocol;

import java.io.Serializable;

public class RemoveGameRequest implements Serializable {
    private String gameName;

    public RemoveGameRequest(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() { //New (rename από getGamename)
        return gameName;
    }
}
