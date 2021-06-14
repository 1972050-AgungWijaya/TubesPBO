/**
 * @author agung 1972050
 */
public interface Weapon {
    void attack(GameCharacter attacker, GameCharacter enemy);
    int getDamage();
}
