import java.text.ParseException;
/**
 * @author agung 1972050
 */
import java.util.Scanner;

public class TimeConverterDemo {
    public static void main(String[] args) throws ParseException {
        int pil;
        TimeConverter tc = new TimeConverter(0);
        Scanner scan = new Scanner(System.in);
        System.out.println("===================");
        System.out.println("Time Converter APP");
        System.out.println("===================");
        do {
            System.out.print("Input time (second, 0 untuk keluar) : ");
            pil = scan.nextInt();
            if(pil!=0) {
                tc.setSecond(pil);
                System.out.println("Converted Time : " + tc.showTime());
            }
        }
        while (pil != 0);
    }
}
