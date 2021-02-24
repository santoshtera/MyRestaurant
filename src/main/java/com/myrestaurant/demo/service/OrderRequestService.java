package com.myrestaurant.demo.service;

import java.sql.SQLDataException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OrderComparator.OrderSourceProvider;
import org.springframework.stereotype.Service;

import com.myrestaurant.demo.entity.OrderDetail;
import com.myrestaurant.demo.entity.ItemVO;
import com.myrestaurant.demo.entity.Order;
import com.myrestaurant.demo.model.Item;
import com.myrestaurant.demo.model.ItemsInfo;
import com.myrestaurant.demo.model.OrderRequest;
import com.myrestaurant.demo.repository.ItemRepository;
import com.myrestaurant.demo.repository.OrderDetailsRepository;
import com.myrestaurant.demo.repository.OrderRepository;
import com.myrestaurant.demo.util.ProductNotFoundException;

@Service
public class OrderRequestService {

	@Autowired
	OrderRepository<Order> orderRepository;
	
	@Autowired
	ItemRepository<ItemVO> itemRepository;
	
	@Autowired
	OrderDetailsRepository<OrderDetail> orderDetailsRepository;
	
	public Order processOrderRequest(OrderRequest orderRequest) throws SQLDataException,ProductNotFoundException {
		
		Order order = new Order();
		final double amt= 55.00;
		order.setCustomerName(orderRequest.getName());
		order.setCustomerAddress(orderRequest.getAddress());
		order.setCustomerPhone(orderRequest.getPhone());
		order.setAmount(amt);
		
		Order newOrder = orderRepository.save(order);
		
		//setting the order number/confirmation to show it to user
		order.setOrderNum(newOrder.getOrderNum());
				
		for (ItemsInfo item:orderRequest.getItemsInfo()){
			OrderDetail orderDetails = new OrderDetail();
			
			
			orderDetails.setOrder(newOrder);
			Optional<ItemVO> getItem = itemRepository.findById(item.getItemId());
			
			if(getItem != null && getItem.isPresent()) {
				
				orderDetails.setItem(getItem.get());
				orderDetails.setQuanity(item.getQty());
				orderDetailsRepository.save(orderDetails);
		
			} else {
				throw new ProductNotFoundException();
			}
			
		} 

		return order;
	}
}
