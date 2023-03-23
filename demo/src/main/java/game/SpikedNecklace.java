package game;

public class SpikedNecklace extends Item{
    static String description = "A necklace with a surprising sting";
    static String name = "Spiked Necklace";
    static Boolean curse = true;
    static int criticalHitChance = 0;
    static int damage = -3;

    SpikedNecklace(){
        super(0, 0, damage,description,name,curse, criticalHitChance);
    }

    @Override
    public void addToPlayer(){
        Main.player.setdamage(Main.player.getDamage() + this.getDamage());
        Main.player.addItemToPlayer(this);
    }

    @Override
    public String displayItemStats(){
        return "\tDamage: " + damage;
    }

    @Override
    public void removeFromPlayer(){
        Main.player.setdamage(Main.player.getDamage() - this.getDamage());
    }

}