package sorting.ue.employees;

import java.util.Arrays;

public class EmployeeDemoApp {

    public static void main(String[] args) {

        Employee luki = new Employee(111, "Aeisinger", 10000, "IT");
        Employee geri = new Employee(1, "Dreisinger", 100000, "Chef");
        Employee kerstin = new Employee(545, "Knab", 40, "Edu");
        Employee luki1 = new Employee(2, "Zweisinger", 10000, "IT");
        Employee luki2 = new Employee(11111, "Viersinger", 10000, "Dev");
        Employee luki3 = new Employee(11, "Funfinger", 10000, "HR");
        Employee luki4 = new Employee(11, "Sechsinger", 10000, "RH");


        Employee[] employees = {luki, geri, kerstin, luki1, luki2, luki3, luki4};
// Array for Sortierung
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

        Arrays.sort(employees);

        System.out.println("----------------Jetzt wurde das Array sortiert mit Comparable interface ohne eigene Klasse --------------------");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }

        Arrays.sort(employees, new NameAscComparator());

        System.out.println("----------------Jetzt wurde das Array sortiert mit NameAscComparator(), also müsste dem Namen nach aufsteigend sein --------------------");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }

        Arrays.sort(employees, new SalaryDescComparator());

        System.out.println("----------------Jetzt wurde das Array sortiert mit SalaryDescComparator(), also müsste das höchste Salary am Anfang sein --------------------");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }

        Arrays.sort(employees, new DepartmentAscNameDescComparator());

        System.out.println("----------------Jetzt wurde das Array sortiert mit DepartmentAscNameDescComparator(), also müsste es grundsätzlich aufsteigend nach Dept und wenn 2 Depts" +
                "gleich sind, Absteigend nach EmpName sein--------------------");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }

        Arrays.sort(employees, new SalaryAscNameAscComparator());

        System.out.println("----------------Jetzt wurde das Array sortiert mit SalaryAscNameAscComparator(), " +
                "also müsste es grundsätzlich aufsteigend nach Salary und wenn 2 Salarys" +
                "gleich sind, Aufsteigend nach Name sein--------------------");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }


    }
}