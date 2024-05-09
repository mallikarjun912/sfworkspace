package org.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
		@ExceptionHandler(value = EmployeeIdExistException.class)
		public ResponseEntity<String> employeeIdExists(EmployeeIdExistException ex){
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.FOUND);
		}
}
