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
    public Player addToPlayer(Player player){
        player.setdamage(player.getDamage() + this.getDamage());
        player.setCriticalHitChance(player.getCriticalChance() + this.getCriticalChance());
        player.setHealth(player.getHealth() + this.getHealth());

        return player;
    }
}
