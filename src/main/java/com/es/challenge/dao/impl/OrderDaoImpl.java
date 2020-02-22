package com.es.challenge.dao.impl;

import com.es.challenge.domain.OrderEntity;
import com.es.challenge.repository.OrderRepository;
import com.es.challenge.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private OrderRepository orderRepository;


	@Override
	public List<OrderEntity> getOrdersHistory() {
		return this.orderRepository.findAll();
	}

	@Override
	public OrderEntity addOrder(OrderEntity order) {
		this.orderRepository.save(order);
		return order;
	}
}
