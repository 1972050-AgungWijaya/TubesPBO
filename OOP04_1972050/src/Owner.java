import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
/**
 * @author agung 1972050
 */
public class Owner extends Person{
    protected Company cmp;
    public Owner(Company company) {
        cmp=company;
    }
    public void addEmployees(Employee employee) throws ParseException {
        cmp.employees=Arrays.copyOf(cmp.employees,cmp.employees.length+1);
        Scanner sc=new Scanner(System.in);
        System.out.print("Employee first name: ");
        employee.setFirstName(sc.next());
        System.out.print("Employee last name: ");
        employee.setLastName(sc.next());
        System.out.print("Join date(yyyy-mm-dd): ");
        String tgl=sc.next();
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(tgl);
        employee.setJoinDateDate(date);
        employee.setId(cmp.getNextEmployeeId());
        cmp.employees[cmp.employees.length-1]=new Employee(employee.getFirstName(),employee.getLastName(), employee.getId(),employee.getJoinDate());

    }
    public void viewAllEmployee(){
        Employee[] isi=cmp.getEmployees();
        if (isi.length==0){
            System.out.println("No Data");
        }
        else {
            int mx=4;
            for (int i = 0; i < isi.length; i++) {
                if (mx<isi[i].getFullName().length()){
                    mx=isi[i].getFullName().length();
                }
            }
            System.out.print("ID");
            for (int j=0;j<=9;j++){
                System.out.print(" ");
            }
            System.out.print("NAME");
            for (int j=0;j<=mx+6;j++){
                System.out.print(" ");
            }
            System.out.print("JOIN DATE");
            System.out.println();
            for (int i = 0; i < isi.length; i++) {
                System.out.print(isi[i].getId());
                for (int j=0;j<=11-10;j++){
                    System.out.print(" ");
                }
                System.out.print(isi[i].getFullName());
                for (int j=0;j<=mx+10-isi[i].getFullName().length();j++){
                    System.out.print(" ");
                }
                System.out.print(isi[i].getJoinDate());
                System.out.println();
            }
        }
    }

}
