package com.techelevator;

public class Employee {

    private String firstName;
    private String lastName;
    private double annualSalary;
    private int employeeId;
    private String department;


public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
    this.firstName = firstName;
    this.employeeId= employeeId;
    this.lastName = lastName;
    this.annualSalary = annualSalary;
}

    public int getEmployeeId() {
        return employeeId;
    }
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return lastName + ", " + firstName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

public void raiseSalary(double percent){
 annualSalary += annualSalary * (percent/100);

}
}