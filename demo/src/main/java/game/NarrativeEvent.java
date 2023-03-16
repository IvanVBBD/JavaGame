package game;

public class NarrativeEvent extends Event {
    @Override
    public String getStory() {
        return story;
    }

    private String story;
    public NarrativeEvent (String pv, String story) {
        super(pv);
        this.story = story;
    }
}