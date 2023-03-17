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
    public Player addToPlayer(Player player){
        player.setCriticalHitChance(player.getCriticalChance() + this.getCriticalChance());
        return player;
    }
}
