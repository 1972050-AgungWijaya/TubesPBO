/**
 * @author agung 1972050
 */
public class Shoe extends Item{
    private int size;
    private String color;

    public Shoe() {
    }

    public Shoe(String brand, String name, int price, int size, String color) {
        super(brand, name, price);
        this.size = size;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String toString(){
        return String.format("%-20s%-5s%-10s",getName(),getSize(),getPrice());
    }
}
