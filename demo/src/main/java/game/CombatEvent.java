package game;

import java.util.Random;

import game.EnemyManager.enemyTypes;

public class CombatEvent extends Event {
    private Enemy enemy;
    private String enemyIntro;
    private Player player = Main.player;
    private Boolean fleed = false;

    public CombatEvent(enemyTypes type) {
        super();
        enemy = EnemyManager.getEnemy(type);
        enemyIntro = enemy.getType().toString() + EnemyManager.getEnemyIntro();
    }

    public CombatEvent(){
        super();
        enemy = EnemyManager.getEnemy();
        enemyIntro = enemy.getType().toString() + EnemyManager.getEnemyIntro();
    }

    @Override
    public void handleEvent() {
        super.handleEvent();
        System.out.println("\n#" + enemyIntro + "#\n");
        while(enemy.getHealth() > 0 && player.isAlive()){
            outputStatus();
            String action = player.getInput(new String[] {"1","2","3","4","5"});
            handle(action);
        }
        if (player.isAlive() && !fleed) {
            dropLoot();
        }
    }

    private void outputStatus() {
        System.out.println("Your Health: " + player.getHealth()
                            + "\nEnemy Health: " + enemy.getHealth()
                            + "\nYour Actions: "
                            + "\n\t1. Attack "
                            + "\n\t2. Drink Health Potion "
                            + "\n\t3. Flee"
                            + "\n\t4. View Player Stats"
                            + "\n\t5. View Player Items");
    }

    private void handle(String action) {
        switch(action) {
            case "1":
                attack();
                break;
            case "2":
                drinkHealthPotion();
                break;
            case "3":
                flee();
                break;
            case "4":
                viewPlayerStats();
                break;
            case "5":
                System.out.println(Main.player.viewItems());
                break;
          } 
    }

    private void attack() {
        int playerDamage = player.getDamage();
        int enemyDamage = enemy.getDamage();
        enemy.damage(playerDamage);
        player.damage(enemyDamage);
        System.out.println("\t-------------------");
        System.out.println("\t You strike " + enemy.getType() + " for " + playerDamage);
        System.out.println(" ");
        System.out.println("\t" + enemy.getType() + " striked player for " + enemyDamage);
        System.out.println("\t-------------------");
        if(player.getHealth() < 0){
            player.died();
        }
    }

    private void drinkHealthPotion() {
        if(player.getHealthPotions() > 0){
            player.useHealthPotion();
            System.out.println("\tYou have " + player.getHealthPotions() + " health potions left");
        } else {
            System.out.println("\tOut of health potions!");
        }
    }

    private void flee() {
        //This is a hack to make this work. Will need more to be done
        Random rand = new Random();
        fleed = false;
        if(rand.nextBoolean()){
            this.fleed = true;
            player.damage(enemy.getDamage());
            enemy.damage(enemy.getHealth());
            System.out.println("\tYou fled :( , kinda L of you");
        }else{
            player.damage(enemy.getDamage());
            System.out.println("\tFlee failed!");
        }
    }

    private void viewPlayerStats() {
        player.displayStats();
    }

    private void dropLoot() {
        Item droppedItem = LootTable.returnDrop();
        if (droppedItem == null) {
            return;
        }
        System.out.println("\tItem Dropped:"
                            + "\t " + droppedItem.getName()
                            + "\t " + droppedItem.getDescription());
        System.out.println(droppedItem.displayItemStats());
        if (droppedItem.getCurse().equals(false)) {
            handleNormalItem(droppedItem);
        } else if(droppedItem.getCurse().equals(true)){
            handleCursedItem(droppedItem);
        }
    }

    private void handleNormalItem(Item droppedItem) {
        System.out.println("\t Do you wish to equip the item?"
                            + "\t1. Yes"
                            + "\t2. No");
        String input = player.getInput(new String[] {"1","2"});
        if(input.equals("1")){
            equip(droppedItem);
        }
    }

    private void handleCursedItem(Item droppedItem) {
        System.out.println("\tYou have been cursed!");
        equip(droppedItem);
    }

    private void equip(Item droppedItem) {
        droppedItem.addToPlayer();
    }
}