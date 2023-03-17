package game;

public class CursedDoll extends Item {
    static String description = "A funny looking doll with strange markings across its body";
    static String name = "Cursed Doll";
    static Boolean curse = false;

    CursedDoll(){
        super(0, -5, 5,description,name,curse);
    }

    @Override
    public Player addToPlayer(Player player){
        player.setHealth(player.getHealth() + this.getHealth());
        return player;
    }
}
