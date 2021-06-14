/**
 * @author agung 1972050
 */
public abstract class GameCharacter {
    private int maxHealth;
    private int curentHealth;
    private int baseStregth;
    private int curentStrength;

    public GameCharacter() {
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurentHealth() {
        return curentHealth;
    }

    public void setCurentHealth(int curentHealth) {
        this.curentHealth = curentHealth;
    }

    public int getBaseStregth() {
        return baseStregth;
    }

    public void setBaseStregth(int baseStregth) {
        this.baseStregth = baseStregth;
    }

    public int getCurentStrength() {
        return curentStrength;
    }

    public void setCurentStrength(int curentStrength) {
        this.curentStrength = curentStrength;
    }
    public abstract void attackEnemy(GameCharacter gameCharacter);
    public String getStatus(){
        return String.format("%-1s%-1s%-5s%-1s%-1s%-1s",getCurentHealth(),"/",getMaxHealth(),getCurentStrength(),"/",getBaseStregth());
    }
}
