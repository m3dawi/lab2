package com.es.challenge.rest.impl;

import com.es.challenge.domain.Book;
import com.es.challenge.rest.BookManagementApi;
import com.es.challenge.service.BookManagementService;
import com.es.challenge.service.ESAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Component
public class BookManagementApiImpl implements BookManagementApi {

	private com.es.challenge.service.BookManagementService BookManagementService;
	private ESAuthService esAuthService;

	@Autowired
	public BookManagementApiImpl(BookManagementService bookManagementService,ESAuthService esAuthService){
		this.BookManagementService=bookManagementService;
		this.esAuthService=esAuthService;
	}

	@Override
	public ResponseEntity getBooks() {
		List<Book> Books = this.BookManagementService.getBooks();
		return new ResponseEntity(Books, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getBooksByFood(@RequestBody List<String> foods) {
		List<Book> Books = this.BookManagementService.getBooksByFood(foods);
		return new ResponseEntity(Books, HttpStatus.OK);
	}


	@Override
	public ResponseEntity addBook(@RequestHeader(name="Consumer-Key", required=true) String key, @RequestBody Book Book) {
		if (this.esAuthService.isAdmin(key)) {
			Boolean result = this.BookManagementService.addBook(Book);
			return new ResponseEntity(result, HttpStatus.OK);
		}
		else {
			return new ResponseEntity("Invalid Consmer Key", HttpStatus.UNAUTHORIZED);
		}
	}

	@Override
	public ResponseEntity removeBook(@RequestHeader(name="Consumer-Key", required=false) String key, @PathVariable("id") Long BookId) {
		if (this.esAuthService.isAdmin(key)) {
			Boolean result = this.BookManagementService.removeBook(BookId);
			return new ResponseEntity(result, (result) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity("Invalid Consmer Key", HttpStatus.UNAUTHORIZED);
		}
	}
}
