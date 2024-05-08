package org.employee.dao;

import java.util.List;

import org.employee.beans.Employee;

public interface EmployeeDao {
	int addEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int empId);
	int updateEmployee(Employee employee);
	int deleteEmployee(int id);
}
