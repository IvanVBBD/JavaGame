package game;
import java.util.Random;
import java.util.Map;

public class NarrativeEvent extends Event {
    private static String[] storyIntros = {
        "You discover a rickety bridge over a deep, dark chasm. A golden glimmer flickers faintly on the other side.",
        "As you walk, you discover an alien forest around you. On the edge of the path is an enormous flower with a sweet scent.",
        "You spot a cloaked individual laying in a pool of blood. They call out to you weakly."
    };
    private int variant;
    private String[][] actions = {
            {"Risk a long fall with an abrupt stop for treasure", "I'm scared of heights"},
            {"Approach the flower, I like the smell of that nectar","That flower looks mega sus, I'm out"},
            {"He looks like he could use a drink. Maybe a healing potion will do?","Shady, cloaked dudes scare me"}
};

    private int[][] successChance = {
            {70,100},
            {60,60},
            {60,1}
};
    private Player player = Main.player;

    private void getRizzed() {
        Item rizz = new KaydensRizz();
        System.out.println("\tThe cloaked person calls upon Kayden to curse you for your apathy!"
                            +"\n\tKayden: Is that a mirror in your pocket? Cause I can see myself in your pants."
                            +"\n\tYou have been rizzed!");
        rizz.addToPlayer();
    }

    public NarrativeEvent(int variant) {
        super();
        this.variant = variant;
    }

    @Override
    public void handleEvent() {
        System.out.println("\n---"
                         + storyIntros[variant]
                         + "---");
        System.out.println("What next?"
                        +"\n\t 1. "+actions[variant][0]
                        +"\n\t 2. "+actions[variant][1]);
        String action = player.getInput(new String[] {"1","2"});
        handle(action);
    }

    private void getRare() {
        Item droppedItem = LootTable.rareRoll();
        System.out.println("\tYou have gained:"
                + "\n\t " + droppedItem.getName()
                + "\n\t " + droppedItem.getDescription());
        System.out.println("\t Do you wish to equip the item?"
                + "\n\t1. Yes"
                + "\n\t2. No");
        String input = player.getInput(new String[] {"1","2"});
        if(input.equals("1")){
            droppedItem.addToPlayer();
        }
    }
    private void getNormal() {
        Item droppedItem = LootTable.returnDrop();
        if (droppedItem.getCurse()) {
            System.out.println("\tYou have been cursed!");
            droppedItem.addToPlayer();
        } else {
            System.out.println("\tYou have gained:"
                    + "\n\t " + droppedItem.getName()
                    + "\n\t " + droppedItem.getDescription());
            System.out.println("\t Do you wish to equip the item?"
                    + "\n\t1. Yes"
                    + "\n\t2. No");
            String input = player.getInput(new String[] {"1","2"});
            if(input.equals("1")) {
                droppedItem.addToPlayer();
            }
        }
    }
    private void rizzHammer() {
        Item rizzler = new RizzHammer();
        System.out.println("\tYou have gained:"
                + "\n\t " + rizzler.getName()
                + "\n\t " + rizzler.getDescription());
        System.out.println("\t Do you wish to equip the item?"
                + "\n\t1. Yes"
                + "\n\t2. No");
        String input = player.getInput(new String[] {"1","2"});
        if(input.equals("1")){
            rizzler.addToPlayer();
        }
    }
    private void handle(String action) {
        Random randGen = new Random();
        int roll = randGen.nextInt(0,101);
        switch(action) {
            case "1":
                if (roll <= successChance[variant][0]) {
                    if (variant == 0) {
                        System.out.println("\tDespite how dodgy the bridge seems, you manage to retrieve the treasure and come back.");
                        getRare();
                    }
                    if (variant == 1) {
                        System.out.println("\tThe flower's nectar looks REALLY similar to health potions, so you take some in a spare bottle.");
                        player.addPotion(1);
                    }
                    if (variant == 2) {
                        System.out.println("\tAfter drinking your red KoolAid, the person stands up. He blesses you in the name of Kayden"
                                +"\n\tKayden: If you were a vegetable, you'd be a CUTEcumber."
                                +"\n\tThe RizzHammer descends from above");
                        rizzHammer();
                    }
                } else {
                    if (variant == 0) {
                        System.out.println("\tIt seems like the bridge was strong enough to hold you, but not with the treasure as well.");
                        player.died();
                        System.out.println("\tYou fall, screaming, into the abyss. There is only Kayden here.");
                    }
                    if (variant == 1) {
                        System.out.println("\tThe flower was a honeypot. It eats your leg.");
                        player.damage(player.getHealth()-1);
                    }
                    if (variant == 2) {
                        System.out.println("\tAs the person stands up, their cloak slips. The rizz is too intense and knocks you unconscious");
                        player.removeAllItems();
                        System.out.println("\tWhen you come to, you notice that all your loot is gone."
                                +"\n\tA note next to you says: Never should have come here - Rizzler");
                    }
                }
                break;
            case "2":
                if (roll <= successChance[variant][1]) {
                    if (variant == 0) {
                        System.out.println("\tYour spidey-senses tell you the bridge will break, so you leave.");
                    }
                    if (variant == 1) {
                        System.out.println("\tYou stumble into a rotten corpse in the underbrush. He kindly bestows his item upon you.");
                        getNormal();
                    }
                    if (variant == 2) {
                        System.out.println("\tAlthough the cloaked person calls upon Kayden, it seems he is too busy trying to hit on someone else to curse you."
                                +"\n\tHow lucky are you?");
                    }
                } else {
                    if (variant == 0) {
                        //This shouldn't happen
                        System.out.println("\tYour spidey-senses tell you the bridge will break, so you leave.");
                    }
                    if (variant == 1) {
                        System.out.println("\tYou bash your pack on a rock after tripping. Wasn't that where you keep your potions?");
                        player.addPotion(-1);
                    }
                    if (variant == 2) {
                        getRizzed();
                    }
                }
                break;
        }
    }
}