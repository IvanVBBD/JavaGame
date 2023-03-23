package game;

import java.util.Random;

import game.EnemyManager.enemyTypes;

public abstract class Enemy {

    Enemy(int health, int damage, enemyTypes type){
        this.health = health;
        this.damage = damage;
        this.type = type;
    }
    protected int health = 0;
    protected int damage = 0;
    private enemyTypes type;
    private Random rand = new Random();

    public abstract void damage(int amount);
       
    public int getHealth(){
        return health;
    }

    public enemyTypes getType(){
        return type;
    }

    public int getDamage(){
        return rand.nextInt(damage);  
    }

    public abstract String getPreview();
}
