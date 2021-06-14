import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author agung 1972050
 */
public class Employee extends Person{
    protected String id="";
    protected Date joinDate;
    public Employee() {

    }

    public Employee(String firstName, String lastName, String id, Date joinDate) {
        super(firstName, lastName);
        this.id = id;
        this.joinDate = joinDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDateDate(Date date) {
        this.joinDate = date;
    }
}
