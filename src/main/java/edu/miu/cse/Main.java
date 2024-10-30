package edu.miu.cse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        printAllEmployees();
        printMonthlyUpcomingEnrollees();
    }

    private static void printAllEmployees() throws IOException {
        List<Employee> sortedEmployees = DataStore.getEmployees().stream()
                .sorted((e1, e2) -> {
                    int nameCompare = e1.getLastName().compareTo(e2.getLastName());
                    if (nameCompare == 0) {
                        return Double.compare(e2.getYearlySalary(), e1.getYearlySalary());
                    }
                    return nameCompare;
                })
                .collect(Collectors.toList());

        printAsJson(sortedEmployees, "All Employees");
    }

    private static void printMonthlyUpcomingEnrollees() throws IOException {
        LocalDate nextMonthStart = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        LocalDate nextMonthEnd = nextMonthStart.withDayOfMonth(nextMonthStart.lengthOfMonth());

        List<Employee> eligibleEmployees = DataStore.getEmployees().stream()
                .filter(e -> e.isEligibleForPension(nextMonthStart, nextMonthEnd))
                .sorted((e1, e2) -> e1.getEmploymentDate().compareTo(e2.getEmploymentDate()))
                .collect(Collectors.toList());

        printAsJson(eligibleEmployees, "Monthly Upcoming Enrollees");
    }

    private static void printAsJson(Object object, String title) throws IOException {
        System.out.println("\n" + title + ":");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());  // Register the JavaTimeModule for Java 8 date/time support
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jsonOutput = mapper.writeValueAsString(object);
        System.out.println(jsonOutput);
    }
}