package game;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static Player player = new Player();

    public static void main(String[] args) {
        startGame();
        String difficulty = Path.getDifficulty(player);
        ArrayDeque<Event> path = Path.generate(difficulty);
        ArrayList<Event> playerHistory = new ArrayList<Event>();

        while(player.isAlive() && path.peek() != null) {
            path.peek().handleEvent();
            playerHistory.add(path.remove());
        }
        endGame();
    }

    private static void startGame() {
        System.out.println("The sun is bright as you come to the outskirts of your village, eager to embark on your adventure. "
                            + "Many adventurers have stood where you are today, making the first step on the road ahead. "
                            + "There is a choice to be made on which direction to take. "
                            + "Such a seemingly small decision can change your entire future.");
    }

    private static void endGame() {
        if (player.isAlive()) {
            System.out.println("\nYou have made it to the end of your journey."
                                + "\nYou lay upon the ground and close your eyes to rest for a while."
                                + "\nYou dream of a vibrant journey.");
        } else {
            System.out.println("\nYou died upon your journey."
                                + "\nYour family back in the village never finds out what happened to you.");
        }
        try (Scanner in = new Scanner(System.in)) {
            in.nextLine();
        }
        System.exit(0);
    }
}