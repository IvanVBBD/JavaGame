package game;

public abstract class Item {

    private int armour = 0;
    private int health = 0;
    private int damage = 0;
    private String description = "";
    private String name = "";

    Item(int armour, int health, int damage, String description, String name){
        this.armour = armour;
        this.health = health;
        this.damage = damage;
        this.name = name;
        this.description = description;
    }

    public int getArmour(){
        return this.armour;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getHealth(){
        return this.health;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public abstract Player addToPlayer(Player player);

}
