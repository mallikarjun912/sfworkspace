package org.employee.exceptions;

public class EmployeeIdExistException extends RuntimeException{
		public EmployeeIdExistException() {
			super("Employee Id already exists.. try another ...");
		}
}
