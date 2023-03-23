package game;
public class Sword extends Item {

    static String description = "A sharp sword to cut those who need to be cut";
    static String name = "Sword";
    static Boolean curse = false;
    static int criticalHitChance = 1;
    static int damage = 5;

    Sword(){
        super(0, 0, 5,description,name,curse, criticalHitChance);
    }

    @Override
    public void addToPlayer(){
        if(!canAddToPlayer()){
            System.out.println("You are at your maxium item limit!");
            return;
        }
        Main.player.setdamage(Main.player.getDamage() + this.getDamage());
        Main.player.setCriticalHitChance(Main.player.getCriticalChance() + this.getCriticalChance());
        Main.player.addItemToPlayer(this);
    }

    @Override
    public String displayItemStats(){
        return "\tDamage: " + damage + "\n" + "\tCritical Hit Chance: " + criticalHitChance;
    }

    @Override
    public void removeFromPlayer(){
        Main.player.setdamage(Main.player.getDamage() - this.getDamage());
        Main.player.setCriticalHitChance(Main.player.getCriticalChance() - this.getCriticalChance());
    }
    
}
