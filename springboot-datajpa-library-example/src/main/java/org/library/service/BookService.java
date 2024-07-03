package org.library.service;

import java.util.List;
import org.library.entity.Book;

public interface BookService {
	void addBook(Book book);
	void update(Book book);
	void delete(int bookId);
	Book findBook(int bookId);
	List<Book> searchForBook(String key);
	List<Book> findAllBooks();
}
