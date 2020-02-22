package com.es.challenge.service.impl;

import com.es.challenge.dao.OrderDao;
import com.es.challenge.domain.*;
import com.es.challenge.service.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderManagementServiceImpl implements OrderManagementService {

	@Autowired
	private OrderDao orderDao;

	

	@Override
	public List<OrderEntity> getOrdersHistory() {
		List<OrderEntity> orders = this.orderDao.getOrdersHistory();

		return orders;
	}

	@Override
	public OrderEntity addOrder(int numOfItems) {

		OrderEntity orderEntity= new OrderEntity(numOfItems) ;
		return this.orderDao.addOrder(orderEntity);
	}
}
