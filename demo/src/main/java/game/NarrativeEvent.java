package game;
import java.util.Random;

public class NarrativeEvent extends Event {
    private static String[] storyIntros = {
        "You discover a rickety bridge over a deep, dark chasm",
        "As you walk, you discover an alien forest around you",
        "You spot a cloaked individual laying in a pool of blood"
    };
    private String story;

    public NarrativeEvent() {
        super();
        Random randGen = new Random();
        this.story = storyIntros[randGen.nextInt(storyIntros.length)];
    }

    @Override
    public void handleEvent() {
        super.handleEvent();
        System.out.println("----------------------------------------"
                         + story
                         + "----------------------------------------");
    }
}