/**
 * @author agung 1972050
 */
import java.util.Scanner;

public class CinemaDemo {
    public static void main(String[] args) {
        int pil;
        Film film=new Film();
        Admin admin=new Admin(new Cinema());
        do{
            System.out.println("=======================================");
            System.out.println("1. Add new film");
            System.out.println("2. Show all film");
            System.out.println("3. Show longest film");
            System.out.println("4. Show shortest film");
            System.out.println("5. Exit");
            System.out.print("Choice :");
            Scanner sc=new Scanner(System.in);
            pil=sc.nextInt();
            if (pil==1) {
                admin.addFilm(film);
            }
            else if (pil==2){
                admin.viewAllFilm();
            }
            else if (pil==3){
                admin.viewLongestFilm();
            }
            else if (pil==4){
                admin.viewShortestFilm();
            }
            else if (pil==5){
            }
            else{
                System.out.println("Wrong menu");
            }
        }while(pil!=5);
    }
}
