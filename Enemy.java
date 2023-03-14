import java.util.Random;

public class Enemy {

    Enemy(int _health, int _damage, String _type){
        health = _health;
        damage = _damage;
        type = _type;
    }
    private int health = 0;
    private int damage = 0;
    private String type = "";
    private Random rand = new Random();

    public void damage(int _amount){
        health -= _amount;
    }

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
