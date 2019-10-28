package com.es.challenge.service.impl;

import com.es.challenge.dao.BookDao;
import com.es.challenge.dao.FoodDao;
import com.es.challenge.domain.Book;
import com.es.challenge.domain.BookEntity;
import com.es.challenge.domain.Food;
import com.es.challenge.domain.FoodEntity;
import com.es.challenge.service.BookManagementService;
import com.es.challenge.util.CalorieTrackingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class BookManagementServiceImpl implements BookManagementService {

	@Autowired
	private BookDao BookDao;
	@Autowired
	private FoodDao foodDao;

	@Autowired
	private CalorieTrackingUtils calorieTrackingUtils;
	
	@Override
	public Boolean addBook(Book Book) {
		List<String> foods= Book.getFood();
		BookEntity bookEntity=this.calorieTrackingUtils.map(Book, BookEntity.class);
		List<FoodEntity> foodList=this.foodDao.getFoodByName(foods);
		bookEntity.setFood(foodList);
		return this.BookDao.addBook(bookEntity);
	}

	@Override
	public Boolean removeBook(Long BookId) {
		return this.BookDao.removeBook(BookId);
	}
	
	@Override
	public List<Book> getBooks() {
		List<BookEntity> Books = this.BookDao.getBooks();
		
		return calorieTrackingUtils.mapList(Books, Book.class);
	}


	@Override
	public List<Book> getBooksByFood(List<String> foods) {
		List<BookEntity> Books = this.BookDao.getBooksByFoodIn(foods);

		return calorieTrackingUtils.mapList(Books, Book.class);
	}
}
