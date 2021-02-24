package com.myrestaurant.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myrestaurant.demo.entity.Order;

@Repository
public interface OrderRepository<P> extends CrudRepository<Order, Long>{

}
