package game;
import java.util.Random;

public class Player {
    private int health = playerVariables.maxHealth;
    private int healthPotions = playerVariables.maxHealthPotions;
    private int damage = 10;
    private int armour = 0;
    Random rand = new Random();

    public void setHealth(int amount){
        this.health = amount;
    }

    public void setdamage(int amount){
        this.damage = amount;
    }

    public int getHealth(){
        return health;
    }

    public int getDamage(){
        return rand.nextInt(damage);
    }

    public void damage(int amount){
        int temp = amount - armour;
        if(temp < 0){
            temp = 0;
        }
        this.health -= temp;
    }

    public int getHealthPotions(){
        return healthPotions;
    }

    public void setArmour(int armour){
        this.armour = armour;
    }

    public int getArmour(){
        return this.armour;
    }

    public void useHealthPotion(){
        health += playerVariables.healthPotionHealAmount;
        healthPotions--;
    }

    public void displayStats(){
        System.out.println("\t---------Player Stats---------");
        System.out.println("\tMax damage: " + this.getDamage());
        System.out.println("\tArmour: " + this.getArmour());
        System.out.println("\tHealth potions: " + this.getHealthPotions());
        System.out.println("\tHealth: " + this.getHealth());
        System.out.println("\t------------------------------");
        System.out.println(" ");
    }
}
