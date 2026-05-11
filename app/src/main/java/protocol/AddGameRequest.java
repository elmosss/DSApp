package protocol;

import shared.Game;

import java.io.Serializable;

public class AddGameRequest implements Serializable {
    private Game game;

    public AddGameRequest(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
