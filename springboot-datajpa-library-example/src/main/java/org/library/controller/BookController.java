package org.library.controller;

import java.util.List;

import org.library.entity.Book;
import org.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	BookService service;
	
	@PostMapping
	public ResponseEntity<String> addBook(@RequestBody Book book){
		logger.info("** inside BookController.addBook() ");
		service.addBook(book);
		logger.info("** exiting from BookController.addBook() ");
		return new ResponseEntity<String>("book added successfully",HttpStatus.OK); 
	}
	
	@GetMapping
	public ResponseEntity<List<Book>>  findAllBooks(){
		logger.info("** inside BookController.findAllBooks() ");
		List<Book> booksList = service.findAllBooks();
		logger.info("** exiting from BookController.findAllBooks() ");
		return new ResponseEntity<List<Book>>(booksList,HttpStatus.OK);
	}
	
	@GetMapping("/{bookid}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookid){
		Book book = service.findBook(bookid); 
		 return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	@GetMapping("/search/{key}")
	public ResponseEntity<List<Book>> searchForBooks(@PathVariable String key){
		List<Book> bookList = service.searchForBook(key);
		return new ResponseEntity<List<Book>>(bookList,HttpStatus.OK);
	}
	
}
