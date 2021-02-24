package com.myrestaurant.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myrestaurant.demo.entity.ItemVO;

@Repository
public interface ItemRepository<P> extends CrudRepository<ItemVO, Integer> {

	
}
