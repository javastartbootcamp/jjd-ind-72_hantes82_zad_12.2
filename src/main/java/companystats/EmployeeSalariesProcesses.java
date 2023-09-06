package companystats;

import java.io.*;

public class EmployeeSalariesProcesses {

    private static int countLines(String sourceFile) {
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
            System.err.println("Nie znaleziono pliku lub brak dostepu do pliku");
        }
        return 0;
    }

    public static Employee[] readDataFile(String sourceFile) {
        int size = countLines(sourceFile);
        if (size > 0) {
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
                System.err.println("Nie znaleziono pliku lub brak dostepu do pliku");
            }
            return employees;
        } else {
            return null;
        }
    }

    public static void writeResultsToFile(String companyStatistics, String resultFile) {
        try (
            var file = new FileWriter(resultFile);
            var writer = new BufferedWriter(file);
                ) {

            writer.write(companyStatistics);
        } catch (IOException e) {
            System.err.println("Nie znaleziono pliku");
        }

    }

}
