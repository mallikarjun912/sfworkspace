package org.library.repository;

import java.util.List;

import org.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{ 
	    @Query(value = "select book from Book book where book.title like %?1%")
		List<Book> searchForBooks(String str);
}
