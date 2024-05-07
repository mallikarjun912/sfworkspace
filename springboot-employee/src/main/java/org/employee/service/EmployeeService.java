package org.employee.service;

import org.employee.beans.Employee;

import java.util.List;

public interface EmployeeService {
    String addEmployee(Employee employee);
    List<Employee> findAllEmployees();
    Employee findById(int id);
    List<Employee> findBySalary(double salary);
    String updateEmployee(Employee employee);
    String deleteEmployee(int empId);
}
