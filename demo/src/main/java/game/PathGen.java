package game;
import java.util.Random;
import java.util.Map;
import java.util.ArrayDeque;
public class PathGen {
    public PathGen() {
        paths = Map.of(
                "1", generatePath(),
                "2", generatePath(),
                "3", generatePath()
        );
    }
    private Map<String, ArrayDeque<Event>> paths;
    private ArrayDeque<Event> generatePath() {
        ArrayDeque<Event> newPath = new ArrayDeque<Event>(3);
        Random randGen = new Random();
        for (int i = 0; i < 3; i++) {
            int EventVariant = randGen.nextInt(3);
            if (randGen.nextInt(2) > 0) {
                Enemy enemy = new Enemy(randGen.nextInt(enemyVariables.maxHealth),randGen.nextInt(enemyVariables.maxDamage),enemyVariables.types[EventVariant]);
                newPath.add(new CombatEvent(EventPreview.previews[EventVariant],enemy));
            } else {
                newPath.add(new NarrativeEvent(EventPreview.previews[EventVariant],Stories.storyIntros[EventVariant]));
            }
        }
        return newPath;
    }

    public Map<String, ArrayDeque<Event>> getPaths() {
        return paths;
    }
}