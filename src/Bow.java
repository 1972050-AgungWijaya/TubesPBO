/**
 * @author agung 1972050
 */
import java.util.Random;

public class Bow extends Item implements Weapon{
    private int numberOfArrow;
    public Bow() {
        setName("Bow");
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }

    public void setNumberOfArrow(int numberOfArrow) {
        this.numberOfArrow = numberOfArrow;
    }

    @Override
    public void attack(GameCharacter attacker, GameCharacter enemy) {
        Random random=new Random();
        int arahAngin=random.nextInt(2);
        int x=getDamage()*getDamage()*(arahAngin+1)+getDamage();
        enemy.setCurentHealth(enemy.getCurentHealth()-x);
        System.out.println("Hero do "+x+" damage to monster");
        if (enemy.getCurentHealth()>0){
            enemy.attackEnemy(attacker);
        }
    }

    @Override
    public int getDamage() {
        return 5;
    }
    public String toString(){
        return String.format("%-10s%-10s",getName(),getDamage());
    }
}
