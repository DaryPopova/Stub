package application;

public class Answer implements JsonObject {
    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Answer(int code, String description) {
        this.code = code;
        this.description = description;
    }

}