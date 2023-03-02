package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {

	@Autowired
	private OrdersDataService service;

	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}

	public List<OrderModel> getOrders() {
		List<OrderEntity> ordersEntity = service.findAll();

		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for (OrderEntity entity : ordersEntity) {
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(),
					entity.getPrice(), entity.getQuantity()));
		}
		return ordersDomain;
	}

	@PostConstruct
	public void init() {
		System.out.println("OrdersBusinessService.init called");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("OrdersBusinessService.destroy called");
	}
}
