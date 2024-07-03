package org.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LibraryExceptionHandler {
	
		@ExceptionHandler(value = BookNotFoundException.class)
		public ResponseEntity<String> bookNotFoundException(BookNotFoundException ex){
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
}
