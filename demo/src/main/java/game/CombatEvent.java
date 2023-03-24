package game;

import java.util.Random;

public class CombatEvent extends Event {
    private Enemy enemy;
    private String enemyIntro;
    private Player player = Main.player;
    private Boolean fleed = false;

    public CombatEvent(){
        enemy = EnemyManager.getEnemy();
        super.preview = enemy.getPreview();
        enemyIntro = enemy.getType().toString() + EnemyManager.getEnemyIntro();
    }

    @Override
    public void handleEvent() {
        System.out.println("\n----------------" + super.preview + "----------------");
        System.out.println("\n#" + enemyIntro + "#\n");
        while(enemy.getHealth() > 0 && player.isAlive()){
            outputStatus();
            String action = player.getInput(new String[] {"1","2","3","4","5"});
            handle(action);
            if(player.getHealth() <= 0){
                player.died();
            }
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
                Main.player.viewItems();
                break;
          } 
    }

    private void attack() {
        int playerDamage = player.getDamage();
        int placeHolderEnemyDamage = 0;
        enemy.damage(playerDamage);
        if(enemy.getHealth() > 0){
            int enemyDamage = enemy.getDamage();
            placeHolderEnemyDamage = enemyDamage;
            player.damage(enemyDamage);
        }
        System.out.println("-------------------");
        System.out.println("You strike " + enemy.getType() + " for " + playerDamage);
        System.out.println(" ");
        if(enemy.getHealth() > 0){
            System.out.println(enemy.getType() + " striked player for " + (placeHolderEnemyDamage - Main.player.getArmour()));
        }
        System.out.println("-------------------");
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
        System.out.println("Item Dropped:"
                            + "\n\t" + droppedItem.getName()
                            + "\n\t" + droppedItem.getDescription());
        System.out.println(droppedItem.displayItemStats());
        if (droppedItem.getCurse().equals(false)) {
            handleNormalItem(droppedItem);
        } else if(droppedItem.getCurse().equals(true)){
            handleCursedItem(droppedItem);
        }
    }

    private void handleNormalItem(Item droppedItem) {
        System.out.println("Do you wish to equip the item?"
                            + "\n\t1. Yes"
                            + "\n\t2. No");
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