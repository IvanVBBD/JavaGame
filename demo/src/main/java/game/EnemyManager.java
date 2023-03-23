package game;

import java.util.List;
import java.util.Random;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.HashMap;;

public class EnemyManager {
    private static String[] enemyIntros = {" has appeared!", " waddled out of the wood work", " superman lands infront of you! BADASS", " wants to lick your elbow"};
   
    public  enum enemyTypes{
        Skeleton,
        Goblin,
        Zombie
    }

    private static Random rand = new Random();
    private static List<Enemy> enemyTable = List.of(
        new Goblin(),
        new Skeleton(),
        new Zombie()
    );

    public static Enemy getEnemy(){
        return enemyTable.get(rand.nextInt(enemyTable.size()));
    }

    public static Enemy getEnemy(enemyTypes Type){

        return enemyTable.stream().filter(x -> x.getType().equals(Type)).findFirst().get();
    }

    public static String getEnemyIntro() {
        Random randGen = new Random();
        return enemyIntros[randGen.nextInt(enemyIntros.length)];
    }
}
