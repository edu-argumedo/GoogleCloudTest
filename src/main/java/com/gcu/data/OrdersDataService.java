package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity> {
	
	
	@Autowired
	private OrdersRepository ordersRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public OrdersDataService(OrdersRepository ordersRepository, DataSource dataSource){
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public List<OrderEntity> findAll() {
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		try {
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
			
			orders= new ArrayList<OrderEntity>();
			ordersIterable.forEach(orders::add);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return orders;
	}

	public OrderEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean create(OrderEntity order) {
		String sql = "INSERT INTO orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
		try {
			jdbcTemplateObject.update(sql,
										order.getOrderNo(),
										order.getProductName(),
										order.getPrice(),
										order.getQuantity());
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(OrderEntity order) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(OrderEntity order) {
		// TODO Auto-generated method stub
		return false;
	}

}
