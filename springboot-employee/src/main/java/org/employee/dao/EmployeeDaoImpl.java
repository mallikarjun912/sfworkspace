package org.employee.dao;

import java.util.List;

import org.employee.beans.Employee;
import org.employee.exceptions.EmployeeIdExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	@Autowired
	JdbcTemplate template;
	@Override
	public int addEmployee(Employee emp) {
		String add = "insert into employee values(?,?,?,?)";
		String checkId = "select count(*) from employee where empId=?";
		int count = template.queryForObject(checkId, Integer.class, emp.getEmpId());
		if(count>0)
			throw new EmployeeIdExistException();
		Object args[] = {emp.getEmpId(),emp.getEmpName(),emp.getJob(),emp.getSalary()};
		int rows = template.update(add, args);
		return rows;
	}
	@Override
	public List<Employee> getAllEmployees() {
		logger.info("** inside EmployeeDaoImpl getAllEmployees() ** ");
		String qry = "select * from employee";
		List<Employee> emplist = template.query(qry, new BeanPropertyRowMapper<Employee>(Employee.class));
		return emplist;
	}
	@Override
	public Employee getEmployeeById(int empId) {
		String qry2 = "select * from employee where empId=?";
		Employee emp = template.queryForObject(qry2, 
				new BeanPropertyRowMapper<Employee>(Employee.class), empId);
		return emp;
	}
	@Override
	public int updateEmployee(Employee emp) {
		String updateqry = "update employee set empName=?,job=?,salary=? where empId=?";
		Object args[] = {emp.getEmpName(),emp.getJob(),emp.getSalary(),emp.getEmpId()};
		int rows = template.update(updateqry, args);
		return rows;
	}
	@Override
	public int deleteEmployee(int id) {
		String delqry = "delete from employee where empId=?";
		int rows = template.update(delqry, id);
		return rows;
	}

}
