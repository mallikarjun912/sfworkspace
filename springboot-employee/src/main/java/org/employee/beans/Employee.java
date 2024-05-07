package org.employee.beans;

public class Employee {
    private int empId;
    private String empName;
    private String job;
    private double salary;

    public Employee() {
    }

    public Employee(int empId, String empName, String job, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.job = job;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
