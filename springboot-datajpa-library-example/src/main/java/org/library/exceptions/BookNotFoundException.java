package org.library.exceptions;

public class BookNotFoundException extends RuntimeException{
	public BookNotFoundException() {
		super("Request book is not available... ");
	}
}
