package game;

import java.util.List;
import java.util.Random;
public class LootTable {
    
    LootTable(){

    }
    private static int curseThresold = 10;
    private static int commonThresold = 30;
    private static int rareThresold = 90;
    private static Random rand = new Random();
    private static List<Item> rareDropTable = List.of(
        new RizzHammer(),
        new GoldenArmour(),
        new GiantsHammer()
    );

    private static List<Item> commonDropTable = List.of(
        new Sword(),
        new Shield(),
        new FamilyNecklace()
    );

    private static List<Item> curseDropTable = List.of(
        new SpikedNecklace(),
        new CursedDoll(),
        new KaydensRizz()
    );

    public static Item returnDrop(){
        int chance = rand.nextInt(100);
        if(chance >= rareThresold){
            return rareDropTable.get(rand.nextInt(rareDropTable.size()));
        }else
        if(chance >= commonThresold){
            return commonDropTable.get(rand.nextInt(commonDropTable.size()));
        }else 
        if(chance >= curseThresold){
            return curseDropTable.get(rand.nextInt(curseDropTable.size()));
        }
        return null;
    }
}
