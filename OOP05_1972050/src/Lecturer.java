/**
 * @author agung 1972050
 */
public class Lecturer extends Employee{
    protected String nidn;

    public Lecturer() {

    }
    public Lecturer(String firstName, String lastName, String nik, String nidn) {
        super(firstName, lastName, nik);
        this.nidn = nidn;
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }
    public String toString(){
        return String.format("%-10s%-15s%-10s",getNik(),getNidn(),getFullName());
    }

}
