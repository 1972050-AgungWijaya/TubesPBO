/**
 * @author agung 1972050
 */
public abstract class ThreeDimensionalShape {
    public abstract double getVolume();
    public abstract double getSurfaceArea();
    public void showDetail(){
        System.out.println(toString());
    }
}
