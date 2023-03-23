package game;

public class GiantsHammer extends Item{
    static String description = "So heavy....Maybe a little to heavy";
    static String name = "Giants Hammer";
    static Boolean curse = false;
    static int criticalHitChance = 0;
    static int damage = 30;
    static int armour = 0;
    static int health = -20;


    GiantsHammer(){
        super(armour,health,damage,description,name,curse, criticalHitChance);
    }

    @Override
    public void addToPlayer(){
        if(!canAddToPlayer()){
            System.out.println("You are at your maxium item limit!");
            return;
        }
        Main.player.setdamage(Main.player.getDamage() + this.getDamage());
        Main.player.setHealth(Main.player.getHealth() + this.getHealth());
        Main.player.addItemToPlayer(this);
    }

    @Override
    public String displayItemStats(){
        return "\tDamage: " + damage + "\n" + "\tHealth: " + health;
    }

    @Override
    public void removeFromPlayer(){
        Main.player.setdamage(Main.player.getDamage() - this.getDamage());
    }
}
