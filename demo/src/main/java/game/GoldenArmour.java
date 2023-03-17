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
    public Player addToPlayer(Player player){
        player.setdamage(player.getDamage() + this.getDamage());
        player.setCriticalHitChance(player.getCriticalChance() + this.getCriticalChance());
        player.setArmour(player.getArmour() + this.getArmour());
        return player;
    }
}
