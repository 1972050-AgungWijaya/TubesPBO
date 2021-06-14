/**
 * @author agung 1972050
 */
import java.util.Random;

public class Sword extends Item implements Weapon {
    public Sword() {
        setName("Sword");
    }

    @Override
    public void attack(GameCharacter attacker, GameCharacter enemy) {
        if (((Monster) enemy).isFlyingUnit()){
            System.out.println("Enemy out of range");
            enemy.attackEnemy(attacker);
        }
        else{
            Random random=new Random();
            int critical=random.nextInt(2);
            int x=attacker.getCurentStrength()*getDamage()+(critical*3*getDamage());
            enemy.setCurentHealth(enemy.getCurentHealth()-x);
            System.out.println("Hero do "+x+" damage to monster");
            if (enemy.getCurentHealth()>0){
                enemy.attackEnemy(attacker);
            }
        }
    }
    @Override
    public int getDamage() {
        return 9;
    }
    public String toString(){
        return String.format("%-10s%-10s",getName(),getDamage());
    }
}
