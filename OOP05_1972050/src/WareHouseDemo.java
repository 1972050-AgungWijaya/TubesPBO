/**
 * @author agung 1972050
 */
import java.util.Scanner;

public class WareHouseDemo {
    public static void main(String[] args) {
        int pil;
        WareHouseManager wareHouse=new WareHouseManager(new WareHouse());
        Scanner scn=new Scanner(System.in);
        do{
            System.out.println("=======================================");
            System.out.println("1. Add Shoe");
            System.out.println("2. Add Shirt");
            System.out.println("3. View all item");
            System.out.println("0. Exit");
            System.out.print("Choice :");
            Scanner sc=new Scanner(System.in);
            pil=sc.nextInt();
            if (pil==1) {
                String x,y,z;
                int a,b;
                System.out.print("Brand: ");
                x=scn.nextLine();
                System.out.print("Name: ");
                y=scn.nextLine();
                System.out.print("Color: ");
                z=scn.nextLine();
                System.out.print("Size: ");
                a=sc.nextInt();
                System.out.print("Price: ");
                b=sc.nextInt();
                wareHouse.addItemToWareHouse(new Shoe(x,y,b,a,z));
            }
            else if (pil==2){
                String x,y,z;
                int b;
                System.out.print("Brand: ");
                x=scn.nextLine();
                System.out.print("Name: ");
                y=scn.nextLine();
                System.out.print("Size(XS, S, M, L, XL, XXL): ");
                z=scn.nextLine();

                System.out.print("Price: ");
                b=sc.nextInt();
                Size sizexs=Size.XS;
                Size sizes=Size.S;
                Size sizem=Size.M;
                Size sizel=Size.L;
                Size sizexl=Size.XL;
                Size sizexxl=Size.XXL;
                boolean ukuran=false;
                while (ukuran==false) {
                    if (z.equals(String.valueOf(sizexs))) {
                        wareHouse.addItemToWareHouse(new Shirt(x, y, b, sizexs));
                        ukuran=true;
                    } else if (z.equals(String.valueOf(sizes))) {
                        wareHouse.addItemToWareHouse(new Shirt(x, y, b, sizes));
                        ukuran=true;
                    } else if (z.equals(String.valueOf(sizem))) {
                        wareHouse.addItemToWareHouse(new Shirt(x, y, b, sizem));
                        ukuran=true;
                    } else if (z.equals(String.valueOf(sizel))) {
                        wareHouse.addItemToWareHouse(new Shirt(x, y, b, sizel));
                        ukuran=true;
                    } else if (z.equals(String.valueOf(sizexl))) {
                        wareHouse.addItemToWareHouse(new Shirt(x, y, b, sizexl));
                        ukuran=true;
                    } else if (z.equals(String.valueOf(sizexxl))) {
                        wareHouse.addItemToWareHouse(new Shirt(x, y, b, sizexxl));
                        ukuran=true;
                    } else {
                        System.out.println("Ukuran salah silahkan coba lagi");
                        System.out.print("Size(XS, S, M, L, XL, XXL): ");
                        z=scn.nextLine();
                    }
                }
            }
            else if (pil==3){
                wareHouse.viewItemInWareHouse();
            }
            else if (pil==0){
            }
            else{
                System.out.println("Wrong Menu");
            }
        }while(pil!=0);
    }
}
