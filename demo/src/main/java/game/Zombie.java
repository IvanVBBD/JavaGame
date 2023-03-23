package game;

import java.util.Random;
import game.EnemyManager.enemyTypes;

public class Zombie extends Enemy {
    private static String[] previews = {"You smell something rotting.", 
                                        "You hear a muffled groan.", 
                                        "You catch a glimpse of something green."};

    static int healthSetting = 30;
    static int damageSetting = 1;
    static enemyTypes Type = enemyTypes.Zombie;
    static int zombieMultiplyer = 2;
    static Random rand = new Random();
    int stench = 0;

    private String preview;

    Zombie(){
        super(healthSetting,damageSetting,Type);
        preview = previews[rand.nextInt(3)];
    }

    public String getPreview() {return preview;}

    @Override
    public void damage(int amount){
       super.health -= amount;
    }

    @Override
    public int getDamage(){
        stench++;
        System.out.println("\t============");
        System.out.println("\tThe zombies stench grows worse with each engagement!");
        System.out.println("\t============");
        return stench*super.damage*zombieMultiplyer;

    }
}
