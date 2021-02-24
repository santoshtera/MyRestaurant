package com.myrestaurant.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myrestaurant.demo.entity.OrderDetail;

@Repository
public interface OrderDetailsRepository<P> extends CrudRepository<OrderDetail, Integer> {
	
	
}
