package com.myrestaurant.demo.controller;

import java.sql.SQLDataException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myrestaurant.demo.entity.ItemVO;
import com.myrestaurant.demo.entity.Order;
import com.myrestaurant.demo.model.Item;
import com.myrestaurant.demo.model.OrderRequest;
import com.myrestaurant.demo.service.ItemService;
import com.myrestaurant.demo.service.OrderRequestService;
import com.myrestaurant.demo.util.ProductNotFoundException;

@Controller
public class RestaurantController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	OrderRequestService orderRequestService;
	
	@PostMapping("/addItem")
	public ResponseEntity<Item> addItem(@RequestBody Item item) throws SQLDataException {
		
		Item newItem = this.itemService.addNewItem(item);
		
		createResponse(newItem, HttpStatus.CREATED);
		return ResponseEntity.ok().body(item);
	}
	
	@GetMapping("/getMenu")
	public ResponseEntity<List<ItemVO>> getMenuItems() throws SQLDataException {
		
		List<ItemVO> menuItems = this.itemService.ageItems();
		
		return ResponseEntity.ok().body(menuItems);
	}

	private <T> ResponseEntity<T> createResponse(T response, HttpStatus httpStatus) {
		// TODO Auto-generated method stub
		
		ResponseEntity<T> entity;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		if(response == null) {
			entity = new ResponseEntity<T>(responseHeaders, httpStatus);
		}
		else {
			entity = new ResponseEntity<T>(response, responseHeaders, httpStatus);
		}
		
		return entity;
	}
	
	@PostMapping("/postOrder")
	public ResponseEntity<Order> submitOrder(@RequestBody OrderRequest orderRequest) throws Exception {
		
		Order orderNumber = null;
		try {
			orderNumber = this.orderRequestService.processOrderRequest(orderRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(orderNumber);
		}
		catch(RuntimeException e) {
			throw new ProductNotFoundException();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
	}
	
}
