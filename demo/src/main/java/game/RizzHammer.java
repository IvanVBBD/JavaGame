package game;

public class RizzHammer extends Item {
    static String description = "All we know is Kayden has never wielded this weapon";
    static String name = "Rizz Hamer";
    static Boolean curse = false;

    RizzHammer(){
        super(0, -10, 20,description,name,curse,0);
    }

    @Override
    public Player addToPlayer(Player player){
        player.setdamage(player.getDamage() + this.getDamage());
        player.setHealth(player.getHealth() + this.getHealth());
        return player;
    }
}
