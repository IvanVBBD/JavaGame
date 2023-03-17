package game;

public class SpikedNecklace extends Item{
    static String description = "A necklace with a surprising sting";
    static String name = "Spiked Necklace";
    static Boolean curse = true;
    static int criticalHitChance = 0;

    SpikedNecklace(){
        super(0, 0, -3,description,name,curse, criticalHitChance);
    }

    @Override
    public Player addToPlayer(Player player){
        player.setdamage(player.getDamage() + this.getDamage());
        return player;
    }
}