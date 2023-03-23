package game;
import java.util.Random;

public abstract class Event {
    private static String[] previews = {
        "You hear a creaking sound coming from the passage",
        "You catch a glimpse of green in the distance",
        "A muffled groan drifts to your ears"
    };
    protected String preview;

    public Event() {
        Random randGen = new Random();
        this.preview = previews[randGen.nextInt(previews.length)];
    }

    public void handleEvent() {
        System.out.println("----------------------------------------"
                          + preview
                          +"----------------------------------------");
    }
}