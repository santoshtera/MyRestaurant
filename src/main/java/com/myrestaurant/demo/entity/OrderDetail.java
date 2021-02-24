package com.myrestaurant.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "order_details")
public class OrderDetail {

	@Id
    @Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_number", nullable = false, foreignKey = @ForeignKey(name = "order_detail_ord_fk"))
    private Order order;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false, foreignKey = @ForeignKey(name = "order_detail_item_fk"))
    private ItemVO itemVO;
 
    @Column(name = "quantity", nullable = false)
    private int quanity;
 
   

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ItemVO getItemVO() {
		return itemVO;
	}

	public void setItem(ItemVO itemVO) {
		this.itemVO = itemVO;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

    
}
