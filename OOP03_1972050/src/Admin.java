/**
 * @author agung 1972050
 */
import java.util.Scanner;

public class Admin {
    private Cinema cnm;
    public Admin(Cinema cinema) {
        this.cnm=cinema;
    }
    public void addFilm(Film film){
        Film[] x=cnm.getFilms();
        Scanner sc=new Scanner(System.in);
        if (cnm.getNumberOfStudio()>0) {
            System.out.print("Judul: ");
            String judul=sc.nextLine();
            System.out.print("Durasi: ");
            int dur=sc.nextInt();
            x[10 - cnm.getNumberOfStudio()] = new Film(judul,dur);
            cnm.setNumberofStudio();
        }
        else{
            System.out.println("Studio sudah penuh");
        }
    }
    public void viewAllFilm(){
        Film[] x=cnm.getFilms();
        if (x[0]==null){
            System.out.println("Belum tersedia list film");
        }
        else {
            String[][] table = new String[2][10];
            int [] mx=new int[2];
            int countTable=0;
            for (int i = 0; i < 10; i++) {
                if (x[i] != null) {
                    table[0][i] = x[i].getTitle();
                    table[1][i] = String.valueOf(x[i].getDuration());
                    countTable+=1;
                }
            }
            mx[0]=5;
            mx[1]=6;
            for (int i = 0; i < countTable; i++) {
                if (mx[0] < table[0][i].length()) {
                    mx[0] = table[0][i].length();
                }
                if (mx[1] < table[1][i].length()) {
                    mx[1] = table[1][i].length();
                }
            }
            System.out.print("Judul");
            for (int j=0;j<=mx[0]+10-5;j++){
                System.out.print(" ");
            }
            System.out.print("Durasi");
            for (int j=0;j<=mx[1]-6;j++){
                System.out.print(" ");
            }
            System.out.println();
            for (int i = 0; i < countTable; i++) {
                System.out.print(x[i].getTitle());
                for (int j=0;j<=(mx[0]+10)-table[0][i].length();j++){
                    System.out.print(" ");
                }
                System.out.print(x[i].getDuration());
                for (int j=0;j<=mx[1]-table[1][i].length();j++){
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    public void viewLongestFilm(){
        Film [] f=cnm.getLongestFilm();
        if (f==null){
            System.out.println("Belum ada film");
        }
        else {
            System.out.println("Longest film");
            System.out.print("Title: ");
            System.out.println(f[0].getTitle());
            System.out.print("Duration: ");
            System.out.println(f[0].getDuration());
        }

    }
    public void viewShortestFilm(){
        Film [] f=cnm.getShortestFilm();
        if (f==null){
            System.out.println("Belum ada film");
        }
        else {
            System.out.println("Shortest film");
            System.out.print("Title: ");
            System.out.println(f[0].getTitle());
            System.out.print("Duration: ");
            System.out.println(f[0].getDuration());
        }
    }
}
