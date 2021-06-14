import java.text.DecimalFormat;
/**
 * @author agung 1972050
 */
public class Sphere extends ThreeDimensionalShape{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return Math.PI*(getRadius()*getRadius()*getRadius())*4/3;
    }

    @Override
    public double getSurfaceArea() {
        return  4*Math.PI*(getRadius()*getRadius());
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        String kalimat="Volume of Sphere is: "+df.format((double)Math.round(getVolume()*100)/100)+"\r\n"+
                "Surface area of Sphere is: "+df.format((double)Math.round(getSurfaceArea()*100)/100);
        return kalimat;
    }

}
