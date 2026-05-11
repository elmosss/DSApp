package protocol;

import java.io.Serializable;

public class ModifyGameRequest implements Serializable {
    private String gameName;
    private String field;
    private Object value;


    public ModifyGameRequest(String gameName, String field, Object value) {
        this.gameName = gameName;
        this.field = field;
        this.value = value;
    }

    public String getGameName() { return gameName; }
    public String getField() { return field; }
    public Object getValue() { return value; }
}
