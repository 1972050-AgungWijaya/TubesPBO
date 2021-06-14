/**
 * @author agung 1972050
 */
import java.util.Scanner;
import java.util.Random;
public class PandaStory {
    public static void main(String[] args) {
        Random random=new Random();
        Scanner sc=new Scanner(System.in);
        String name="Po";
        System.out.print("Input days for"+name+"to train: ");
        int durasi=sc.nextInt();
        int i=1;
        Panda panda=new Panda(name);
        while (i <= durasi){
            System.out.println("Day "+i);
            System.out.println("1. Training with Tigress");
            System.out.println("2. Training with Mantis");
            System.out.println("3. Training with Viper");
            System.out.println("4. Training with Monkey");
            System.out.println("5. Training with Crane");
            System.out.print("Choose wisely: ");
            int pil=sc.nextInt();
            if (pil==1){
                panda.training(new Tiger(name));
                i+=1;
            }
            else if (pil==2){
                panda.training(new Grasshopper(name));
                i+=1;
            }
            else if (pil==3){
                panda.training(new Snake(name));
                i+=1;
            }
            else if (pil==4){
                panda.training(new Monkey(name));
                i+=1;
            }
            else if (pil==5){
                panda.training(new Crane(name));
                i+=1;
            }
            else{
                System.out.print("Pilihan salah silahkan masukan lagi: ");
                pil=sc.nextInt();
            }
            int x=random.nextInt(9);
            if (x==5){
                panda.training(new Turtle(name));
            }
        }
        panda.showMyStats();
    }
}
