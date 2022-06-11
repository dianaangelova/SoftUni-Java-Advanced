package C6_DefiningClasses.Exercise02_CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        ArrayList<Department> departmentArrayList = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = null;
            if (tokens.length == 4) {
                //no email
                //no age
                 employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    String email = tokens[4];
                     employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(tokens[4]);
                     employee = new Employee(name, salary, position, department, age);

                }
            } else {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                 employee = new Employee(name, salary, position, department, email, age);
            }

            boolean departmentExists;
            departmentExists = departmentArrayList.stream().filter(dep -> dep.getName().equals(department)).count() >= 1;
            if(!departmentExists){
                departmentArrayList.add(new Department(department));
            }
            Department currentDepartment;
            currentDepartment = departmentArrayList.stream().filter(dep -> dep.getName().equals(department)).findFirst().get();
            currentDepartment.getEmployeeList().add(employee);
        }
            Department highestPaidDepartment = departmentArrayList.stream()
                    .max(Comparator.comparingDouble(department -> department.calculateAverageSalary()))
                    .get();
            System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

            highestPaidDepartment.getEmployeeList().stream()
                    .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                    .forEach(System.out::println);

    }
}
