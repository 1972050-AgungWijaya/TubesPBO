/**
 * @author agung 1972050
 */
public class Grasshopper {
    private String name;

    public Grasshopper(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void sparring(Panda panda){
        System.out.println(name+", get ready");
        panda.setAgi(9);
        panda.setEnergy(5);
    }
}
