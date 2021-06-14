/**
 * @author agung 1972050
 */
import java.util.ArrayList;

public class HRManager extends University{

    public void addEmployee(University university,Employee employee){
        university.getEmployees().add(employee);
    }
    public void viewAllEmployee(University university){
        ArrayList<Employee> univer = university.getEmployees();
        univer.forEach(Employee -> {
            if (Employee instanceof Employee ) {
                System.out.println(((Employee) Employee).toString());
            }
        });
    }
    public void viewAllLecturer(University university){
        ArrayList<Employee> univer = university.getEmployees();
        univer.forEach(Employee -> {
            if (Employee instanceof Lecturer ) {
                System.out.println(((Lecturer) Employee).toString());

            }
        });
    }
}
