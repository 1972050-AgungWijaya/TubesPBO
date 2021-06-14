import java.text.DecimalFormat;
/**
 * @author agung 1972050
 */
public class Square extends TwoDimensionalShape{
    private double lengthOfSide;

    public double getLengthOfSide() {
        return lengthOfSide;
    }

    public void setLengthOfSide(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    @Override
    public double getArea() {
        return getLengthOfSide()*getLengthOfSide();
    }

    @Override
    public double getCircumference() {
        return getLengthOfSide()*4;
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        String kalimat="Area of Square is: "+df.format((double)Math.round(getArea()*100)/100)+"\r\n"+
                "Circumference of Square is: "+df.format((double)Math.round(getCircumference()*100)/100);
        return kalimat;
    }

}
