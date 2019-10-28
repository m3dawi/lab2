package com.es.challenge.dao.impl;

import com.es.challenge.dao.BookDao;
import com.es.challenge.domain.BookEntity;
import com.es.challenge.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDaoImpl implements BookDao {

	@Autowired
	private BookRepository BookRepository;
	
	@Override
	public List<BookEntity> getBooks() {
		return this.BookRepository.findAll();
	}

	@Override
	public Boolean addBook(BookEntity Book) {
		this.BookRepository.save(Book);
		return true;
	}

	@Override
	public Boolean removeBook(Long BookId) {
		if (this.BookRepository.exists(BookId)) {
			this.BookRepository.delete(BookId);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<BookEntity> getBooksByFoodIn(List<String> foods) {
		return this.BookRepository.findByFood_NameIn(foods);
	}
}
