package game;
import java.util.Random;

import game.EnemyManager.enemyTypes;

public class Skeleton extends Enemy {
    
    static int healthSetting = 10;
    static int damageSetting = 15;
    static enemyTypes Type = enemyTypes.Skeleton;
    static Random rand = new Random();
    static int skellySkill = 25;

    Skeleton(){
        super(healthSetting,damageSetting,Type);
    }

    @Override
    public void damage(int amount){
       super.health -= amount;
    }

    @Override
    public int getDamage(){
        int chance = rand.nextInt(skellySkill);
        if(chance < skellySkill){
            System.out.println("\t============");
            System.out.println("\tYears of being alive allows the skeleton to kick ass. Critical Hit!");
            System.out.println("\t============");

            return rand.nextInt(super.damage*2);
        }else{
            return rand.nextInt(super.damage);
        }
    }
}
