package com.myrestaurant.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_items")
public class ItemVO {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", length = 20, nullable = false)
    private Integer itemId;
 
    @Column(name = "item_name", length = 255, nullable = false)
    private String title;
 
    @Column(name = "item_description", length = 255, nullable = false)
    private String description;
    
    @Column(name = "item_price", nullable = false)
    private double price;

	public Integer getItemId() {
		return itemId;
	}

	public void setId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

  
}
