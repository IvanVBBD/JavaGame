package game;

public class Zombie extends Enemy {
    static int healthSetting = 30;
    static int damageSetting = 1;
    static String Type = "Zombie";
    static int zombieMultiplyer = 2;
    int stench = 0;

    Zombie(){
        super(healthSetting,damageSetting,Type);
    }

    @Override
    public void damage(int amount){
       super.health -= amount;
    }

    @Override
    public int getDamage(){
        stench++;
        System.out.println("\t============");
        System.out.println("\tThe zombies stench grows worse with each engagement!");
        System.out.println("\t============");
        return stench*super.damage*zombieMultiplyer;

    }
}
