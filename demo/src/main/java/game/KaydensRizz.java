package game;

public class KaydensRizz extends Item{
    static String description = "Quite literally the worst curse of all time";
    static String name = "Kaydens Rizz";
    static Boolean curse = true;
    static int criticalHitChance = -5;
    static int damage = -5;
    static int armour = -5;
    static int health = -5;


    KaydensRizz(){
        super(armour,health,damage,description,name,curse, criticalHitChance);
    }

    @Override
    public void addToPlayer(){
        Main.player.setdamage(Main.player.getDamage() + this.getDamage());
        Main.player.setCriticalHitChance(Main.player.getCriticalChance() + this.getCriticalChance());
        Main.player.setHealth(Main.player.getHealth() + this.getHealth());
        Main.player.setArmour(Main.player.getArmour() + this.getArmour());
    }
}
