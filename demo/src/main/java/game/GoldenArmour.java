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
        if(!canAddToPlayer()){
            System.out.println("You are at your maxium item limit!");
            return;
        }
        Main.player.setdamage(Main.player.getDamage() + this.getDamage());
        Main.player.setCriticalHitChance(Main.player.getCriticalChance() + this.getCriticalChance());
        Main.player.setArmour(Main.player.getArmour() + this.getArmour());
        Main.player.addItemToPlayer(this);
    }

    @Override
    public String displayItemStats(){
        return "\tDamage: " + damage + "\n" + "\tArmour: " + armour + "\n" + "\t Critical Hit Chance: " + criticalHitChance;
    }
    
    @Override
    public void removeFromPlayer(){
        Main.player.setdamage(Main.player.getDamage() - this.getDamage());
        Main.player.setCriticalHitChance(Main.player.getCriticalChance() - this.getCriticalChance());
        Main.player.setArmour(Main.player.getArmour() - this.getArmour());
    }
}
