package game;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class EnemyManager {
    private static String[] enemyIntros = {" has appeared!", " waddled out of the wood work", " superman lands infront of you! BADASS", " wants to lick your elbow"};
   
    private static final List<Supplier<Enemy>> constructors = List.of(Goblin::new, Skeleton::new, Zombie::new);

    public  enum enemyTypes{
        Skeleton,
        Goblin,
        Zombie
    }

    private static Random rand = new Random();
 
    public static Enemy getEnemy(){
        return constructors.get(rand.nextInt(constructors.size())).get();
    }

    public static String getEnemyIntro() {
        return enemyIntros[rand.nextInt(enemyIntros.length)];
    }
}
