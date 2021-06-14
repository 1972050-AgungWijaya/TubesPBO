/**
 * @author agung 1972050
 */
public class Panda {
    private String name;
    private int str,agi,energy;

    public Panda(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str += str;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi += agi;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy += energy;
    }
    public void training(Crane crane){
        crane.sparring(Panda.this);
    }
    public void training(Grasshopper grasshopper){
        grasshopper.sparring(Panda.this);
    }
    public void training(Tiger tiger) {
        tiger.sparring(Panda.this);
    }
    public void training(Turtle turtle) {
        turtle.sparring(Panda.this);
    }
    public void training(Snake snake) {
        snake.sparring(Panda.this);
    }
    public void training(Monkey monkey) {
        monkey.sparring(Panda.this);
    }
    public void showMyStats(){
        System.out.println("Strength: "+str);
        System.out.println("Agility: "+agi);
        System.out.println("Energy: "+energy);
    }
}
