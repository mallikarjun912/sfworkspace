package org.employee.service;

import org.employee.beans.Employee;
import org.employee.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao dao;
	
    List<Employee> empList = new ArrayList<>();
    public EmployeeServiceImpl(){
        empList.add(new Employee(101,"arjun","trainer",5000));
        empList.add(new Employee(201,"rames","developer",6000));
        empList.add(new Employee(205,"johnson","tester",9000));
        empList.add(new Employee(301,"gavin","developer",15000));
    }
    @Override
    public String addEmployee(Employee employee) {
      //  empList.add(employee);
    	int rows = dao.addEmployee(employee);
    	if(rows>0)
    		return "employee object inserted";
    	else
    		return "not inserted";
    }

    @Override
    public List<Employee> findAllEmployees() {
        return dao.getAllEmployees();
    }

    @Override
    public Employee findById(int id) {
		/*
		 * Optional<Employee> employee = empList.stream().filter((e)->e.getEmpId()==id)
		 * .map((emp)->emp) .findAny(); Employee empl = employee.get();
		 */
    	
        return dao.getEmployeeById(id);
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
    	int rows = dao.updateEmployee(employee);
    	if(rows>0)
    		return "updated";
    	else
    		return "Not-updated";
    }

    @Override
    public String deleteEmployee(int empId) {
    	int rows = dao.deleteEmployee(empId);
    	if(rows>0)
    		return "deleted";
    	else
    		return "not-deleted";
    }
}
