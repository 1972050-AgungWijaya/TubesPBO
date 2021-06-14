import java.util.Scanner;
/**
 * @author agung 1972050
 */
public class ShapeDemo {
    public static void main(String[] args) {
        int pil;
        double x,y;
        ThreeDimensionalShape tdc=new Cylinder();
        ThreeDimensionalShape tds=new Sphere();
        TwoDimensionalShape ddr=new Rectangle();
        TwoDimensionalShape dds=new Square();
        do{
            System.out.println("=======================================");
            System.out.println("1. Square");
            System.out.println("2. Rectangle");
            System.out.println("3. Sphere");
            System.out.println("4. Cylinder");
            System.out.println("5. Exit");
            System.out.print("Choice :");
            Scanner sc=new Scanner(System.in);
            pil=sc.nextInt();
            if (pil==1) {
                System.out.print("Length of side: ");
                x=sc.nextDouble();
                if (x<=0){
                    System.out.println("Length of side harus > 0");
                }
                else {
                    ((Square) dds).setLengthOfSide(x);
                    dds.showDetail();
                }

            }
            else if (pil==2){
                System.out.print("Width: ");
                x=sc.nextDouble();
                System.out.print("Height: ");
                y=sc.nextDouble();
                if (x<=0||y<=0){
                    System.out.println("Width atau Height harus > 0");
                }
                else {
                    ((Rectangle) ddr).setBase(x);
                    ((Rectangle) ddr).setHeight(y);
                    ddr.showDetail();
                }
            }
            else if (pil==2){
                System.out.print("Width: ");
                x=sc.nextDouble();
                System.out.print("Height: ");
                y=sc.nextDouble();
                ((Rectangle)ddr).setBase(x);
                ((Rectangle)ddr).setHeight(y);
                ddr.showDetail();
            }
            else if (pil==3){
                System.out.print("Radius: ");
                x=sc.nextDouble();
                if (x<=0){
                    System.out.println("Radius harus > 0");
                }
                else {
                    ((Sphere) tds).setRadius(x);
                    tds.showDetail();
                }
            }
            else if (pil==4){
                System.out.print("Radius: ");
                x=sc.nextDouble();
                System.out.print("Height: ");
                y=sc.nextDouble();
                if (x<=0||y<=0){
                    System.out.println("Radius atau Height harus > 0");
                }
                else {
                    ((Cylinder) tdc).setRadius(x);
                    ((Cylinder) tdc).setHeight(y);
                    tdc.showDetail();
                }
            }
            else if (pil==5){
                System.out.println("Selesai");
            }
            else{
                System.out.println("Wrong menu");
            }
        }while(pil!=5);
    }
}
