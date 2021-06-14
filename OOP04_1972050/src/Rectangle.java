import java.text.DecimalFormat;
/**
 * @author agung 1972050
 */
public class Rectangle extends TwoDimensionalShape{
    private double base;
    private double height;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return getBase()*getHeight();
    }

    @Override
    public double getCircumference() {
        return height*2+base*2;
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        String kalimat="Area of Rectangle is: "+df.format((double)Math.round(getArea()*100)/100)+"\r\n"+
                "Circumference of Rectangle is: "+df.format((double)Math.round(getCircumference()*100)/100);
        return kalimat;
    }

}
