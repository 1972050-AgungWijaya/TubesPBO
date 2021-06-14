/**
 * @author agung 1972050
 */
public class Tiger {
    private String name;

    public Tiger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void sparring(Panda panda){
        System.out.println("So you are ready to feel the pain.");
        panda.setStr(5);
        panda.setAgi(9);

    }
}
