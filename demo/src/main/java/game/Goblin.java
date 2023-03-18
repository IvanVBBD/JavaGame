package game;

import java.util.Random;

public class Goblin extends Enemy {
    
    static int health = 20;
    static int damage = 10;
    static String Type = "Goblin";
    static int goblinLuckThresold = 10;
    static Random rand = new Random();
    Goblin(){
        super(health,damage,Type);
    }

    @Override
    public void damage(int amount){
        int goblinLuck = rand.nextInt(100);
        if(goblinLuck <= goblinLuckThresold){
            System.out.println("The player misses the goblin, lucky thing. The goblin makes an L sign with his two fingers");
        }else{
            super.health -= amount;
        }
    }

}
