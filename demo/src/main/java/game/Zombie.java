package game;

import java.util.Random;
import game.EnemyManager.enemyTypes;

public class Zombie extends Enemy {
    private static String[] intros = {"Zombie intro 1", "Zombie intro 2", "Zombie into 3"};

    static int healthSetting = 30;
    static int damageSetting = 1;
    static enemyTypes Type = enemyTypes.Zombie;
    static int zombieMultiplyer = 2;
    static Random rand = new Random();
    int stench = 0;

    private String intro;

    Zombie(){
        super(healthSetting,damageSetting,Type);
        intro = intros[rand.nextInt(3)];
    }

    public String getIntro() {return intro;}

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
