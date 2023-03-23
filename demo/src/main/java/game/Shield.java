package game;
public class Shield extends Item {

    static String description = "A hardy shield to block punishment";
    static String name = "Shield";
    static Boolean curse = false;
    static int armour = 5;
    
    Shield(){
        super(armour, 0, 0, description, name, curse, 0);
    }

    @Override
    public void addToPlayer(){
        if(!canAddToPlayer()){
            System.out.println("You are at your maxium item limit!");
            return;
        }
        Main.player.setArmour(Main.player.getArmour() + this.getArmour());
        Main.player.addItemToPlayer(this);
    }

    @Override
    public String displayItemStats(){
        return "\tArmour: " + armour;
    }
    
    public void removeFromPlayer(){
        Main.player.setArmour(Main.player.getArmour() - this.getArmour());
    }
}
