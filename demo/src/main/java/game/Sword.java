package game;
public class Sword extends Item {

    static String description = "A sharp sword to cut those who need to be cut";
    static String name = "Sword";
    static Boolean curse = false;
    static int criticalHitChance = 1;

    Sword(){
        super(0, 0, 5,description,name,curse, criticalHitChance);
    }

    @Override
    public void addToPlayer(){
        Main.player.setdamage(Main.player.getDamage() + this.getDamage());
        Main.player.setCriticalHitChance(Main.player.getCriticalChance() + this.getCriticalChance());
    }
    
}
