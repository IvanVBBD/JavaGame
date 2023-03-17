package game;
public class Shield extends Item {

    static String description = "A hardy shield to block punishment";
    static String name = "Shield";
    static Boolean curse = false;
    
    Shield(){
        super(5, 0, 0, description, name, curse);
    }

    @Override
    public Player addToPlayer(Player player){
        player.setArmour(player.getArmour() + this.getArmour());
        return player;
    }
}
