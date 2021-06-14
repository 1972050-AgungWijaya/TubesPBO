/**
 * @author agung 1972050
 */
public class Crane {
    private String name;

    public Crane(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void sparring(Panda panda){
        System.out.println("Ok. Let’s begin the training");
        panda.setStr(3);
        panda.setEnergy(11);

    }
}
