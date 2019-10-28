package com.es.challenge.service;

import com.es.challenge.domain.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodManagementService {
	public List<Food> getFoods();
	public List<Food> getFoods(Integer caloriesMin, Integer caloriesMax);
	public Boolean addFood(Food food);
	public Boolean removeFood(Long foodId);
}
