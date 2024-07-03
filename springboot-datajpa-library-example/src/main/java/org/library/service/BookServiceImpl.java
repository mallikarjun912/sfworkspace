package org.library.service;

import java.util.List;
import java.util.Optional;

import org.library.entity.Book;
import org.library.exceptions.BookNotFoundException;
import org.library.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	@Autowired
	BookRepository repo;
	@Override
	public void addBook(Book book) {
		logger.info("** inside BookServiceImpl.addBook()"); 
		repo.save(book);		
		logger.info("** exit from BookServiceImpl.addBook()"); 
	}
	@Override
	public void update(Book book) {
				
	}
	@Override
	public void delete(int bookId) {
				
	}
	@Override
	public Book findBook(int bookId) {
		Optional<Book> optional = repo.findById(bookId); 
		if(optional.isEmpty())
			throw new BookNotFoundException();
		Book  book = optional.get();
		return book;
	}

	@Override
	public List<Book> searchForBook(String key) {
		List<Book> bookList = repo.searchForBooks(key);
		return bookList;
	}

	@Override
	public List<Book> findAllBooks() {
			return repo.findAll();
	}

}
