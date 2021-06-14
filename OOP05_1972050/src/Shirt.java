/**
 * @author agung 1972050
 */
public class Shirt extends Item {
    private Size size;
    public Shirt() {
    }

    public Shirt(String brand, String name, int price, Size size) {
        super(brand, name, price);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    public String toString(){
        return String.format("%-20s%-5s%-10s",getName(),getSize(),getPrice());
    }
}
