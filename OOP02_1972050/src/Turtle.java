/**
 * @author agung 1972050
 */
public class Turtle {
    private String name;

    public Turtle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sparring(Panda panda){
        System.out.println("Come "+name+". I will show you the dragon scroll");
        panda.setAgi(8);
        panda.setStr(8);
        panda.setEnergy(8);
    }
}
