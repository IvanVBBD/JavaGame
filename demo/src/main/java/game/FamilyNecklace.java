package game;

public class FamilyNecklace extends Item{
    static String description = "This necklace gives off a slight glow";
    static String name = "Family Necklace";
    static Boolean curse = false;
    static int criticalHitChance = 5;
    static int damage = 0;
    static int armour = 0;
    static int health = 0;


    FamilyNecklace(){
        super(armour,health,damage,description,name,curse, criticalHitChance);
    }

    @Override
    public void addToPlayer(){
        if(!canAddToPlayer()){
            System.out.println("You are at your maxium item limit!");
            return;
        }
        Main.player.setCriticalHitChance(Main.player.getCriticalChance() + this.getCriticalChance());
        Main.player.addItemToPlayer(this);
    }

    @Override
    public String displayItemStats(){
        return "\tCritical Hit Chance: " + criticalHitChance;
    }

    @Override
    public void removeFromPlayer(){
        Main.player.setCriticalHitChance(Main.player.getCriticalChance() - this.getCriticalChance());
    }
}
