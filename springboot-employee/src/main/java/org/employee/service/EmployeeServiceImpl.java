package org.employee.service;

import org.employee.beans.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> empList = new ArrayList<>();
    public EmployeeServiceImpl(){
        empList.add(new Employee(101,"arjun","trainer",5000));
        empList.add(new Employee(201,"rames","developer",6000));
        empList.add(new Employee(205,"johnson","tester",9000));
        empList.add(new Employee(301,"gavin","developer",15000));
    }
    @Override
    public String addEmployee(Employee employee) {
        empList.add(employee);
        return "employee object inserted";
    }

    @Override
    public List<Employee> findAllEmployees() {
        return empList;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public List<Employee> findBySalary(double salary) {
        return  empList.stream()
                .filter((emp)->emp.getSalary()>salary)
                .toList();
       // return empSalariesList;
    }

    @Override
    public String updateEmployee(Employee employee) {
        return "";
    }

    @Override
    public String deleteEmployee(int empId) {
        return "";
    }
}
