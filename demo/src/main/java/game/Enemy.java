package game;

import java.util.Random;

public abstract class Enemy {

    Enemy(int health, int damage, String type){
        this.health = health;
        this.damage = damage;
        this.type = type;
    }
    protected int health = 0;
    protected int damage = 0;
    private String type = "";
    private Random rand = new Random();

    public abstract void damage(int amount);
       
    public int getHealth(){
        return health;
    }

    public String getType(){
        return type;
    }

    public int getDamage(){
        return rand.nextInt(damage);  
    }
}
