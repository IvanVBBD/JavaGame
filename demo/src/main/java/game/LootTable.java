package game;

import java.util.List;
import java.util.Random;
public class LootTable {
    
    LootTable(){

    }
    private static Random rand = new Random();
    private static List<Item> dropTable = List.of(
        new Shield(),
        new Sword(),
        new CursedDoll(),
        new RizzHammer()
    );

    public static Item returnDrop(){
        return dropTable.get(rand.nextInt(dropTable.size()));
    }
}
