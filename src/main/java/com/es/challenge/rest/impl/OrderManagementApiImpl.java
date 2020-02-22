package com.es.challenge.rest.impl;

import com.es.challenge.domain.Book;
import com.es.challenge.domain.Order;
import com.es.challenge.domain.OrderEntity;
import com.es.challenge.rest.BookManagementApi;
import com.es.challenge.rest.OrderManagementApi;
import com.es.challenge.service.OrderManagementService;
import com.es.challenge.service.ESAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
public class OrderManagementApiImpl implements OrderManagementApi {

	private com.es.challenge.service.OrderManagementService OrderManagementService;

	@Autowired
	public OrderManagementApiImpl(OrderManagementService OrderManagementService){
		this.OrderManagementService=OrderManagementService;
	}

	@Override
	public ResponseEntity getOrdersHistory() {
		List<OrderEntity> Orders = this.OrderManagementService.getOrdersHistory();
		return new ResponseEntity(Orders, HttpStatus.OK);
	}


	@Override
	public ResponseEntity addOrder(@RequestParam int numOfItems) {

			OrderEntity result = this.OrderManagementService.addOrder(numOfItems);
			return new ResponseEntity(result, HttpStatus.OK);

	}


}
