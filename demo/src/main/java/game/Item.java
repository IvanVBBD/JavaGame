package game;

public abstract class Item {

    private int armour = 0;
    private int health = 0;
    private int damage = 0;
    private String description = "";
    private String name = "";
    private Boolean curse = false;

    Item(int armour, int health, int damage, String description, String name, Boolean curse){
        this.armour = armour;
        this.health = health;
        this.damage = damage;
        this.name = name;
        this.description = description;
        this.curse = curse;
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

    public Boolean getCurse(){
        return this.curse;
    }

    public abstract Player addToPlayer(Player player);

}
