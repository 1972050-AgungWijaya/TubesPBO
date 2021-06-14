/**
 * @author agung 1972050
 */
public abstract class TwoDimensionalShape {
    public abstract double getArea();
    public abstract double getCircumference();
    public void showDetail() {
        System.out.println(toString());
    }
}
