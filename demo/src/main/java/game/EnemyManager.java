package game;

import java.util.List;
import java.util.Random;
public class EnemyManager {
    
    private static Random rand = new Random();
    private static List<Enemy> enemyTable = List.of(
        new Goblin(),
        new Skeleton(),
        new Zombie()
    );


    public static Enemy getEnemy(){
        return enemyTable.get(rand.nextInt(enemyTable.size()));

    }

    public static Enemy getEnemy(String Type){
        return enemyTable.stream().filter(x -> x.getType().equals(Type)).findFirst().get();
    }
}
