/**
 * @author agung 1972050
 */
import java.util.Scanner;

public class UniversityDemo {
    public static void main(String[] args) {
        String nidn,nik,n1,n2;
        Scanner scn=new Scanner(System.in);
        University university=new HRManager();
        System.out.print("HR Manager Nik: ");
        nik=scn.next();
        System.out.print("HR Manager first name: ");
        n1=scn.next();
        System.out.print("HR Manager last name: ");
        n2=scn.next();
        Employee employee=new Employee(n1,n2,nik);
        ((HRManager)university).addEmployee(university,employee);
        int pil,cek=0;
        do{
            System.out.println("=======================================");
            System.out.println("1. Add new Employee");
            System.out.println("2. Add new Lecturer");
            System.out.println("3. View all employee");
            System.out.println("4. View all lecturer");
            System.out.println("5. exit");
            System.out.print("Choice :");
            Scanner sc=new Scanner(System.in);
            pil=sc.nextInt();
            if (pil==1) {
                System.out.print("NIK: ");
                nik=sc.next();
                System.out.print("First Name: ");
                n1=sc.next();
                System.out.print("Last Name: ");
                n2=sc.next();
                ((HRManager)university).addEmployee(university,new Employee(n1,n2,nik));
            }
            else if (pil==2){
                System.out.print("NIK: ");
                nik=sc.next();
                System.out.print("NIDN: ");
                nidn=sc.next();
                System.out.print("First Name: ");
                n1=sc.next();
                System.out.print("Last Name: ");
                n2=sc.next();
                (((HRManager)university)).addEmployee(university,new Lecturer(n1,n2,nik,nidn));
                cek+=1;
            }
            else if (pil==3){
                System.out.printf("%-10s%-10s","NIK","Nama");
                System.out.println();
                ((HRManager)university).viewAllEmployee(university);
            }
            else if (pil==4){
                if (cek>0) {
                    ((HRManager) university).viewAllLecturer(university);
                }
                else{
                    System.out.println("No data");
                }
            }
            else if (pil==5){
            }
            else{
                System.out.println("Wrong Menu");
            }
        }while(pil!=5);
    }
}
