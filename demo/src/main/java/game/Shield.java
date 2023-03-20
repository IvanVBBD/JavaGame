package game;
public class Shield extends Item {

    static String description = "A hardy shield to block punishment";
    static String name = "Shield";
    static Boolean curse = false;
    
    Shield(){
        super(5, 0, 0, description, name, curse, 0);
    }

    @Override
    public void addToPlayer(){
        Main.player.setArmour(Main.player.getArmour() + this.getArmour());
    }
}
