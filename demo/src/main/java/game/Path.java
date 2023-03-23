package game;
import java.util.Random;
import java.util.ArrayDeque;

public class Path {

    private static int MIN_EVENTS = 3;
    private static int MAX_EVENTS = 6;

    public static String getDifficulty(Player player) {
        System.out.println("\nChoose your path:"
                            + "\n\t1: The well-worn path is longer but safer."
                            + "\n\t2: The path through the forest is faster but fraught with danger."
                            + "\n\t3: The valley is shrouded in mist, you know not what awaits you.");
        return player.getInput(new String[] {"1","2","3"});
    }
    
    public static ArrayDeque<Event> generate(String difficulty) {
        switch(difficulty) {
            case "1":
                return generateNarrativePath();
            case "2":
                return generateCombatPath();
            default:
                return generateRandomPath();
          }
    }

    private static ArrayDeque<Event> generateNarrativePath() {
        Random randGen = new Random();
        ArrayDeque<Event> path = new ArrayDeque<Event>(MAX_EVENTS);
        for (int i = 0; i < MIN_EVENTS; i++) {
            if (randGen.nextInt(100) < 70) {
                addNarrativeEventTo(path);
            } else {
                addCombatEventTo(path);
            }
        }
        return path;
    }

    private static ArrayDeque<Event> generateCombatPath() {
        Random randGen = new Random();
        ArrayDeque<Event> path = new ArrayDeque<Event>(MIN_EVENTS);
        for (int i = 0; i < MIN_EVENTS; i++) {
            if (randGen.nextInt(100) < 70) {
                addCombatEventTo(path);
            } else {
                addNarrativeEventTo(path);
            }
        }
        return path;
    }

    private static ArrayDeque<Event> generateRandomPath() {
        Random randGen = new Random();
        int numberOfEvents = randGen.nextInt(MAX_EVENTS + 1) + MIN_EVENTS;
        ArrayDeque<Event> path = new ArrayDeque<Event>(numberOfEvents);
        for (int i = 0; i < numberOfEvents; i++) {
            addRandomEventTo(path);
        }
        return path;
    }

    private static ArrayDeque<Event> addRandomEventTo(ArrayDeque<Event> path) {
        Random randGen = new Random();
        if (randGen.nextBoolean()) {
            addCombatEventTo(path);
        } else {
            addNarrativeEventTo(path);
        }
        return path;
    }

    private static ArrayDeque<Event> addNarrativeEventTo(ArrayDeque<Event> path) {
        Random randGen = new Random();
        path.add(new NarrativeEvent(randGen.nextInt(3)));
        return path;
    }

    private static ArrayDeque<Event> addCombatEventTo(ArrayDeque<Event> path) {
        path.add(new CombatEvent());
        return path;
    }
}