package game;
public class Sword extends Item {

    static String description = "A sharp sword to cut those who need to be cut";
    static String name = "Sword";

    Sword(){
        super(0, 0, 5,description,name);
    }

    public Player addToPlayer(Player player){
        player.setdamage(player.getDamage() + this.getDamage());
        return player;
    }
    
}
