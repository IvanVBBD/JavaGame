package game;
public class Sword extends Item {

    static String description = "A sharp sword to cut those who need to be cut";
    static String name = "Sword";
    static Boolean curse = false;

    Sword(){
        super(0, 0, 5,description,name,curse);
    }

    @Override
    public Player addToPlayer(Player player){
        player.setdamage(player.getDamage() + this.getDamage());
        return player;
    }
    
}
