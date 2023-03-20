package game;

public class RizzHammer extends Item {
    static String description = "All we know is Kayden has never wielded this weapon";
    static String name = "Rizz Hamer";
    static Boolean curse = false;

    RizzHammer(){
        super(0, -10, 20,description,name,curse,0);
    }

    @Override
    public void addToPlayer(){
        Main.player.setdamage(Main.player.getDamage() + this.getDamage());
        Main.player.setHealth(Main.player.getHealth() + this.getHealth());
    }
}
