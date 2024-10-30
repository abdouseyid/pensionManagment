package edu.miu.cse;

import java.time.LocalDate;
import java.util.*;

public class DataStore {
    private static List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(1, "Daniel", "Agar", LocalDate.parse("2018-01-17"), 105945.50, new PensionPlan("EX1089", LocalDate.parse("2023-01-17"), 100.00)),
            new Employee(2, "Benard", "Shaw", LocalDate.parse("2019-04-03"), 197750.00, null),
            new Employee(3, "Carly", "Agar", LocalDate.parse("2014-05-16"), 842000.75, new PensionPlan("SM2307", LocalDate.parse("2019-11-04"), 1555.50)),
            new Employee(4, "Wesley", "Schneider", LocalDate.parse("2019-11-02"), 74500.00, null)
    ));

    public static List<Employee> getEmployees() {
        return employees;
    }
}
