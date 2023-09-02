import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String sourceFile = "employees.csv";
        String resultFileName = "stats.txt";

        EmployeeSalariesProcesses employeeSalaries = new EmployeeSalariesProcesses(sourceFile, resultFileName);
        employeeSalaries.employeeDataTransferToFile();
    }
}
