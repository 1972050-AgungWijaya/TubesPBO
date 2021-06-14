import java.text.ParseException;
import java.util.Scanner;
/**
 * @author agung 1972050
 */
public class CompanyDemo {
    public static void main(String[] args) throws ParseException {
        int pil;
        Scanner sc=new Scanner(System.in);
        Employee employee=new Employee();
        Company company=new Company();
        Owner owner=new Owner(company);
        System.out.print("Owner first name: ");
        owner.setFirstName(sc.next());
        System.out.print("Owner last name: ");
        owner.setLastName(sc.next());
        System.out.println("Welcome, "+owner.getFullName());
        do{
            System.out.println("=======================================");
            System.out.println("1. Add new employee");
            System.out.println("2. View all employee");
            System.out.println("3. Exit");
            System.out.print("Choice :");
            pil=sc.nextInt();
            if (pil==1) {
                owner.addEmployees(employee);
            }
            else if (pil==2){
                owner.viewAllEmployee();

            }
            else if (pil==3){}
            else{
                System.out.println("Wrong Menu");
            }
        }while(pil!=3);

    }
}
