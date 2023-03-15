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
        this.health -= amount;
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
}
