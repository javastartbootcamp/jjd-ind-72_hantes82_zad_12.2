import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.*;

public class EmployeeSalariesProcesses {

    private String sourceFile;

    private String resultFile;

    public EmployeeSalariesProcesses(String sourceFile, String resultFile) {
        this.sourceFile = sourceFile;
        this.resultFile = resultFile;
    }

    private int countLines() {
        int size = 0;
        try (
                var file = new FileReader(sourceFile);
                var reader = new BufferedReader(file);
        ) {
            String newLine = null;
            int lineCounter = 0;

            while ((newLine = reader.readLine()) != null) {
                lineCounter++;
            }
            return lineCounter;
        } catch (IOException e) {
            System.err.println("Nie znaleziono pliku");
        }
        return 0;
    }

    private Employee[] readDataFile() {
        int size = countLines();
        Employee[] employees = new Employee[size];
        try (
            var file = new FileReader(sourceFile);
            var reader = new BufferedReader(file);
                ) {
            String newLine = null;
            for (int i = 0; i < size; i++) {
                newLine = reader.readLine();
                String[] split = newLine.split(";");
                employees[i] = new Employee(split[0], split[1], split[2], split[3], Double.parseDouble(split[4]));
            }

        } catch (IOException e) {
            System.err.println("Nie znaleziono pliku");
        }
        return employees;
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

    private String departmentsStats(Employee[] employees) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String department : Employee.DEPARTMENTS) {
            int employeeNumber = 0;
            for (Employee employee : employees) {

                if (department.equals(employee.getDepartment())) {
                    employeeNumber++;
                }
            }
            stringBuilder.append("Liczba pracowników " + department + ": " + employeeNumber + "\n");

        }
        return stringBuilder.toString();
    }

    private String companyStats(Employee[] employees) {
        return "Średnia wypłata: " + avgSalary(employees) + "\n" +
                "Minimalna wypłata: " + minSalary(employees) + "\n" +
                "Maksymalna wypłata: " + maxSalary(employees) + "\n" +
                departmentsStats(employees);
    }

    private void writeResultsToFile(String companyData) {
        try (
            var file = new FileWriter(resultFile);
            var writer = new BufferedWriter(file);
                ) {

            writer.write(companyData);
        } catch (IOException e) {
            System.err.println("Nie znaleziono pliku");
        }

    }

    public void employeeDataTransferToFile() {
        Employee[] employees = readDataFile();
        String contentToWrite = companyStats(employees);
        writeResultsToFile(contentToWrite);
    }
}
