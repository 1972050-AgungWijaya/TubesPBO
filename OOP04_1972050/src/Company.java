/**
 * @author agung 1972050
 */
public class Company extends Employee{
    protected Employee[] employees;
    public Company() {
        if (employees==null) {
            employees = new Employee[0];
        }
    }

    public Employee[] getEmployees() {
        return employees;
    }
    public String getNextEmployeeId(){
        if (employees.length==0){
            return "E-00000001";
            }
        else{
            return "E-0000000"+Integer.toString(employees.length);
        }
    }

}
