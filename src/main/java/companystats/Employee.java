package companystats;

public class Employee {
    private String firstName;
    private String lastName;
    private String pesel;
    private String department;
    private double salary;
    public static final String[] DEPARTMENTS = {"IT", "Management", "Support"};

    public Employee(String firstName, String lastName, String pesel, String department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.department = validateDepartment(department);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "companystats.Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    private String validateDepartment(String departmentToCheck) {
        for (String dep : DEPARTMENTS) {
            if (departmentToCheck.equals(dep)) {
                return dep;
            }
        }
        throw new IllegalArgumentException("Invalid department");
    }
}
