package game;

public class RizzHammer extends Item {
    static String description = "A sharp sword to cut those who need to be cut";
    static String name = "Sword";
    static Boolean curse = false;

    RizzHammer(){
        super(0, -10, 20,description,name,curse);
    }

    @Override
    public Player addToPlayer(Player player){
        player.setdamage(player.getDamage() + this.getDamage());
        player.setHealth(player.getHealth() + this.getHealth());
        return player;
    }
}
