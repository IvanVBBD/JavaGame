package game;

import java.util.Random;

import game.EnemyManager.enemyTypes;

public class Goblin extends Enemy {

    private static String[] previews = {"You hear an annoying high-pitched voice.", 
                                        "You catch a glimpse of something with a short stature.", 
                                        "Goblin into 3"};
    
    static int health = 20;
    static int damage = 10;
    static enemyTypes Type = enemyTypes.Goblin;
    static int goblinLuckThresold = 10;
    static Random rand = new Random();

    private String preview;

    Goblin(){
        super(health,damage,Type);
        preview = previews[rand.nextInt(3)];
    }

    public String getPreview() {return preview;}

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
