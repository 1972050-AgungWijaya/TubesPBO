/**
 * @author agung 1972050
 */
public class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void sparring(Panda panda){
        System.out.println("So "+name+". Let’s get started");
        panda.setAgi(9);
        panda.setStr(5);
    }
}
