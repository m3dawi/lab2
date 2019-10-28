package com.es.challenge.service;

import com.es.challenge.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookManagementService {
	public List<Book> getBooks();
	public Boolean addBook(Book Book);
	public Boolean removeBook(Long BookId);
	public List<Book> getBooksByFood(List<String> foods) ;
}
