package com.es.challenge.service;

import com.es.challenge.domain.Book;
import com.es.challenge.domain.Order;
import com.es.challenge.domain.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderManagementService {
	public List<OrderEntity> getOrdersHistory();
	public OrderEntity addOrder(int numOfItems);
}
