public class CompanyStats {
    double avgSalary;
    double minSalary;
    double maxSalary;

    public CompanyStats(Employee[] employees) {
        this.avgSalary = avgSalary(employees);
        this.minSalary = minSalary(employees);
        this.maxSalary = maxSalary(employees);
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    private double avgSalary(Employee[] employees) {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.length;
    }

    private double minSalary(Employee[] employees) {
        double minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    private double maxSalary(Employee[] employees) {
        double maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    public String departmentsStats(Employee[] employees) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String department : Employee.DEPARTMENTS) {
            int employeeNumber = getEmployeesByDepartment(department, employees);
            stringBuilder.append("Liczba pracowników " + department + ": " + employeeNumber + "\n");

        }
        return stringBuilder.toString();
    }

    private int getEmployeesByDepartment(String department, Employee[] employees) {
        int employeeNumber = 0;
        for (Employee employee : employees) {
            if (department.equals(employee.getDepartment())) {
                employeeNumber++;
            }
        }
        return employeeNumber;
    }

    public String fullStatistics(Employee[] employees) {
        return toString() + departmentsStats(employees);
    }

    @Override
    public String toString() {
        return "Średnia wypłata: " + avgSalary + "\n" +
                "Minimalna wypłata: " + minSalary + "\n" +
                "Maksymalna wypłata: " + maxSalary + "\n";
    }

}
