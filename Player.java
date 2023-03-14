import java.util.Random;

public class Player {
    private int health = playerVariables.maxHealth;
    private int healthPotions = playerVariables.maxHealthPotions;
    private int damage = 10;
    Random rand = new Random();

    public void setHealth(int _amount){
        health = _amount;
    }

    public void setdamage(int _amount){
        damage = _amount;
    }

    public int getHealth(){
        return health;
    }

    public int getDamage(){
        return rand.nextInt(damage);
    }

    public void damage(int _amount){
        health -= _amount;
        
    }

    public int getHealthPotions(){
        return healthPotions;
    }

    public void useHealthPotion(){
        health += playerVariables.healthPotionHealAmount;
        healthPotions--;
    }
}
