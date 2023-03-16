package game;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main{
    

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Random randGen = new Random();
        Player currentPlayer = new Player();
        ArrayList<Event> playerHistory = new ArrayList();
        PathGen choice;
        ArrayDeque<Event> currentPath;
        String input = "";
        boolean running = true;
        System.out.println("You approach a dark gloomy forests edge...");


        //Main game loop here
        GAME:
        while(running){
            choice = new PathGen();
            //Display sneak peeks and request choice here
            choice.getPaths().forEach((K,V) -> System.out.println(K+". "+V.peekFirst().getPreview()));
            while (!(input.equals("1") || input.equals("2") || input.equals("3"))) {
                input = in.nextLine();
            }
            currentPath = choice.getPaths().get(input).clone();
            input = "";
            while(currentPath.peek() != null){
                //Implement event handling here
                System.out.println("----------------------------------------");
                System.out.println(currentPath.peekFirst().getPreview());
                System.out.println("----------------------------------------");
                if (currentPath.peekFirst() instanceof CombatEvent){
                    //Combat event handling here
                    Enemy currentEnemy = currentPath.peekFirst().getEnemy();
                    System.out.println("\t#" + currentEnemy.getType() + enemyVariables.enemyIntro[randGen.nextInt(enemyVariables.enemyIntro.length)] + "#\n");
                    while(currentEnemy.getHealth() > 0){
                        System.out.println("\tYour Health: " + currentPlayer.getHealth());
                        System.out.println("\tEnemy Health: " + currentEnemy.getHealth());
                        System.out.println("\n\tYour actions: ");
                        System.out.println("\t1. Attack ");
                        System.out.println("\t2. Drink health Potion ");
                        System.out.println("\t3. Flee");
                        input = in.nextLine();

                        //Player input section
                        if(input.equals("1")){

                            int damageDonePlayer = currentPlayer.getDamage();
                            currentEnemy.damage(damageDonePlayer);
                            currentPlayer.damage(currentEnemy.getDamage());

                            System.out.println("\t You strike " + currentEnemy.getType() + " for " + damageDonePlayer);

                            if(currentPlayer.getHealth() < 0){
                                running = false;
                                break;
                            }

                        }else if(input.equals("2")){
                            if(currentPlayer.getHealthPotions() > 0){
                                currentPlayer.useHealthPotion();
                                System.out.println("\tYou have " + currentPlayer.getHealthPotions() + " health potions left");
                            }else{
                                System.out.println("\tOut of health potions!");
                            }

                        }else if(input.equals("3")){
                            //This is a hack to man this work. Will need more to be done
                            currentEnemy.damage(currentEnemy.getHealth());
                        }
                    }
                    input = "";
                    Item droppedItem = LootTable.returnDrop();
                    currentPlayer = droppedItem.addToPlayer(currentPlayer);
                    System.out.println("\tItem Dropped:");
                    System.out.println("\t " + droppedItem.getName());
                    System.out.println("\t " + droppedItem.getDescription());
                } else {
                    //Narrative event handling here
                    System.out.println("----------------------------------------");
                    System.out.println(currentPath.peekFirst().getStory());
                    System.out.println("----------------------------------------");
                }
                playerHistory.add(currentPath.remove());
            }
    }
}

}