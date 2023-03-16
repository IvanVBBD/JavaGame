package game;

public abstract class Event {
    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    private String preview;
    public Event (String preview) {
        this.preview = preview;
    }
    public Enemy getEnemy() {
        return null;
    }
    public String getStory() {
        return null;
    }
}