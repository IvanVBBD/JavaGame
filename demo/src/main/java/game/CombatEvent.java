package game;
public class CombatEvent extends Event {
    private Enemy enemy;
    private String enemyIntro;
    private Player player = Main.player;

    public CombatEvent() {
        super();
        enemy = EnemyManager.getEnemy();
        enemyIntro = enemy.getType() + EnemyManager.getEnemyIntro();
    }

    @Override
    public void handleEvent() {
        super.handleEvent();
        System.out.println("\t#" + enemyIntro + "#\n");
        while(enemy.getHealth() > 0 && player.isAlive()){
            outputStatus();
            String action = player.getInput(4);
            handle(action);
        }
        if (player.isAlive()) {
            dropLoot();
        }
    }

    private void outputStatus() {
        System.out.println("\tYour Health: " + player.getHealth()
                            + "\tEnemy Health: " + enemy.getHealth()
                            + "\n\tYour Actions: "
                            + "\t1. Attack "
                            + "\t2. Drink Health Potion "
                            + "\t3. Flee"
                            + "\t4. View Player Stats");
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
        enemy.damage(enemy.getHealth());
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
        String input = player.getInput(2);
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