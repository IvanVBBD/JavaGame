package game;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private int health = playerVariables.maxHealth;
    private int healthPotions = playerVariables.maxHealthPotions;
    private int damage = 10;
    private int armour = 0;
    private int criticalHitChance = 0;
    private boolean isAlive = true;
    Random rand = new Random();

    public boolean isAlive() {
        return isAlive;
    }

    public void died() {
        isAlive = false;
    }

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
        int multiplyer = 1;
        if(rand.nextInt(100) < criticalHitChance){
            multiplyer = 2;
            System.out.println("\tPlayer Critical Hit!");
        }
        return rand.nextInt(damage*multiplyer);
    }

    public int getMaxDamage(){
        return damage;
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

    public void setCriticalHitChance(int criticalHitChance){
       this.criticalHitChance += criticalHitChance; 
    }

    public int getCriticalChance(){
        return this.criticalHitChance;
    }

    public void displayStats(){
        System.out.println("\t---------Player Stats---------");
        System.out.println("\tMax damage: " + this.getMaxDamage());
        System.out.println("\tArmour: " + this.getArmour());
        System.out.println("\tCritical hit chance: " + this.getCriticalChance() + "%");
        System.out.println("\tHealth potions: " + this.getHealthPotions());
        System.out.println("\tHealth: " + this.getHealth());
        System.out.println("\t------------------------------");
        System.out.println(" ");
    }

    public String getInput(String[] options) {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!(Arrays.asList(options).contains(input))) { 
            input = in.nextLine().replaceAll("\\s", "");
        }
        return input;
    }
}
