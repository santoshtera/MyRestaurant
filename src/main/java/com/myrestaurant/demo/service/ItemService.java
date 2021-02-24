package com.myrestaurant.demo.service;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myrestaurant.demo.entity.ItemVO;
import com.myrestaurant.demo.model.Item;
import com.myrestaurant.demo.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository<ItemVO> itemRepository;
	
	public Item addNewItem(Item item) throws SQLDataException{
		
		ItemVO newItem = new ItemVO();
		newItem.setTitle(item.getTitle());
		newItem.setDescription("Hardcoded Description");
		newItem.setPrice(item.getPrice());
		
		ItemVO dbNewItem = itemRepository.save(newItem);
		
		item.setId(dbNewItem.getItemId());
		return item;
		
	}
	
	public List<ItemVO> ageItems() throws SQLDataException{
		
		List<ItemVO> items = new ArrayList<>();
		itemRepository.findAll()
		.forEach(items :: add);
		
		return items;
		
		
	}
}
