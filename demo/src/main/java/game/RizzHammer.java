package game;

public class RizzHammer extends Item {
    static String description = "All we know is Kayden has never wielded this weapon";
    static String name = "Rizz Hamer";
    static Boolean curse = false;
    static int damage = 20;
    static int armour = -5;

    RizzHammer(){
        super(armour, 0,damage,description,name,curse,0);
    }

    @Override
    public void addToPlayer(){
        if(!canAddToPlayer()){
            System.out.println("You are at your maxium item limit!");
            return;
        }
        Main.player.setdamage(Main.player.getDamage() + this.getDamage());
        Main.player.setArmour(Main.player.getArmour() + this.getArmour());
        Main.player.addItemToPlayer(this);
    }
    @Override
    public String displayItemStats(){
        return "\tDamage: " + damage + "\n" + "\tArmour: " + armour;
    } 

    @Override
    public void removeFromPlayer(){
        Main.player.setdamage(Main.player.getDamage() - this.getDamage());
        Main.player.setArmour(Main.player.getArmour() - this.getArmour());
    }

}
