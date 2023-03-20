package game;

public class GoldenArmour extends Item {
    static String description = "A sharp sword to cut those who need to be cut";
    static String name = "Sword";
    static Boolean curse = false;
    static int criticalHitChance = 10;
    static int damage = 10;
    static int armour = 10;

    GoldenArmour(){
        super(armour, 0, damage,description,name,curse, criticalHitChance);
    }

    @Override
    public void addToPlayer(){
        Main.player.setdamage(Main.player.getDamage() + this.getDamage());
        Main.player.setCriticalHitChance(Main.player.getCriticalChance() + this.getCriticalChance());
        Main.player.setArmour(Main.player.getArmour() + this.getArmour());
    }
}
