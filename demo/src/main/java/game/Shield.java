package game;
public class Shield extends Item {

    static String description = "A hardy shield to block punishment";
    static String name = "Shield";
    
    Shield(){
        super(5, 0, 0,description,name);
    }

    public Player addToPlayer(Player player){
        player.setArmour(player.getArmour() + this.getArmour());
        return player;
    }
}
