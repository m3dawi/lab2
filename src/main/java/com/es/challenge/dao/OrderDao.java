package com.es.challenge.dao;

import com.es.challenge.domain.BookEntity;
import com.es.challenge.domain.Order;
import com.es.challenge.domain.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
	List<OrderEntity> getOrdersHistory();
	OrderEntity addOrder(OrderEntity order);

}
