/**
 * @author agung 1972050
 */
public class Snake {
    private String name;

    public Snake(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void sparring(Panda panda){
        System.out.println("Ok "+name+". Are you ready?");
        panda.setStr(8);
        panda.setEnergy(6);
    }
}
