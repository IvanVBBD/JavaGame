package game;
import java.util.Random;
public class CombatEvent extends Event {
    @Override
    public Enemy getEnemy() {
        return enemy;
    }
    private Enemy enemy;
    public CombatEvent(String pv, Enemy enemy) {
        super(pv);
        this.enemy = enemy;

    }
}