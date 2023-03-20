package game;

public class CursedDoll extends Item {
    static String description = "A funny looking doll with strange markings across its body";
    static String name = "Cursed Doll";
    static Boolean curse = true;

    CursedDoll(){
        super(0, -5, 5,description,name,curse, 0);
    }

    @Override
    public void addToPlayer(){
        Main.player.setHealth(Main.player.getHealth() + this.getHealth());
    }
}
