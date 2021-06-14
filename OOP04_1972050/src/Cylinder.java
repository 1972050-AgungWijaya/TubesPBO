import java.text.DecimalFormat;
/**
 * @author agung 1972050
 */
public class Cylinder extends ThreeDimensionalShape{
    private double radius;
    private double height;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI*getRadius()*getRadius()*getHeight();
    }

    @Override
    public double getSurfaceArea() {
        return 2*Math.PI*getRadius()*getRadius()+2*Math.PI*getRadius()*getHeight();
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        String kalimat="Volume of Cylinder is: "+df.format((double)Math.round(getVolume()*100)/100)+"\r\n"+
                "Surface area of Cylinder is: "+df.format((double)Math.round(getSurfaceArea()*100)/100);
        return kalimat;
    }

}
