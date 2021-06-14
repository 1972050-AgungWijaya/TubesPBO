/**
 * @author agung 1972050
 */
import java.util.ArrayList;

public class University{
    private ArrayList<Employee> employees;
    public University() {
        employees=new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public String getNextEmployeeId(){
        if(employees.isEmpty()){
            return "E-00000001";
        }
        else{
            return "E-0000000"+Integer.toString(employees.size()+1);
        }
    }
}
