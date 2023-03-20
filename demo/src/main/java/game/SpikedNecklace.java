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
    public void addToPlayer(){
        Main.player.setdamage(Main.player.getDamage() + this.getDamage());
    }
}