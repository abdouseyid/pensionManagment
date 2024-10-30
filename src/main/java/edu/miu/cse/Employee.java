package edu.miu.cse;

import java.time.LocalDate;

public class Employee {

    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private Double yearlySalary;
    private PensionPlan pensionPlan;

    public Employee() {}
    public Employee(long employeeId) {
        this.employeeId = employeeId;
    }
    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, Double yearlySalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;
    }
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public LocalDate getEmploymentDate() {
        return employmentDate;
    }
    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }
    public Double getYearlySalary() {
        return yearlySalary;
    }
    public void setYearlySalary(Double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public boolean isEligibleForPension(LocalDate nextMonthStart, LocalDate nextMonthEnd) {
        LocalDate eligibilityDate = employmentDate.plusYears(5);
        return pensionPlan == null && !eligibilityDate.isAfter(nextMonthEnd) && !eligibilityDate.isBefore(nextMonthStart);
    }
}
