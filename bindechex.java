import java.util.Scanner;
//Agung Wijaya Al Halim 1972050
public class bindechex {
    static String convertBin(int dec) {
        String x=(Integer.toBinaryString(dec));
        return x;
    }
    static String convertOct(int dec) {
        String x=(Integer.toOctalString(dec));
        return x;
    }
    static String convertHex(int dec) {
        String x=(Integer.toHexString(dec));
        return x;
    }

    public static void main(String[] args) {
        int pil, num;
        do {
            System.out.println("===============");
            System.out.println("Number converter");
            System.out.println("===============");
            System.out.println("1. Decimal to Binary");
            System.out.println("2. Decimal to Octal");
            System.out.println("3. Decimal to Hex");
            System.out.println("0. Exit");
            System.out.print("Choice :");
            Scanner scan = new Scanner(System.in);
            pil = scan.nextInt();
            if (pil == 1) {
                System.out.print("Input Number to convert :");
                num = scan.nextInt();
                System.out.println("Result :"+convertBin(num));
            }
            else if (pil == 2) {
                System.out.print("Input Number to convert :");
                num = scan.nextInt();
                System.out.println("Result :"+convertOct(num));
            }
            else if (pil == 3) {
                System.out.print("Input Number to convert :");
                num = scan.nextInt();
                System.out.println("Result :"+convertHex(num));
            }

        } while (pil != 0);
    }
}
