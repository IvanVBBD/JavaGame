package game;

import java.util.List;
import java.util.Random;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.HashMap;

public class EnemyManager {
    private static String[] enemyIntros = {" has appeared!", " waddled out of the wood work", " superman lands infront of you! BADASS", " wants to lick your elbow"};
   
    public  enum enemyTypes{
        Skeleton,
        Goblin,
        Zombie
    }

    private static Random rand = new Random();
 
    public static Enemy getEnemy(){
        enemyTypes enemy = enemyTypes.values()[rand.nextInt(enemyTypes.values().length)];
        switch(enemy){
            case Skeleton:
                return new Skeleton();
            case Goblin:
                return new Goblin();
            case Zombie:
                return new Zombie();
            default:
                return new Goblin();
        }
    }

    public static String getEnemyIntro() {
        return enemyIntros[rand.nextInt(enemyIntros.length)];
    }
}
