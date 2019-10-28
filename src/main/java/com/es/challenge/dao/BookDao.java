package com.es.challenge.dao;

import com.es.challenge.domain.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
	List<BookEntity> getBooks();
	Boolean addBook(BookEntity Book);
	Boolean removeBook(Long BookId);

    List<BookEntity> getBooksByFoodIn(List<String> foods);
}
