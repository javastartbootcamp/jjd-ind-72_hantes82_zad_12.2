
public class Main {

    public static void main(String[] args) {

        String sourceFile = "employees.csv";
        String resultFileName = "stats.txt";

        Employee[] employees = EmployeeSalariesProcesses.readDataFile(sourceFile);
        CompanyStats companyStats = new CompanyStats(employees);
        EmployeeSalariesProcesses.writeResultsToFile(companyStats.toString(), resultFileName);
        EmployeeSalariesProcesses.writeResultsToFile(companyStats.fullStatistics(employees), resultFileName);
    }
}
