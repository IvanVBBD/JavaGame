package game;

public class CursedDoll extends Item {
    static String description = "A funny looking doll with strange markings across its body";
    static String name = "Cursed Doll";
    static Boolean curse = true;
    static int damage = -5;
    static int health = -5;

    CursedDoll(){
        super(0, health, damage,description,name,curse, 0);
    }

    @Override
    public void addToPlayer(){
        Main.player.setHealth(Main.player.getHealth() + this.getHealth());
        Main.player.setdamage(Main.player.getMaxDamage() + this.getDamage());
        Main.player.addItemToPlayer(this);
    }

    @Override
    public String displayItemStats(){
        return "\tDamage: " + damage + "\n" + "\tHealth: " + health;
    }

    @Override
    public void removeFromPlayer(){
        Main.player.setdamage(Main.player.getMaxDamage() - this.getDamage());
    }
}
