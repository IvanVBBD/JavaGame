import java.util.Random;
import java.util.Scanner;

public class Main{
    

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Random randGen = new Random();
        Player currentPlayer = new Player();
        boolean running = true;
        System.out.println("You approach a dark gloomy forests edge...");

        //Main game loop here
        GAME:
        while(running){
            System.out.println("----------------------------------------");
            Enemy currentEnemy = new Enemy(randGen.nextInt(enemyVariables.maxHealth),randGen.nextInt(enemyVariables.maxDamage),enemyVariables.types[randGen.nextInt(enemyVariables.types.length)]);
            System.out.println("\t#" + currentEnemy.getType() + enemyVariables.enemyIntro[randGen.nextInt(enemyVariables.enemyIntro.length)] + "#\n");

            //Deal with mob
            while(currentEnemy.getHealth() > 0){
                System.out.println("\tYour Health: " + currentPlayer.getHealth());
                System.out.println("\tEnemy Health: " + currentEnemy.getHealth());
                System.out.println("\n\tYour actions: ");
                System.out.println("\t1. Attack ");
                System.out.println("\t2. Drink health Potion ");
                System.out.println("\t3. Flee");
                String input = in.nextLine();

                //Player input section
                if(input.equals("1")){

                    currentEnemy.damage(currentPlayer.getDamage());
                    currentPlayer.damage(currentEnemy.getDamage());

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


    }
}

}